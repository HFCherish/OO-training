package parkingLot;

public interface Report {
    void reportManager(WithParkingCapability[] managed);

    void reportParkingLots(int size, int capacity);
}
