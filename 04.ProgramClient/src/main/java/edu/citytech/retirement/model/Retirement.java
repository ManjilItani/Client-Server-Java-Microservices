package edu.citytech.retirement.model;

import java.util.Arrays;

public class Retirement {


       private float daily20Days;
       private float daily30Days;
       private float monthlyDeposit;
       private float startingBalance;
       private float yearlyDeposit;

       private Year years[];

    public Year[] getYears() {
        return years;
    }

    public void setYears(Year[] years) {
        this.years = years;
    }

    public float getDaily20Days() {
        return daily20Days;
    }

    public void setDaily20Days(float daily20Days) {
        this.daily20Days = daily20Days;
    }

    public float getDaily30Days() {
        return daily30Days;
    }

    public void setDaily30Days(float daily30Days) {
        this.daily30Days = daily30Days;
    }

    public float getMonthlyDeposit() {
        return monthlyDeposit;
    }

    public void setMonthlyDeposit(float monthlyDeposit) {
        this.monthlyDeposit = monthlyDeposit;
    }

    public float getStartingBalance() {
        return startingBalance;
    }

    public void setStartingBalance(float startingBalance) {
        this.startingBalance = startingBalance;
    }

    public float getYearlyDeposit() {
        return yearlyDeposit;
    }

    public void setYearlyDeposit(float yearlyDeposit) {
        this.yearlyDeposit = yearlyDeposit;
    }

    @Override
    public String toString() {
        return "Retirement{" +
                "daily20Days=" + daily20Days +
                ", daily30Days=" + daily30Days +
                ", monthlyDeposit=" + monthlyDeposit +
                ", startingBalance=" + startingBalance +
                ", yearlyDeposit=" + yearlyDeposit +
                ", years=" + Arrays.toString(years) +
                '}';
    }
}
