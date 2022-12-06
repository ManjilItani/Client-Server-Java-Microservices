package edu.citytech.states.model;

public class Property {

    private String id;
    private float cost;
    private String state;
    private float percentage;
    private float netIncome;

    public Property(String id, float cost, String state, float percentage, float netIncome) {
        this.id = id;
        this.cost = cost;
        this.state = state;
        this.percentage = percentage;
        this.netIncome = netIncome;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public float getPercentage() {
        return percentage;
    }

    public void setPercentage(float percentage) {
        this.percentage = percentage;
    }

    public float getNetIncome() {
        return netIncome;
    }

    public void setNetIncome(float netIncome) {
        this.netIncome = netIncome;
    }

    @Override
    public String toString() {
        return "Properties{" +
                "id='" + id + '\'' +
                ", cost=" + cost +
                ", state='" + state + '\'' +
                ", percentage=" + percentage +
                ", netIncome=" + netIncome +
                '}';
    }
}
