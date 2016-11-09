package parkingLot;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MostVacancyLotSelectorTest {
    @Test
    public void should_get_available_lot_with_most_vacancy() {
        ParkingLot lot = new ParkingLot(1);
        ParkingLot lot1 = new ParkingLot(2);

        assertThat(new MostVacancyLotSelector().getParkingLot(lot, lot1).get(), is(lot1));
    }

    @Test
    public void should_get_null_if_no_available() {
        assertThat(new MostVacancyLotSelector().getParkingLot(new ParkingLot(0), new ParkingLot(0)).isPresent(), is(false));
    }

}