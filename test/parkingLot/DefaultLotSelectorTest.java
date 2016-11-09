package parkingLot;

import org.junit.Test;

import java.util.Optional;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class DefaultLotSelectorTest {
    @Test
    public void should_get_the_first_available_parking_lot() {
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(2);

        Optional<ParkingLot> selected = new DefaultLotSelector().getParkingLot(parkingLot1, parkingLot2);
        assertThat(selected.isPresent(), is(true));
        assertThat(selected.get(), is(parkingLot1));
    }

    @Test
    public void should_get_null_if_no_available_parking_lot() {
        Optional<ParkingLot> selected = new DefaultLotSelector().getParkingLot(new ParkingLot(0), new ParkingLot(0));
        assertThat(selected.isPresent(), is(false));
    }

}