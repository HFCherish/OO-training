package parkingLot;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ManagerTest {
    @Test
    public void should_help_park_if_has_lot_available() {
        WithParkingAbility full = new ParkingLot(0);
        WithParkingAbility available = new ParkingLot(1);
        WithParkingAbility manager = new Manager(new DefaultParkingLotSelector(), full, available);
        assertThat(manager.park(new Car()), is(true));
        assertThat(available.get(ParkingLot.Usage.isAvailable), is(false));
    }

    @Test
    public void should_not_able_to_park_if_no_lot_available() {
        WithParkingAbility full = new ParkingLot(0);
        WithParkingAbility available = new ParkingLot(1);
        WithParkingAbility manager = new Manager(new DefaultParkingLotSelector(), full, available);
        assertThat(manager.park(new Car()), is(true));
        assertThat(available.get(ParkingLot.Usage.isAvailable), is(false));
        assertThat(manager.park(new Car()), is(false));
    }

    @Test
    public void should_help_unpark_after_park() {
        WithParkingAbility full = new ParkingLot(0);
        WithParkingAbility available = new ParkingLot(1);
        WithParkingAbility manager = new Manager(new DefaultParkingLotSelector(), full, available);
        Car car = new Car();
        assertThat(manager.park(car), is(true));
        assertThat(manager.unpark(car), is(true));
        assertThat(available.get(ParkingLot.Usage.isAvailable), is(true));
    }

    @Test
    public void should_print_usage() {
        ParkingLot full_lot = new ParkingLot(1);
        full_lot.park(new Car());
        ParkingLot available_lot = new ParkingLot(1);
        Manager full_manager = new Manager(new DefaultParkingLotSelector(), full_lot);
        Manager available_manager = new Manager(new DefaultParkingLotSelector(), available_lot);
        Manager higherManager = new Manager(new ManagerSelector(), full_manager, available_manager);

        assertThat(higherManager.printUsageAsString(new Report(0)), is("Parker:\n" +
                Report.getIndent(1) + "Parker:\n" +
                Report.getIndent(2) + "ParkingLot: 0/1\n" +
                Report.getIndent(1) + "Parker:\n" +
                Report.getIndent(2) + "ParkingLot: 1/1\n"));
    }
}