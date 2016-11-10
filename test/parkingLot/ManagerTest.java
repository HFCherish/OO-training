package parkingLot;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ManagerTest {
    @Test
    public void should_park_if_lot_available() {
        WithParkingCapability full = new ParkingLot(0);
        ParkingLot target = new ParkingLot(1);

        WithParkingCapability manager = new Manager(new DefaultParkingLotSelector(), full, target);
        manager.park(new Car());
        assertThat(target.get(ParkingLot.Usage.USAGE), is(0));
    }

    @Test
    public void should_not_park_if_no_lot_available() {
        WithParkingCapability full = new ParkingLot(0);
        WithParkingCapability full1 = new ParkingLot(0);
        WithParkingCapability manager = new Manager(new DefaultParkingLotSelector(), full, full1);
        assertThat(manager.park(new Car()), is(false));
    }

    @Test
    public void should_unpark_after_park() {
        WithParkingCapability full = new ParkingLot(0);
        ParkingLot target = new ParkingLot(1);

        WithParkingCapability manager = new Manager(new DefaultParkingLotSelector(), full, target);
        Car car = new Car();
        manager.park(car);
        manager.unpark(car);
        assertThat(target.get(ParkingLot.Usage.USAGE), is(1));
    }

    @Test
    public void should_print_useage_with_right_indent() {
        WithParkingCapability defaultManager = new Manager(new DefaultParkingLotSelector(), new ParkingLot(1));
        WithParkingCapability mostVacancyManager = new Manager(new MostVacancyLotSelector(), new ParkingLot(1));
        ParkerSelector selector = new DefaultManagerSelector();

        WithParkingCapability manager = new Manager(selector, defaultManager, mostVacancyManager);
        manager.park(new Car());

        IndentReport report = new IndentReport();
        manager.report(report);

        assertThat(report.toString(), is("Parker:\n" +
                PrinterHelper.getIndent(1) + "Parker:\n" +
                PrinterHelper.getIndent(2) + "ParkingLot: 1/1\n" +
                PrinterHelper.getIndent(1) + "Parker:\n" +
                PrinterHelper.getIndent(2) + "ParkingLot: 0/1\n"));
    }
}