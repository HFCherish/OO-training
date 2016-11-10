package parkingLot;

import java.util.Optional;

public interface ParkerSelector {
    Optional<WithParkingCapability> selectParker(WithParkingCapability... parkingLots);
}
