package parkingLot;

import java.util.Arrays;

public class HigherManager {
    private final Manager[] managers;

    public HigherManager(Manager... managers) {
        this.managers = managers;
    }

    public boolean park(ManagerSelector selector, Car car) {
        return selector.selectManager(managers).map(manager -> manager.park(car)).orElse(false);
    }

    public boolean unpark(Car car) {
        return Arrays.stream(managers)
                .filter(manager -> Arrays.stream(manager.parkingLots).anyMatch(parkingLot -> parkingLot.containsCar(car)))
                .findAny().map(manager -> manager.unpark(car)).orElse(false);
    }
}
