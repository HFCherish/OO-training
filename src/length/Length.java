package length;

public class Length {
    private final double quantity;
    private final Unit unit;

    public Length(double quantity, Unit unit) {
        this.quantity = quantity;
        this.unit = unit;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Length) {
            return toCentimeters() == ((Length) o).toCentimeters();
        }
        return false;
    }

    private double toCentimeters() {
        return quantity * unit.centimeters;
    }
}
