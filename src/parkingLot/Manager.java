package parkingLot;

import java.util.Arrays;
import java.util.List;

public class Manager implements WithParkingAbility {
    List<WithParkingAbility> parkingLots;
    ParkerSelector selector;

    public Manager(ParkerSelector selector, WithParkingAbility... lots) {
        this.parkingLots = Arrays.asList(lots);
        this.selector = selector;
    }

    @Override
    public <T> T get(ParkingLot.Usage<T> usage) {
        int used = 0;
        int total = 0;
        for (WithParkingAbility parkingLot : parkingLots) {
            used += parkingLot.get((u, t) -> u);
            total += parkingLot.get((u, t) -> t);
        }
        return usage.get(used, total);
    }

    public boolean park(Car car) {
        return selector.selectParker(parkingLots).map(parkingLot -> parkingLot.park(car)).orElse(false);
    }

    public boolean unpark(Car car) {
        return parkingLots.stream().anyMatch(parkingLot -> parkingLot.unpark(car));
    }

    @Override
    public String printUsageAsString(Report report) {
        return report.reportToManager(parkingLots);
    }
}
