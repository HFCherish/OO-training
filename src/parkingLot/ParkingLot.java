package parkingLot;

import java.util.HashSet;
import java.util.Set;

public class ParkingLot implements WithParkingCapability {
    private final int capacity;
    private Set<Car> cars;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        this.cars = new HashSet<Car>(3);
    }

    public static interface Usage<T> {
        Usage<Integer> USAGE = (u, t) -> t-u;
        Usage<Boolean> isFull = (u, t) -> t==u;

        T get(int used, int total);
    }

    @Override
    public <T> T get(Usage<T> usage) {
        return usage.get(cars.size(), capacity);
    }

    @Override
    public boolean park(Car car) {
        if (isFull()) return false;
        return cars.add(car);
    }

    @Override
    public boolean isFull() {
        return get(Usage.isFull);
    }

    @Override
    public boolean unpark(Car car) {
        return cars.remove(car);
    }

    public void report(IndentReport report) {
        report.reportParkingLots(cars.size(), capacity);
    }

}
