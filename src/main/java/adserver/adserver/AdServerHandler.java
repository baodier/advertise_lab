package adserver.adserver;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.*;
import java.util.Collections;

import adserver.jdbc.JdbcConnector;
import adserver.thrift.AdServerService.Iface;
import adserver.thrift.ad_info;
import utils.AdFeatureComparator;

import javax.sql.rowset.JdbcRowSet;

public class AdServerHandler implements Iface{
	 public List<String> ask4Ads(ad_info info) throws org.apache.thrift.TException{
		 System.out.println("---- new query ----");
		 String searchWords = info.getSearchWord();
		 System.out.println("search word is : " + searchWords);
		 List<AdFeature> candidates = adIndex(searchWords);
		 System.out.println("candidate len : " + String.valueOf(candidates.size()));
		 List<String> ranking = adRank(info, candidates);
		 System.out.println("ranking len : " + String.valueOf(ranking.size()));
		 for (String item : ranking){
			 System.out.println("ranking item : " + item);
		 }
		 return ranking;

}
	/*
	有多个和搜索查询完全相同的关键词，匹配形式也相同。那么每次点击费用最高的关键词将触发广告。
	如果各关键词的每次点击费用出价相同，系统将随机选择一个关键词显示。
	如果有多个和搜索查询完全相同的关键词，匹配形式不相同。那么系统总是由使用限制性较强的匹配类型的关键词触发广告，
	与每次点击费用出价无关，也就是说完全匹配优先于词组匹配，词组匹配优先性于广泛匹配。
	 */
	List<AdFeature> adIndex(String searchWords){
		List<AdFeature> ret = new ArrayList<AdFeature>();

		JdbcConnector jdbcConn = new JdbcConnector();
		try {
			// 初始化数据库连接(在finally中关闭连接)
			jdbcConn.initial();
			JdbcRowSet jdbcRs = jdbcConn.jdbcRs;
			jdbcRs.setCommand("select * from ggjhgjz");
			jdbcRs.execute();
			jdbcRs.beforeFirst();

			while (jdbcRs.next()) {
				String GGJH_ID = jdbcRs.getString("GGJH_ID");
				String BT = jdbcRs.getString("BT");
				String GJZ_WQPP = jdbcRs.getString("GJZ_WQPP");
				String GJZ_CZPP = jdbcRs.getString("GJZ_CZPP");
				String GJZ_KFPP = jdbcRs.getString("GJZ_KFPP");

				System.out.println(GGJH_ID+"\t"+BT+"\t"+GJZ_WQPP+"\t"+GJZ_CZPP+"\t"+GJZ_KFPP);

				boolean matchFlag = false;
				int i;
				//完全匹配
				if (GJZ_WQPP != null) {
					String[] sp_WQPP = GJZ_WQPP.trim().split("\\|");

					for (i = 0; i < sp_WQPP.length; i++) {
						String[] tmpSp = sp_WQPP[i].split(":");
						if (tmpSp.length != 2)
							continue;
						if (tmpSp[0].equals(searchWords)) {
							AdFeature fea = new AdFeature();
							fea.setAdid(GGJH_ID);
							fea.setBid(Double.valueOf(tmpSp[1]));
							fea.setSim_keyword(1.0);
							fea.setSim_title(calSimilarity(searchWords, BT));
							fea.setMatchType(1);

							ret.add(fea);
							matchFlag = true;
							break;
						}
					}
				}
				if (matchFlag)
					continue;

				//词组匹配
				if (GJZ_CZPP != null) {
					String[] sp_CZPP = GJZ_CZPP.trim().split("\\|");
					for (i = 0; i < sp_CZPP.length; i++) {
						String[] tmpSp = sp_CZPP[i].split(":");
						if (tmpSp.length != 2)
							continue;
						if (tmpSp[0].contains(searchWords)) {
							AdFeature fea = new AdFeature();
							fea.setAdid(GGJH_ID);
							fea.setBid(Double.valueOf(tmpSp[1]));
							fea.setSim_keyword((double) (searchWords.length()) / (double) (tmpSp[0].length()));
							fea.setSim_title(calSimilarity(searchWords, BT));
							fea.setMatchType(2);

							ret.add(fea);
							matchFlag = true;
							break;
						}
					}
				}
				if (matchFlag)
					continue;

				//宽泛匹配
				if (GJZ_KFPP != null) {
					double max_sim = -1.0;
					int max_index = -1;
					String[] sp_KFPP = GJZ_KFPP.trim().split("\\|");
					for (i = 0; i < sp_KFPP.length; i++) {
						String[] tmpSp = sp_KFPP[i].split(":");
						if (tmpSp.length != 2)
							continue;
						double tmpSim = calSimilarity(searchWords, tmpSp[0]);
						if (tmpSim > max_sim) {
							max_sim = tmpSim;
							max_index = i;
						}
					}
					String[] tmpSp = sp_KFPP[max_index].split(":");
					AdFeature fea = new AdFeature();
					fea.setAdid(GGJH_ID);
					fea.setBid(Double.valueOf(tmpSp[1]));
					fea.setSim_keyword(calSimilarity(searchWords, tmpSp[0]));
					fea.setSim_title(calSimilarity(searchWords, BT));
					fea.setMatchType(3);

					ret.add(fea);
				}
			}

		} catch (SQLException e) {
			String message = "Error while executing sql query";
			System.out.println(message);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			// 关闭数据库连接
			jdbcConn.close();
			// 返回查询结果
		}

		return ret;
	}

