package parkingLot;

import java.util.Arrays;
import java.util.Optional;

public class DefaultManagerSelector implements ParkerSelector {
    @Override
    public Optional<WithParkingCapability> selectParker(WithParkingCapability... managers) {
        return Arrays.stream(managers).
                filter(manager -> !manager.isFull()).findAny();
    }
}
