package parkingLot;

public class IndentReport implements Report {
    private int indent = 0;
    StringBuilder report = new StringBuilder();

    public IndentReport() {
    }

    public IndentReport(int indent) {
        this.indent = indent;
    }

    @Override
    public void reportManager(WithParkingCapability[] managed) {
        report.append(getIndent(indent) + "Parker:\n");
        for( WithParkingCapability parkingLot: managed){
            indent = indent + 1;
            parkingLot.report(this);
            indent = indent - 1;
        }

    }

    @Override
    public void reportParkingLots(int size, int capacity) {
        report.append(getIndent(indent) + "ParkingLot: " + size + "/" + capacity +"\n");
    }

    @Override
    public String toString() {
        return report.toString();
    }

    public static String getIndent(int indent) {
        StringBuilder indents = new StringBuilder();
        for( int i=0; i< indent; i++ ){
            indents.append("    ");
        }
        return indents.toString();
    }

}
