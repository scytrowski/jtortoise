package nullpointer.jtortoise.geometry;

public class Point {
    public final static Point ZERO = Point.cartesian(0, 0);
    private final double x;
    private final double y;

    private Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public static Point cartesian(double x, double y) {
        return new Point(x, y);
    }

    public static Point polar(double radius, Angle angle) {
        double x = radius * angle.cos();
        double y = radius * angle.sin();
        return Point.cartesian(x, y);
    }

    public static double distanceBetween(Point firstPoint, Point secondPoint) {
        Vector vectorBetween = Vector.between(firstPoint, secondPoint);
        return vectorBetween.getLength();
    }

    public double distanceBetween(Point otherPoint) {
        return distanceBetween(this, otherPoint);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Point) {
            Point otherPoint = (Point)obj;
            return x == otherPoint.x && y == otherPoint.y;
        } else
            return false;
    }

    public Vector asVector() {
        return Vector.cartesian(x, y);
    }

    public Point plus(Vector vector) {
        return Point.cartesian(x + vector.getX(), y + vector.getY());
    }

    public Point minus(Vector vector) {
        return Point.cartesian(x - vector.getX(), y - vector.getY());
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
