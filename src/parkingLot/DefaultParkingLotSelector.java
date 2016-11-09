package parkingLot;

import java.util.Arrays;
import java.util.Optional;

public class DefaultParkingLotSelector implements ParkingLotSelector {
    @Override
    public Optional<ParkingLot> getParkingLot(ParkingLot... parkingLots) {
        return Arrays.stream(parkingLots).filter(parkingLot -> !parkingLot.isFull()).findFirst();
    }
}
