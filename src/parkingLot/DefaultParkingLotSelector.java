package parkingLot;

import java.util.Arrays;
import java.util.Optional;

public class DefaultParkingLotSelector implements ParkerSelector {
    @Override
    public Optional<WithParkingCapability> selectParker(WithParkingCapability... parkingLots) {
        return Arrays.stream(parkingLots).filter(parkingLot -> !parkingLot.isFull()).findFirst();
    }
}
