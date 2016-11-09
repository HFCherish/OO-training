package parkingLot;

import java.util.Arrays;
import java.util.Optional;

public class BigVacancyRateSelector implements ParkingLotSelector {
    @Override
    public Optional<ParkingLot> getParkingLot(ParkingLot... parkingLots) {
        return Arrays.stream(parkingLots).max(((o1, o2) -> (int) Math.ceil(o1.calcVacancyRate()-o2.calcVacancyRate()))).filter(parkingLot -> !parkingLot.isFull());
    }
}
