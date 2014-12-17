package adserver.adserver;

/**
 * Created by liuyq on 2014/12/16.
 */
public class AdFeature {
    private String adid;
    private String browser;
    private String os;
    private int hour;
    private String region;
    //private String materialType;
    //private String position;
    private double sim_title;
    private double sim_keyword;
    private int matchType;//0:相等 1：包含 2：相似

    public double bid;

    public double getBid() {
        return bid;
    }

    public void setBid(double bid) {
        this.bid = bid;
    }

    public AdFeature(){
        adid = null;
        browser = null;
        os = null;
        hour = -1;
        region = null;
        sim_keyword = -1.0;
        sim_title = -1.0;
        matchType = -1;
        bid = -1.0;
    }

    public AdFeature(String adid_tmp, String browser_tmp, String os_tmp, int hour_tmp, String region_tmp, double sim_title_tmp, double sim_keyword_tmp, int matchType_tmp){
        adid = adid_tmp;
        browser = browser_tmp;
        os = os_tmp;
        hour = hour_tmp;
        region = region_tmp;
        sim_keyword = sim_keyword_tmp;
        sim_title = sim_title_tmp;
        matchType = matchType_tmp;
    }

    public String getAdid() {
        return adid;
    }

    public void setAdid(String adid) {
        this.adid = adid;
    }
    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public double getSim_title() {
        return sim_title;
    }

    public void setSim_title(double sim_title) {
        this.sim_title = sim_title;
    }

    public double getSim_keyword() {
        return sim_keyword;
    }

    public void setSim_keyword(double sim_keyword) {
        this.sim_keyword = sim_keyword;
    }

    public int getMatchType() {
        return matchType;
    }

    public void setMatchType(int matchType) {
        this.matchType = matchType;
    }




}
