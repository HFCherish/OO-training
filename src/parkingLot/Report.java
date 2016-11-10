package parkingLot;

import java.util.List;

public class Report {
    private int indent;

    public Report(int indent) {
        this.indent = indent;
    }

    public String reportToParkingLot(int used, int capacity) {
        return getIndent(indent) + "ParkingLot: " + used + "/" + capacity + "\n";
    }

    public String reportToManager(List<WithParkingAbility> parkingLots) {
        StringBuilder res = new StringBuilder(getIndent(indent) + "Parker:\n");
        for (WithParkingAbility lot : parkingLots) {
            indent += 1;
            res.append(lot.printUsageAsString(this));
            indent -= 1;
        }
        return res.toString();

    }

    public static String getIndent(int indent) {
        StringBuilder res = new StringBuilder();
        for( int i=0; i<indent; i++ ) {
            res.append("  ");
        }
        return res.toString();
    }
}
