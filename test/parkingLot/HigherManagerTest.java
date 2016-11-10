package parkingLot;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class HigherManagerTest {
    @Test
    public void should_able_to_designate_a_manager_to_park_with_lot_available() {
        WithParkingAbility full = new ParkingLot(0);
        WithParkingAbility available = new ParkingLot(1);
        WithParkingAbility full_manager = new Manager(new DefaultParkingLotSelector(), full);
        WithParkingAbility manager_with_available_lot = new Manager(new MostVacancyLotSelector(), available);

        WithParkingAbility manager = new Manager(new ManagerSelector(), full_manager, manager_with_available_lot);
        assertThat(manager.park(new Car()), is(true));
        assertThat(available.get(ParkingLot.Usage.isAvailable), is(false));
    }

    @Test
    public void should_not_able_to_park_if_no_lot_available() {
        WithParkingAbility full = new ParkingLot(0);
        WithParkingAbility full2 = new ParkingLot(0);
        WithParkingAbility full_manager = new Manager(new DefaultParkingLotSelector(), full);
        WithParkingAbility full_manager2 = new Manager(new MostVacancyLotSelector(), full2);

        WithParkingAbility manager = new Manager(new ManagerSelector(), full_manager, full_manager2);
        assertThat(manager.park(new Car()), is(false));
    }

    @Test
    public void should_able_to_unpark_after_park() {
        WithParkingAbility full = new ParkingLot(0);
        WithParkingAbility available = new ParkingLot(1);
        WithParkingAbility full_manager = new Manager(new DefaultParkingLotSelector(), full);
        WithParkingAbility manager_with_available_lot = new Manager(new MostVacancyLotSelector(), available);

        WithParkingAbility manager = new Manager(new ManagerSelector(), full_manager, manager_with_available_lot);
        Car car = new Car();
        assertThat(manager.park(car), is(true));
        assertThat(manager.unpark(car), is(true));
        assertThat(available.get(ParkingLot.Usage.isAvailable), is(true));
    }
}