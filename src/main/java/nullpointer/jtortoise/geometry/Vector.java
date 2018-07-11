package nullpointer.jtortoise.geometry;

public class Vector {
    public final static Vector ZERO = Vector.cartesian(0, 0);
    private final double x;
    private final double y;

    private Vector(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public static Vector cartesian(double x, double y) {
        return new Vector(x, y);
    }

    public static Vector polar(double radius, Angle angle) {
        double x = radius * angle.cos();
        double y = radius * angle.sin();
        return Vector.cartesian(x, y);
    }

    public static Vector between(Point firstPoint, Point secondPoint) {
        double dx = secondPoint.getX() - firstPoint.getX();
        double dy = secondPoint.getY() - firstPoint.getY();
        return Vector.cartesian(dx, dy);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Vector) {
            Vector otherVector = (Vector)obj;
            return x == otherVector.x && y == otherVector.y;
        } else
            return false;
    }

    public Point asPoint() {
        return Point.cartesian(x, y);
    }

    public Vector plus(Vector otherVector) {
        return Vector.cartesian(x + otherVector.x, y + otherVector.y);
    }

    public Vector minus(Vector otherVector) {
        return Vector.cartesian(x - otherVector.x, y - otherVector.y);
    }

    public Vector times(double number) {
        return Vector.cartesian(x * number, y * number);
    }

    public Vector by(double number) {
        return Vector.cartesian(x / number, y / number);
    }

    public double getLength() {
        double xSquare = Math.pow(x, 2.0);
        double ySquare = Math.pow(y, 2.0);
        return Math.sqrt(xSquare + ySquare);
    }

    public Angle getAngle() {
        double angleRadiansValue = Math.atan2(y, x);
        return Angle.radians(angleRadiansValue);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
