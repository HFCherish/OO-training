package parkingLot;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class DefaultParkingLotSelectorTest {
    @Test
    public void should_able_to_select_one_if_has_lot_available() {
        WithParkingAbility full = new ParkingLot(0);
        WithParkingAbility available = new ParkingLot(1);
        ParkerSelector selector = new DefaultParkingLotSelector();
        assertThat(selector.selectParker(Arrays.asList(full, available)).isPresent(), is(true));
    }
}