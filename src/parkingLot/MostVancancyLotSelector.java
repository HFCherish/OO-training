package parkingLot;

import java.util.Arrays;
import java.util.Optional;

public class MostVancancyLotSelector implements ParkingLotSelector {
    @Override
    public Optional<ParkingLot> getParkingLot(ParkingLot... parkingLots) {
        return Arrays.stream(parkingLots).sorted((o1, o2) -> o2.remainedSize() - o1.remainedSize()).findFirst().filter(parkingLot -> parkingLot.remainedSize()>0);
    }
}
