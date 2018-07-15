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

    public static Angle between(Point firstPoint, Point secondPoint) {
        Vector vectorBetween = Vector.between(firstPoint, secondPoint);
        return vectorBetween.getAngle();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Angle) {
            Angle otherAngle = (Angle)obj;
            return value == otherAngle.value;
        } else
            return false;
    }

    public Angle plus(Angle otherAngle) {
        return new Angle(value + otherAngle.value);
    }

    public Angle minus(Angle otherAngle) {
        return new Angle(value - otherAngle.value);
    }

    public Angle times(double number) {
        return new Angle(value * number);
    }

    public Angle by(double number) {
        return new Angle(value / number);
    }

    public double sin() {
        return Math.sin(value);
    }

    public double cos() {
        return Math.cos(value);
    }

    public double getValue() {
        return value;
    }
}
