package parkingLot;

import java.util.Optional;

public interface ParkingLotSelector {
    Optional<ParkingLot> getParkingLot(ParkingLot... parkingLots);
}
