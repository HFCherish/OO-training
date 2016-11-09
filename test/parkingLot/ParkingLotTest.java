package parkingLot;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ParkingLotTest {

    @Test
    public void should_be_able_to_park_if_lot_available() {
        int capacity = 1;

        ParkingLot target = new ParkingLot(capacity);

        target.park(new Car());

        assertThat(target.remainedSize(), is(capacity - 1));
    }

    @Test
    public void should_not_be_able_to_park_if_lot_not_available() {
        ParkingLot target = new ParkingLot(0);

        assertThat(target.park(new Car()), is(false));
    }

    @Test
    public void should_be_able_to_unpark_car() {
        int capacity = 1;

        ParkingLot target = new ParkingLot(capacity);

        Car car = new Car();
        target.park(car);
        target.leave(car);

        assertThat(target.remainedSize(), is(capacity));
    }
}
