package nullpointer.jtortoise.geometry;

public class Point {
    private final double x;
    private final double y;

    private Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public static Point cartesian(double x, double y) {
        return new Point(x, y);
    }
}
