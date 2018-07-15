package nullpointer.jtortoise.geometry;

import org.junit.Test;

import static org.junit.Assert.*;

public class PointTest {
    @Test
    public void shouldHaveZeroPointWithCorrectXCoordinate() {
        double zeroPointXCoordinate = Point.ZERO.getX();
        assertEquals(0, zeroPointXCoordinate, 0);
    }

    @Test
    public void shouldHaveZeroPointWithCorrectYCoordinate() {
        double zeroPointYCoordinate = Point.ZERO.getY();
        assertEquals(0, zeroPointYCoordinate, 0);
    }

    @Test
    public void shouldCreateCartesianPointWithCorrectXCoordinate() {
        double expectedX = 3.5567;
        Point point = Point.cartesian(expectedX, 45.781);
        assertEquals(expectedX, point.getX(), 0);
    }

    @Test
    public void shouldCreateCartesianPointWithCorrectYCoordinate() {
        double expectedY = 45.781;
        Point point = Point.cartesian(3.5567, expectedY);
        assertEquals(expectedY, point.getY(), 0);
    }

    @Test
    public void shouldCreatePolarPointWithCorrectXCoordinate() {
        double radius = 34.971;
        Angle angle = Angle.radians(1.781);
        Point point = Point.polar(radius, angle);
        double expectedX = radius * angle.cos();
        assertEquals(expectedX, point.getX(), 0);
    }

    @Test
    public void shouldCreatePolarPointWithCorrectYCoordinate() {
        double radius = 34.971;
        Angle angle = Angle.radians(1.781);
        Point point = Point.polar(radius, angle);
        double expectedY = radius * angle.sin();
        assertEquals(expectedY, point.getY(), 0);
    }

    @Test
    public void shouldReturnCorrectDistanceBetweenTwoPoints() {
        Point firstPoint = Point.cartesian(35.713, -12.741);
        Point secondPoint = Point.cartesian(-5.613, 10.356);
        double distance = Point.distanceBetween(firstPoint, secondPoint);
        Vector vectorBetween = Vector.between(firstPoint, secondPoint);
        double expectedDistance = vectorBetween.getLength();
        assertEquals(expectedDistance, distance, 0);
    }

    @Test
    public void shouldReturnCorrectDistanceBetweenSelfAndOtherPoint() {
        Point selfPoint = Point.cartesian(35.713, -12.741);
        Point otherPoint = Point.cartesian(-5.613, 10.356);
        double distance = selfPoint.distanceBetween(otherPoint);
        double expectedDistance = Point.distanceBetween(selfPoint, otherPoint);
        assertEquals(expectedDistance, distance, 0);
    }

    @Test
    public void shouldEqualWithPointWithSameCoordinates() {
        double x = 34.561;
        double y = -9.153;
        Point firstPoint = Point.cartesian(x, y);
        Point secondPoint = Point.cartesian(x, y);
        assertEquals(firstPoint, secondPoint);
    }

    @Test
    public void shouldNotEqualWithPointWithOtherCoordinates() {
        Point firstPoint = Point.cartesian(3.561, -9.134);
        Point secondPoint = Point.cartesian(-1.53, 98.31);
        assertNotEquals(firstPoint, secondPoint);
    }

    @Test
    public void shouldNotEqualWithObjectOtherThanPoint() {
        Point point = Point.cartesian(5.142, -9.13);
        Object other = new Object();
        assertNotEquals(point, other);
    }

    @Test
    public void shouldHaveCorrectXValueWhenAsVector() {
        Point point = Point.cartesian(-34.901, 21.3941);
        Vector vector = point.asVector();
        assertEquals(point.getX(), vector.getX(), 0);
    }

    @Test
    public void shouldHaveCorrectYValueWhenAsVector() {
        Point point = Point.cartesian(-34.901, 21.3941);
        Vector vector = point.asVector();
        assertEquals(point.getY(), vector.getY(), 0);
    }

    @Test
    public void shouldHaveCorrectXCoordinateAfterPlusWithVector() {
        Point point = Point.cartesian(3.671, -0.661);
        Vector vector = Vector.cartesian(5.193, -1.451);
        Point result = point.plus(vector);
        double expectedX = point.getX() + vector.getX();
        assertEquals(expectedX, result.getX(), 0);
    }

    @Test
    public void shouldHaveCorrectYCoordinateAfterPlusWithVector() {
        Point point = Point.cartesian(3.671, -0.661);
        Vector vector = Vector.cartesian(5.193, -1.451);
        Point result = point.plus(vector);
        double expectedY = point.getY() + vector.getY();
        assertEquals(expectedY, result.getY(), 0);
    }

    @Test
    public void shouldHaveCorrectXCoordinateAfterMinusWithVector() {
        Point point = Point.cartesian(3.671, -0.661);
        Vector vector = Vector.cartesian(5.193, -1.451);
        Point result = point.minus(vector);
        double expectedX = point.getX() - vector.getX();
        assertEquals(expectedX, result.getX(), 0);
    }

    @Test
    public void shouldHaveCorrectYCoordinateAfterMinusWithVector() {
        Point point = Point.cartesian(3.671, -0.661);
        Vector vector = Vector.cartesian(5.193, -1.451);
        Point result = point.minus(vector);
        double expectedY = point.getY() - vector.getY();
        assertEquals(expectedY, result.getY(), 0);
    }
}
