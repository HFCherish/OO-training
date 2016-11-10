package parkingLot;

public class PrinterHelper {
    public static String getIndent(int indent) {
        StringBuilder indents = new StringBuilder();
        for( int i=0; i< indent; i++ ){
            indents.append("    ");
        }
        return indents.toString();
    }
}
