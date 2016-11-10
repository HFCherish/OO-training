package parkingLot;

import java.util.Optional;

public interface ManagerSelector {
    Optional<Manager> selectManager(Manager... managers);
}
