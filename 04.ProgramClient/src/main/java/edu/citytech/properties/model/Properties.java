package edu.citytech.properties.model;

import java.util.Arrays;

public class Properties {


       private int count;

    private Investment investments[];

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Investment[] getInvestments() {
        return investments;
    }

    public void setInvestments(Investment[] investments) {
        this.investments = investments;
    }

    @Override
    public String toString() {
        return "Properties{" +
                "count=" + count +
                ", investment=" + Arrays.toString(investments) +
                '}';
    }
}
