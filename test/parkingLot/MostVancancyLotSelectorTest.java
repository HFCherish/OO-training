package parkingLot;

import org.junit.Test;

import java.util.Optional;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MostVancancyLotSelectorTest {
    @Test
    public void should_get_the_available_parking_lot_with_most_vacancies() {
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(2);

        Optional<ParkingLot> selected = new MostVancancyLotSelector().getParkingLot(parkingLot1, parkingLot2);
        assertThat(selected.isPresent(), is(true));
        assertThat(selected.get(), is(parkingLot2));
    }

    @Test
    public void should_get_null_if_no_available_parking_lot() {
        Optional<ParkingLot> selected = new MostVancancyLotSelector().getParkingLot(new ParkingLot(0), new ParkingLot(0));
        assertThat(selected.isPresent(), is(false));
    }

}