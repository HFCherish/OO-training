package parkingLot;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class DefaultManagerSelectorTest {
    @Test
    public void should_select_one_manager_if_has_lot_available() {
        Manager defaultManager = new Manager(new DefaultParkingLotSelector(), new ParkingLot(1));
        Manager mostVacancyManager = new Manager(new MostVacancyLotSelector(), new ParkingLot(0));
        ManagerSelector selector = new DefaultManagerSelector();
        assertThat(selector.selectManager(defaultManager, mostVacancyManager).isPresent(), is(true));
    }

    @Test
    public void should_select_null_if_has_not_lot_available() {
        Manager defaultManager = new Manager(new DefaultParkingLotSelector(), new ParkingLot(0));
        Manager mostVacancyManager = new Manager(new MostVacancyLotSelector(), new ParkingLot(0));
        ManagerSelector selector = new DefaultManagerSelector();
        assertThat(selector.selectManager(defaultManager, mostVacancyManager).isPresent(), is(false));
    }
}
