package parkingLot;

import java.util.ArrayList;

public class ParkingLot implements WithParkingAbility {
    private final int capacity;
    private ArrayList cars;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        this.cars = new ArrayList(capacity);
    }

    public static interface Usage<T> {
        Usage<Integer> remained = (used, total) -> total - used;
        Usage<Boolean> isAvailable = (used, total) -> total > used;
        T get(int used, int total);
    }

    @Override
    public <T> T get(Usage<T> usage) {
        return usage.get(cars.size(), capacity);
    }

    @Override
    public boolean park(Car car) {
        if(!get(Usage.isAvailable))  return false;
        return cars.add(car);
    }

    @Override
    public boolean unpark(Car car) {
        return cars.remove(car);
    }

    @Override
    public String printUsageAsString(Report report) {
        return report.reportToParkingLot(capacity-cars.size(), capacity);
    }
}
