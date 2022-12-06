package edu.citytech.properties.model;

public class Investment {

       private  int id;
       private float expense;
       private float grossIncome;
       private float investmentCost;
       private float netIncome;
       private int occupancy;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getExpense() {
        return expense;
    }

    public void setExpense(float expense) {
        this.expense = expense;
    }

    public float getGrossIncome() {
        return grossIncome;
    }

    public void setGrossIncome(float grossIncome) {
        this.grossIncome = grossIncome;
    }

    public float getInvestmentCost() {
        return investmentCost;
    }

    public void setInvestmentCost(float investmentCost) {
        this.investmentCost = investmentCost;
    }

    public float getNetIncome() {
        return netIncome;
    }

    public void setNetIncome(float netIncome) {
        this.netIncome = netIncome;
    }

    public int getOccupancy() {
        return occupancy;
    }

    public void setOccupancy(int occupancy) {
        this.occupancy = occupancy;
    }

    @Override
    public String toString() {
        return "Investments{" +
                "id=" + id +
                ", expenses=" + expense +
                ", grossIncome=" + grossIncome +
                ", investmentCost=" + investmentCost +
                ", netIncome=" + netIncome +
                ", occupancy=" + occupancy +
                '}';
    }
}
