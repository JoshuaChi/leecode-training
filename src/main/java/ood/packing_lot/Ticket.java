package ood.packing_lot;

import java.util.UUID;

/**
 * Created by Joshua on 6/8/17.
 */
public abstract class Ticket {
    protected String ticketNumber;
    protected Long enterTime; //second
    protected Long leftTime; //second
    protected String carNumber;
    protected int slotNumber;

    public Ticket(Long enterTime) {
        this.enterTime = enterTime;
        this.ticketNumber = UUID.randomUUID().toString();
    }

    public boolean validateTicketAndVehicle(String ticketNumber, String carNumber) {
        if (ticketNumber == this.ticketNumber && carNumber == this.carNumber) {
            return true;
        }
        return false;
    }

    public Double calculateFee() {
        return calculateHours() * getFeeUnit();
    }

    public void recordLeaveTime(Long leftTime) {
        this.leftTime = leftTime;
    }

    public void recordCarNumber(String no) {
        this.carNumber = no;
    }

    public void recordSlotNumber(int no) {
        this.slotNumber = no;
    }

    protected int calculateHours () {
        return (int) ((leftTime - enterTime)/3600);
    }

    protected abstract Double getFeeUnit();

}
