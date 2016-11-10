package parkingLot;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class DefaultParkingLotSelectorTest {

    @Test
    public void should_get_first_available_lot() {
        WithParkingCapability lot = new ParkingLot(1);
        WithParkingCapability lot1 = new ParkingLot(2);

        assertThat(new DefaultParkingLotSelector().selectParker(lot, lot1).get(), is(lot));
    }

    @Test
    public void should_get_null_if_no_available() {
        assertThat(new DefaultParkingLotSelector().selectParker(new ParkingLot(0), new ParkingLot(0)).isPresent(), is(false));
    }
}