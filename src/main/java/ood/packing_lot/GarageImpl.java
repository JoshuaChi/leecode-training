package ood.packing_lot;

/**
 * Created by Joshua on 6/8/17.
 * US1: as a driver, I want to know if the garage is open or not.
 * US2: as a driver, I want to know if the garage has empty slot.
 * US3: as a driver, I want to enter the garage.
 * US4: as a driver, I want to leave the garage.
 * US5: as a driver, I want to know how much I need to pay after I leave the garage.
 *
 * * US6: as a garage manager, I want to know how much profit for this month or for this period.
 */
public class GarageImpl implements Garage {
    @Override
    public boolean hasLeftSlot() {
        return false;
    }

    @Override
    public Double charge() {
        return null;
    }

    @Override
    public boolean isOpen() {
        return false;
    }

    @Override
    public void recordEnter(Vehicle vehicle) {

    }

    @Override
    public void recordLeft(Vehicle vehicle) {

    }

    @Override
    public int findSlot() {
        return -1;
    }
}
