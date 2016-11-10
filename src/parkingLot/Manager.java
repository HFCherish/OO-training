package parkingLot;

import java.util.Arrays;
import java.util.Optional;

public class Manager {
    ParkingLot[] parkingLots;
    ParkingLotSelector selector;

    public Manager(ParkingLotSelector selector, ParkingLot... parkingLots) {
        this.parkingLots = parkingLots;
        this.selector = selector;
    }

    public boolean park(Car car) {
        return selector.getParkingLot(parkingLots).map(parkingLot -> parkingLot.park(car)).orElse(false);
    }

    public boolean unpark(Car car) {
        return Arrays.stream(parkingLots).anyMatch(parkingLot -> parkingLot.unpark(car));
    }

}
