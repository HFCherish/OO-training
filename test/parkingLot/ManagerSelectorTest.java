package parkingLot;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ManagerSelectorTest {
    @Test
    public void should_able_to_select_one_manager_if_has_manager_with_available_lot() {
        WithParkingAbility full = new ParkingLot(0);
        WithParkingAbility available = new ParkingLot(1);
        WithParkingAbility full_manager = new Manager(new DefaultParkingLotSelector(), full);
        WithParkingAbility manager_with_available_lot = new Manager(new MostVacancyLotSelector(), available);

        ParkerSelector selector = new ManagerSelector();
        assertThat(selector.selectParker(Arrays.asList(full_manager, manager_with_available_lot)).isPresent(), is(true));
        assertThat(selector.selectParker(Arrays.asList(full_manager, manager_with_available_lot)).get(), is(manager_with_available_lot));
    }
}