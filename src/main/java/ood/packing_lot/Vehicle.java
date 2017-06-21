package ood.packing_lot;

/**
 * Created by Joshua on 6/8/17.
 */
public abstract class Vehicle {
    protected String carNumber;

    public Vehicle(String no) {
        carNumber = no;
    }

    public String getNumber() {
        return carNumber;
    }
}
