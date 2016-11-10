package parkingLot;

import java.util.List;
import java.util.Optional;

public class MostVacancyLotSelector implements ParkerSelector {

    @Override
    public Optional<WithParkingAbility> selectParker(List<WithParkingAbility> parkingLots) {
        return parkingLots.stream().max(((o1, o2) -> o1.get(ParkingLot.Usage.remained) - (int) o2.get(ParkingLot.Usage.remained)));
    }
}
