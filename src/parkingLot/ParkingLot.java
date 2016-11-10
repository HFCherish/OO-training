package parkingLot;

import java.util.HashSet;
import java.util.Set;

public class ParkingLot {
    private final int capacity;
    private Set<Car> cars;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        this.cars = new HashSet<Car>(3);
    }

    public int remainedSize() {
        return capacity - cars.size();
    }

    protected double calcVacancyRate() {
        if (capacity == 0) return 0;
        return remainedSize() * 1.0 / capacity;
    }

    public boolean park(Car car) {
        if (isFull()) return false;
        return cars.add(car);
    }

    protected boolean isFull() {
        return remainedSize() == 0;
    }

    public boolean unpark(Car car) {
        return cars.remove(car);
    }
}
