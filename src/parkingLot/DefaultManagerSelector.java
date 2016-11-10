package parkingLot;

import java.util.Arrays;
import java.util.Optional;

public class DefaultManagerSelector implements ManagerSelector {
    @Override
    public Optional<Manager> selectManager(Manager... managers) {
        return Arrays.stream(managers).
                filter(manager -> Arrays.stream(manager.parkingLots).anyMatch(parkingLot -> !parkingLot.isFull())).findAny();
    }
}
