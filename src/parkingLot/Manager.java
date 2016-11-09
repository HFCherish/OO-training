package parkingLot;

import java.util.Arrays;

public class Manager {
    protected ParkingLot[] parkingLots;
    protected ParkingLotSelector selector;

    public Manager(ParkingLotSelector selector, ParkingLot... parkingLots) {
        this.parkingLots = parkingLots;
        this.selector = selector;
    }

    public boolean helpPark(Car car) {
        return selector.getParkingLot(parkingLots).map(lot -> lot.park(car)).orElse(false);
    }

    public boolean helpLeave(Car car) {
        return Arrays.stream(parkingLots).anyMatch(lot -> lot.leave(car));
    }
}
