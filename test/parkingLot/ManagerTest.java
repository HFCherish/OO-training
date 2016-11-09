package parkingLot;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ManagerTest {
    @Test
    public void should_park_if_lot_available() {
        ParkingLot full = new ParkingLot(0);
        ParkingLot target = new ParkingLot(1);

        Manager manager = new Manager(new DefaultParkingLotSelector(), full, target);
        manager.helpPark(new Car());
        assertThat(target.remainedSize(), is(0));
    }

    @Test
    public void should_not_park_if_no_lot_available() {
        ParkingLot full = new ParkingLot(0);
        ParkingLot full1 = new ParkingLot(0);
        Manager manager = new Manager(new DefaultParkingLotSelector(), full, full1);
        assertThat(manager.helpPark(new Car()), is(false));
    }

    @Test
    public void should_unpark_after_park() {
        ParkingLot full = new ParkingLot(0);
        ParkingLot target = new ParkingLot(1);

        Manager manager = new Manager(new DefaultParkingLotSelector(), full, target);
        Car car = new Car();
        manager.helpPark(car);
        manager.helpUnpark(car);
        assertThat(target.remainedSize(), is(1));
    }
}