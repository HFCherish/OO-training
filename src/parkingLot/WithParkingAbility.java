package parkingLot;

public interface WithParkingAbility {
    <T> T get(ParkingLot.Usage<T> usage);

    boolean park(Car car);

    boolean unpark(Car car);

    String printUsageAsString(Report report);
}
