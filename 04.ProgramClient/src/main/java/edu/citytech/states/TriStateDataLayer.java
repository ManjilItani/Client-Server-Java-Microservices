package edu.citytech.states;

import com.jbbwebsolutions.http.utility.JSONGet;
import edu.citytech.states.model.Property;
import edu.citytech.states.model.TriState;

import java.util.stream.Stream;

public class TriStateDataLayer {

    public static Property[] getProperties() {
        String sURL = "http://localhost:9615/properties/";
        var propertiesData = JSONGet.submitGet(sURL, Property[].class);
//        System.out.println(propertiesData.getClass().getSimpleName());
        return propertiesData;
    }


    public static TriState[] getData(String... states) {

        var queryString = String.join(",", states);

        String sURL = "http://localhost:9615/allStates?states="+ queryString;


        var state = JSONGet.submitGet(sURL, TriState[].class);
        return state;
    }

    public static void main(String[] args) {
        var states = TriStateDataLayer.getProperties();
        Stream.of(states).forEach(System.out::println);
    }
}
