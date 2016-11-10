package parkingLot;

import java.util.List;
import java.util.Optional;

public class ManagerSelector implements ParkerSelector {
    public Optional<WithParkingAbility> selectParker(List<WithParkingAbility> managers) {
        return managers.stream().filter(manager -> manager.get(ParkingLot.Usage.isAvailable)).findAny();
    }
}
