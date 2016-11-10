package parkingLot;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class HigherManagerTest {
    @Test
    public void should_can_designate_a_manager_to_park_after_select_one() {
        Manager defaultManager = new Manager(new DefaultParkingLotSelector(), new ParkingLot(1));
        Manager mostVacancyManager = new Manager(new MostVacancyLotSelector(), new ParkingLot(0));
        ManagerSelector selector = new DefaultManagerSelector();

        HigherManager higherManager = new HigherManager(defaultManager, mostVacancyManager);
        assertThat(higherManager.park(selector, new Car()), is(true));
    }

    @Test
    public void should_can_find_the_manager_of_a_car() {
        Manager defaultManager = new Manager(new DefaultParkingLotSelector(), new ParkingLot(1));
        ManagerSelector selector = new DefaultManagerSelector();

        HigherManager higherManager = new HigherManager(defaultManager);
        Car car = new Car();
        higherManager.park(selector, car);
        assertThat(higherManager.unpark(car), is(true));
    }
}