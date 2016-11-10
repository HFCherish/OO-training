package parkingLot;

import java.util.Arrays;
import java.util.Optional;

public class BigVacancyRateSelector implements ParkerSelector {
    @Override
    public Optional<WithParkingCapability> selectParker(WithParkingCapability... parkingLots) {
        return Arrays.stream(parkingLots).max(((o1, o2) -> o1.get((u,t) -> {
            if( t == 0 )    return  0.0;
            return (t-u) * 1.0 / t;
        })>o2.get((u,t) -> {
            if( t == 0 )    return  0.0;
            return (t-u) * 1.0 / t;
        }) ? 1 : -1)).filter(parkingLot -> !parkingLot.isFull());
    }
}
