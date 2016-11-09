package parkingLot;

import java.util.Arrays;
import java.util.Optional;

public class MostVacancyLotSelector implements ParkingLotSelector {

    @Override
    public Optional<ParkingLot> getParkingLot(ParkingLot... parkingLots) {
        return Arrays.stream(parkingLots).max(((o1, o2) -> o1.remainedSize() - o2.remainedSize())).filter(parkingLot -> !parkingLot.isFull());
    }
}
