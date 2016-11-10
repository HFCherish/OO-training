package parkingLot;

public interface WithParkingCapability {
    <T> T get(ParkingLot.Usage<T> usage);

    boolean park(Car car);

    boolean isFull();

    boolean unpark(Car car);

    void report(IndentReport report);
}
