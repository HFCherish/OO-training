package parkingLot;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class HigherManagerTest {
    @Test
    public void should_can_designate_a_manager_to_park_after_select_one() {
        WithParkingCapability defaultManager = new Manager(new DefaultParkingLotSelector(), new ParkingLot(1));
        WithParkingCapability mostVacancyManager = new Manager(new MostVacancyLotSelector(), new ParkingLot(0));
        ParkerSelector selector = new DefaultManagerSelector();

        WithParkingCapability higherManager = new Manager(selector, defaultManager, mostVacancyManager);
        assertThat(higherManager.park(new Car()), is(true));
    }

    @Test
    public void should_can_find_the_manager_of_a_car() {
        WithParkingCapability defaultManager = new Manager(new DefaultParkingLotSelector(), new ParkingLot(1));
        ParkerSelector selector = new DefaultManagerSelector();

        WithParkingCapability higherManager = new Manager(selector, defaultManager);
        Car car = new Car();
        higherManager.park(car);
        assertThat(higherManager.unpark(car), is(true));
    }
}