package utils;

import adserver.adserver.AdFeature;

import java.util.Comparator;

/**
 * Created by liuyq on 2014/12/18.
 */
public class AdFeatureComparator implements Comparator {

    public int compare(Object o1, Object o2) {
        // TODO Auto-generated method stub
        AdFeature c1 = (AdFeature) o1;
        AdFeature c2 = (AdFeature) o2;
        if (c1.getEcpm() > c2.getEcpm()) {
            return -1;
        } else {
            if (c1.getEcpm() == c2.getEcpm()) {
                return 0;
            } else {
                return 1;
            }
        }
    }
}
