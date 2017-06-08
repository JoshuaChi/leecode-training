package packing_lot;

/**
 * Created by Joshua on 6/8/17.
 */
public class NightTicket extends Ticket {

    private Double feeUnit;

    public NightTicket(Long enterTime) {
        super(enterTime);
        feeUnit = 1.00;
    }

    @Override
    protected Double getFeeUnit() {
        return feeUnit;
    }
}
