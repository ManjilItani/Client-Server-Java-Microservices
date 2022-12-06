package edu.citytech.properties;

public class RealEstate {

    private String State;
    private float amount;

    public RealEstate(String state, float amount) {
        State = state;
        this.amount = amount;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "RealEstate{" +
                "State='" + State + '\'' +
                ", amount=" + amount +
                '}';
    }
}
