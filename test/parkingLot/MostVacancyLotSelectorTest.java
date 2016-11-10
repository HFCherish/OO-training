package parkingLot;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MostVacancyLotSelectorTest {
    @Test
    public void should_able_to_select_one_with_most_vacancy() {
        WithParkingAbility lotWithLessVacancy = new ParkingLot(1);
        WithParkingAbility lotWithMoreVacancy = new ParkingLot(2);
        ParkerSelector selector = new MostVacancyLotSelector();
        assertThat(selector.selectParker(Arrays.asList(lotWithLessVacancy, lotWithMoreVacancy)).isPresent(), is(true));
        assertThat(selector.selectParker(Arrays.asList(lotWithLessVacancy, lotWithMoreVacancy)).get(), is(lotWithMoreVacancy));
    }
}