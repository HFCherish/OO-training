package parkingLot;

import java.util.List;
import java.util.Optional;

public interface ParkerSelector {
    Optional<WithParkingAbility> selectParker(List<WithParkingAbility> parkingLots);
}
