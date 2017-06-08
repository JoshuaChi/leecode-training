package packing_lot;

/**
 * Created by Joshua on 6/8/17.
 */
public class DayTicket extends Ticket {

    private Double feeUnit;

    public DayTicket(Long enterTime) {
        super(enterTime);
        feeUnit = 2.0;
    }

    @Override
    protected Double getFeeUnit() {
        return feeUnit;
    }
}
