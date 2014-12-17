package adserver.adserver;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Random;

import adserver.jdbc.JdbcConnector;
import adserver.thrift.AdServerService.Iface;
import adserver.thrift.ad_info;

import javax.sql.rowset.JdbcRowSet;

public class AdServerHandler implements Iface{
	 public List<String> ask4Ads(ad_info info) throws org.apache.thrift.TException{
		 String searchWords = info.getSearchWord();
		 List<AdFeature> candidates = adIndex(searchWords);
		 List<String> ranking = adRank(info, candidates);
		 return ranking;
	 }

	/*
	有多个和搜索查询完全相同的关键词，匹配形式也相同。那么每次点击费用最高的关键词将触发广告。
	如果各关键词的每次点击费用出价相同，系统将随机选择一个关键词显示。
	如果有多个和搜索查询完全相同的关键词，匹配形式不相同。那么系统总是由使用限制性较强的匹配类型的关键词触发广告，
	与每次点击费用出价无关，也就是说完全匹配优先于词组匹配，词组匹配优先性于广泛匹配。
	 */
	List<AdFeature> adIndex(String searchWords){
		List<AdFeature> ret = null;

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
				//完全匹配
				String[] sp_WQPP = GJZ_WQPP.trim().split("|");
				int i;
				for (i=0;i<sp_WQPP.length;i++){
					String[] tmpSp = sp_WQPP[i].split(":");
					if (tmpSp.length!=2)
						continue;
					if (tmpSp[0].equals(searchWords)){
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
				if (matchFlag)
					continue;

				//词组匹配
				String[] sp_CZPP = GJZ_CZPP.trim().split("|");
				for (i=0;i<sp_CZPP.length;i++){
					String[] tmpSp = sp_CZPP[i].split(":");
					if (tmpSp.length!=2)
						continue;
					if (tmpSp[0].contains(searchWords)){
						AdFeature fea = new AdFeature();
						fea.setAdid(GGJH_ID);
						fea.setBid(Double.valueOf(tmpSp[1]));
						fea.setSim_keyword((double)(searchWords.length())/(double)(tmpSp[0].length()));
						fea.setSim_title(calSimilarity(searchWords, BT));
						fea.setMatchType(2);

						ret.add(fea);
						matchFlag = true;
						break;
					}
				}
				if (matchFlag)
					continue;

				//宽泛匹配
				String[] sp_KFPP = GJZ_KFPP.trim().split("|");
				for (i=0;i<sp_KFPP.length;i++){
					String[] tmpSp = sp_KFPP[i].split(":");
					if (tmpSp.length!=2)
						continue;
					AdFeature fea = new AdFeature();
					fea.setAdid(GGJH_ID);
					fea.setBid(Double.valueOf(tmpSp[1]));
					fea.setSim_keyword((double)(searchWords.length())/(double)(tmpSp[0].length()));
					fea.setSim_title(calSimilarity(searchWords, BT));
					fea.setMatchType(2);

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

		return null;
	}

	List<String> adRank(ad_info info, List<AdFeature> candidates){
		return null;
	}


	double calSimilarity(String searchWord, String title){
		Random rnd = new Random(100);
		return rnd.nextFloat();
	}
}
