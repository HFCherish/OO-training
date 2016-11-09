package parkingLot;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ParkingLotTest {
    @Test
    public void should_park_if_lot_available() {
        ParkingLot parkingLot = new ParkingLot(1);
        assertThat(parkingLot.remainedSize(), is(1));

        parkingLot.park(new Car());
        assertThat(parkingLot.remainedSize(), is(0));
    }

    @Test
    public void should_not_park_if_no_lot_available() {
        ParkingLot parkingLot = new ParkingLot(0);
        assertThat(parkingLot.park(new Car()), is(false));
    }

    @Test
    public void should_unpark_after_park() {
        ParkingLot parkingLot = new ParkingLot(1);
        Car car = new Car();
        parkingLot.park(car);
        parkingLot.unpark(car);
        assertThat(parkingLot.remainedSize(), is(1));
    }
}