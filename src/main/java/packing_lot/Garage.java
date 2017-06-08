package packing_lot;

/**
 * Created by Joshua on 6/8/17.
 */
public interface Garage {

    boolean hasLeftSlot();

    Double charge();

    boolean isOpen();

    void recordEnter(Vehicle vehicle);

    void recordLeft(Vehicle vehicle);

    /**
     * If found return slot number, otherwise -1;
     * @return
     */
    int findSlot();

}
