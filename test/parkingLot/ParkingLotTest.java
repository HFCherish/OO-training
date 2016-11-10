package parkingLot;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ParkingLotTest {
    @Test
    public void should_able_to_park_if_lot_available() {
        WithParkingAbility lot = new ParkingLot(1);
        assertThat(lot.park(new Car()), is(true));
        assertThat(lot.get(ParkingLot.Usage.isAvailable), is(false));
    }

    @Test
    public void should_not_able_to_park_if_lot_not_available() {
        WithParkingAbility lot = new ParkingLot(1);
        assertThat(lot.park(new Car()), is(true));
        assertThat(lot.park(new Car()), is(false));
    }

    @Test
    public void should_able_to_unpark_after_parked() {
        WithParkingAbility lot = new ParkingLot(1);
        Car car = new Car();
        assertThat(lot.park(car), is(true));
        assertThat(lot.unpark(car), is(true));
        assertThat(lot.get(ParkingLot.Usage.isAvailable), is(true));
    }

    @Test
    public void should_print_usage() {
        ParkingLot lot = new ParkingLot(1);
        lot.park(new Car());

        assertThat(lot.printUsageAsString(new Report(1)), is(Report.getIndent(1) + "ParkingLot: 0/1\n"));
    }
}