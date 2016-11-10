package parkingLot;

import java.util.List;
import java.util.Optional;

public class DefaultParkingLotSelector implements ParkerSelector {
    @Override
    public Optional<WithParkingAbility> selectParker(List<WithParkingAbility> parkingLots) {
        return parkingLots.stream().filter(parkingLot -> parkingLot.get(ParkingLot.Usage.isAvailable)).findAny();
    }
}
