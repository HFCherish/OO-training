package parkingLot;

import java.util.HashSet;
import java.util.Set;

public class ParkingLot {
    private int capacity;
    private Set<Car> cars;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        cars = new HashSet<>(capacity);
    }

    protected int calcVancancyRate() {
        if(capacity == 0)   return 0;
        return remainedSize()/capacity;
    }

    public boolean park(Car car) {
        if(remainedSize() > 0) {
            cars.add(car);
            return true;
        }
        return false;
    }

    public int remainedSize() {
        return capacity - cars.size();
    }

    public boolean leave(Car car) {
        return cars.remove(car);
    }
}
