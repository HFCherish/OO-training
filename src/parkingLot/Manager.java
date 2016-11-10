package parkingLot;

import java.util.Arrays;

public class Manager implements WithParkingCapability {
    WithParkingCapability[] parkingLots;
    ParkerSelector selector;

    public Manager(ParkerSelector selector, WithParkingCapability... parkingLots) {
        this.parkingLots = parkingLots;
        this.selector = selector;
    }

    @Override
    public <T> T get(ParkingLot.Usage<T> usage) {
        int used = 0;
        int total = 0;
        for (WithParkingCapability parkingLot : parkingLots) {
            used += parkingLot.get((u, t) -> u);
            total += parkingLot.get((u, t) -> t);
        }
        return usage.get(used, total);
    }

    public boolean park(Car car) {
        return selector.selectParker(parkingLots).map(parkingLot -> parkingLot.park(car)).orElse(false);
    }

    @Override
    public boolean isFull() {
        return Arrays.stream(parkingLots).allMatch(parkingLot -> parkingLot.isFull());
    }

    public boolean unpark(Car car) {
        return Arrays.stream(parkingLots).anyMatch(parkingLot -> parkingLot.unpark(car));
    }

    public void report(IndentReport report) {
        report.reportManager(parkingLots);
    }

}
