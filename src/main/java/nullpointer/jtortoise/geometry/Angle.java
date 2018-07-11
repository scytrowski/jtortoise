package nullpointer.jtortoise.geometry;

public class Angle {
    public final static Angle ZERO = Angle.radians(0);
    private final double value;

    private Angle(double value) {
        this.value = value;
    }

    public static Angle radians(double radiansValue) {
        return new Angle(radiansValue);
    }

    public static Angle degrees(double degreesValue) {
        double radiansValue = Math.PI * degreesValue / 180.0;
        return Angle.radians(radiansValue);
    }

    public double getValue() {
        return value;
    }
}
