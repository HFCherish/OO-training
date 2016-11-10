package parkingLot;

import java.util.Arrays;
import java.util.Optional;

public class MostVacancyLotSelector implements ParkerSelector {

    @Override
    public Optional<WithParkingCapability> selectParker(WithParkingCapability... parkingLots) {
        return Arrays.stream(parkingLots).max(((o1, o2) -> o1.get(ParkingLot.Usage.USAGE) - o2.get(ParkingLot.Usage.USAGE))).filter(parkingLot -> !parkingLot.isFull());
    }
}
