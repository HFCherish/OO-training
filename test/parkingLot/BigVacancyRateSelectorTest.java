package parkingLot;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BigVacancyRateSelectorTest {
    @Test
    public void should_available_lot_with_biggest_vacancy_rate() {
        WithParkingCapability lot = new ParkingLot(5);
        WithParkingCapability lot1 = new ParkingLot(2);
        lot.park(new Car());
        assertThat(new BigVacancyRateSelector().selectParker(lot, lot1).get(), is(lot1));
    }

    @Test
    public void should_get_null_if_no_available() {
        assertThat(new BigVacancyRateSelector().selectParker(new ParkingLot(0), new ParkingLot(0)).isPresent(), is(false));
    }

}