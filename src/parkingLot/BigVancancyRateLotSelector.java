package parkingLot;

import java.util.Arrays;
import java.util.Optional;

public class BigVancancyRateLotSelector implements ParkingLotSelector {
    @Override
    public Optional<ParkingLot> getParkingLot(ParkingLot... parkingLots) {
        return Arrays.stream(parkingLots).max((o1, o2) -> o1.calcVancancyRate() - o2.calcVancancyRate()).filter(parkingLot -> parkingLot.remainedSize() > 0);
    }
}
