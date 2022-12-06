package edu.citytech.properties;

import java.util.ArrayList;
import java.util.List;

public class TriStateDataSource {

    public static List<RealEstate> getData() {
        //http call here
        List list = new ArrayList<RealEstate>();
        list.add(new RealEstate("NY", 50_000));
        list.add(new RealEstate("CT", 30_000));
        list.add(new RealEstate("NJ", 40_000));
        return list;

    }


}