	List<String> adRank(ad_info info, List<AdFeature> candidates){
		int i = 0;
		double w_x = 0.0;
		HashMap<String, Double> weights = new HashMap<String, Double>();

		File file = new File("model_weight.txt");
		BufferedReader reader = null;
		try {
			System.out.println("以行为单位读取文件内容，一次读一整行：");
			reader = new BufferedReader(new FileReader(file));
			String tempString = null;
			int line = 1;
			// 一次读入一行，直到读入null为文件结束
			while ((tempString = reader.readLine()) != null) {
				// 显示行号
				System.out.println("line " + line + ": " + tempString);
				if (tempString != null) {
					String[] tmpSp = tempString.trim().split(":");
					if (tmpSp.length == 2) {
						weights.put(tmpSp[0], Double.valueOf(tmpSp[1]));
					}
				}
				line++;
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e1) {
				}
			}
		}

		System.out.println("ready to cal ctr");
		if (weights.containsKey("browser&"+info.getBrowser()))
			w_x = weights.get("browser&"+info.getBrowser());
		if (weights.containsKey("os&"+info.getOs()))
			w_x += weights.get("os&"+info.getOs());
		if (weights.containsKey("region&"+info.getRegion()))
			w_x += weights.get("region&"+info.getRegion());
		if (weights.containsKey("hour&"+String.valueOf(info.getHour())))
			w_x += weights.get("hour&"+String.valueOf(info.getHour()));

		double tmpWX = w_x;
		for (i=0; i<candidates.size(); i++){
			tmpWX = w_x;
			tmpWX += weights.get("sim_keyword")*candidates.get(i).getSim_keyword();
			tmpWX += weights.get("sim_title")*candidates.get(i).getSim_title();
			tmpWX += weights.get("matchType&"+String.valueOf(candidates.get(i).getMatchType()));

			double ctr = 1.0/(1.0+Math.exp(0.0-tmpWX));
			double ecpm = ctr * candidates.get(i).getBid();

			candidates.get(i).setCtr(ctr);
			candidates.get(i).setEcpm(ecpm);
		}

		AdFeatureComparator comp = new AdFeatureComparator();
		Collections.sort(candidates, comp);

		List<String> ret = new ArrayList<String>();
		for (i=0;i<candidates.size();i++)
			ret.add(candidates.get(i).getAdid());

		System.out.println("ca ctr done");
		return ret;
	}


	double calSimilarity(String searchWord, String title){
		return java.lang.Math.random();
	}
}
