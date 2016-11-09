package parkingLot;

import java.util.Arrays;
import java.util.Optional;

public class DefaultLotSelector implements ParkingLotSelector {
    @Override
    public Optional<ParkingLot> getParkingLot(ParkingLot... parkingLots) {
        return Arrays.stream(parkingLots).filter(lot -> lot.remainedSize() > 0).findAny();
    }
}
