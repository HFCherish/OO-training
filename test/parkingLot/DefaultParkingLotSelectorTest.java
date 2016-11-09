package parkingLot;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class DefaultParkingLotSelectorTest {

    @Test
    public void should_get_first_available_lot() {
        ParkingLot lot = new ParkingLot(1);
        ParkingLot lot1 = new ParkingLot(2);

        assertThat(new DefaultParkingLotSelector().getParkingLot(lot, lot1).get(), is(lot));
    }

    @Test
    public void should_get_null_if_no_available() {
        assertThat(new DefaultParkingLotSelector().getParkingLot(new ParkingLot(0), new ParkingLot(0)).isPresent(), is(false));
    }
}