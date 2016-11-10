package parkingLot;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MostVacancyManagerTest {
    @Test
    public void should_help_park_to_the_lot_with_most_vacancy() {
        WithParkingAbility lotWithLessVacancy = new ParkingLot(1);
        WithParkingAbility lotWithMoreVacancy = new ParkingLot(2);
        WithParkingAbility manager = new Manager(new MostVacancyLotSelector(), lotWithLessVacancy, lotWithMoreVacancy);
        assertThat(manager.park(new Car()), is(true));
        assertThat(lotWithMoreVacancy.get(ParkingLot.Usage.remained), is(1));
    }

    @Test
    public void should_not_able_to_park_if_no_lot_available() {
        WithParkingAbility full = new ParkingLot(0);
        WithParkingAbility anotherFull = new ParkingLot(0);
        WithParkingAbility manager = new Manager(new MostVacancyLotSelector(), full, anotherFull);
        assertThat(manager.park(new Car()), is(false));
    }

    @Test
    public void should_help_unpark_after_park() {
        WithParkingAbility lotWithLessVacancy = new ParkingLot(1);
        WithParkingAbility lotWithMoreVacancy = new ParkingLot(2);
        WithParkingAbility manager = new Manager(new MostVacancyLotSelector(), lotWithLessVacancy, lotWithMoreVacancy);
        Car car = new Car();
        assertThat(manager.park(car), is(true));
        assertThat(manager.unpark(car), is(true));
        assertThat(lotWithMoreVacancy.get(ParkingLot.Usage.remained), is(2));
    }

}