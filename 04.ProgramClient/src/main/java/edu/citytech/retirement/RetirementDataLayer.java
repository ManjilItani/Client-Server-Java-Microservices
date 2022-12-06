package edu.citytech.retirement;

import com.jbbwebsolutions.http.utility.JSONGet;
import edu.citytech.retirement.model.Retirement;

import java.util.Arrays;
import java.util.stream.Stream;

public class RetirementDataLayer {

    public static Retirement getRetirement() {
        String sURL = "http://localhost:9814/retirement";
        var retirementData = JSONGet.submitGet(sURL, Retirement.class);
        return retirementData;
    }
    public static Retirement getRetirement(String years) {
        String sURL = "http://localhost:9814/retirement?years="+years;
        var retirementData = JSONGet.submitGet(sURL, Retirement.class);
        return retirementData;
    }

    public static void main(String[] args) {
        var years= RetirementDataLayer.getRetirement().getYears();
        System.out.println(Arrays.toString(years));
    }
}
