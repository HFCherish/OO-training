package length;

public class Unit {
    protected final double centimeters;

    public Unit(double centimeters) {
        this.centimeters = centimeters;
    }

    public static Unit M = new Unit(100);
    public static Unit CM = new Unit(1);
}
