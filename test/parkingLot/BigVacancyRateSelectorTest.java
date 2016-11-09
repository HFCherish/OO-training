package parkingLot;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BigVacancyRateSelectorTest {
    @Test
    public void should_available_lot_with_biggest_vacancy_rate() {
        ParkingLot lot = new ParkingLot(5);
        ParkingLot lot1 = new ParkingLot(2);
        lot.park(new Car());
        assertThat(new BigVacancyRateSelector().getParkingLot(lot, lot1).get(), is(lot1));
    }

    @Test
    public void should_get_null_if_no_available() {
        assertThat(new BigVacancyRateSelector().getParkingLot(new ParkingLot(0), new ParkingLot(0)).isPresent(), is(false));
    }

}