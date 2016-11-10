package parkingLot;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ParkingLotTest {
    @Test
    public void should_park_if_lot_available() {
        ParkingLot parkingLot = new ParkingLot(1);
        assertThat(parkingLot.get(ParkingLot.Usage.USAGE), is(1));

        parkingLot.park(new Car());
        assertThat(parkingLot.get(ParkingLot.Usage.USAGE), is(0));
    }

    @Test
    public void should_not_park_if_no_lot_available() {
        WithParkingCapability parkingLot = new ParkingLot(0);
        assertThat(parkingLot.park(new Car()), is(false));
    }

    @Test
    public void should_unpark_after_park() {
        ParkingLot parkingLot = new ParkingLot(1);
        Car car = new Car();
        parkingLot.park(car);
        parkingLot.unpark(car);
        assertThat(parkingLot.get(ParkingLot.Usage.USAGE), is(1));
    }

    @Test
    public void should_print_useage_with_right_info() {
        ParkingLot parkingLot = new ParkingLot(2);
        parkingLot.park(new Car());

        IndentReport report = new IndentReport(1);
        parkingLot.report(report);

        assertThat(report.toString(), is("    ParkingLot: 1/2\n"));
    }
}