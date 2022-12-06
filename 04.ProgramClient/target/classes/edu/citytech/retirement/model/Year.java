package edu.citytech.retirement.model;

public class Year {


       private float endingBalance;
       private float interestEarned;
       private int no;
       private float startingBalance;
       private float yearlyDeposit;

    public float getEndingBalance() {
        return endingBalance;
    }

    public void setEndingBalance(float endingBalance) {
        this.endingBalance = endingBalance;
    }

    public float getInterestEarned() {
        return interestEarned;
    }

    public void setInterestEarned(float interestEarned) {
        this.interestEarned = interestEarned;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
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
        return "Year{" +
                "endingBalance=" + endingBalance +
                ", interestedEarned=" + interestEarned +
                ", no=" + no +
                ", startingBalance=" + startingBalance +
                ", yearlyDeposit=" + yearlyDeposit +
                '}';
    }
}
