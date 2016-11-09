package parkingLot;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ManagerTest {

    @Test
    public void should_be_able_to_park_if_lot_available() {
        int capacity = 1;

        ParkingLot full = new ParkingLot(0);
        ParkingLot target = new ParkingLot(capacity);

        Manager manager = new Manager(new DefaultLotSelector(), full, target);

        manager.helpPark(new Car());

        assertThat(target.remainedSize(), is(capacity - 1));
    }

    @Test
    public void should_not_be_able_to_park_if_lot_not_available() {

        ParkingLot full = new ParkingLot(0);
        ParkingLot full2 = new ParkingLot(0);

        Manager manager = new Manager(new DefaultLotSelector(), full, full2);

        assertThat(manager.helpPark(new Car()), is(false));
    }

    @Test
    public void should_be_able_to_unpark_car() {
        int capacity = 1;

        ParkingLot full = new ParkingLot(0);
        ParkingLot target = new ParkingLot(capacity);

        Manager manager = new Manager(new DefaultLotSelector(), full, target);

        Car car = new Car();
        manager.helpPark(car);

        manager.helpLeave(car);

        assertThat(target.remainedSize(), is(capacity));

    }
}
