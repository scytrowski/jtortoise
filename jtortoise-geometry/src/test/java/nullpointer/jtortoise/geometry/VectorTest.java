package nullpointer.jtortoise.geometry;

import org.junit.Test;

import static org.junit.Assert.*;

public class VectorTest {
    @Test
    public void shouldHaveZeroVectorWithCorrectXValue() {
        double zeroVectorXValue = Vector.ZERO.getX();
        assertEquals(0, zeroVectorXValue, 0);
    }

    @Test
    public void shouldHaveZeroVectorWithCorrectYValue() {
        double zeroVectorYValue = Vector.ZERO.getY();
        assertEquals(0, zeroVectorYValue, 0);
    }

    @Test
    public void shouldCreateCartesianVectorWithCorrectXValue() {
        double expectedX = 5.8901;
        Vector vector = Vector.cartesian(expectedX, -4.561);
        assertEquals(expectedX, vector.getX(), 0);
    }

    @Test
    public void shouldCreateCartesianVectorWithCorrectYValue() {
        double expectedY = -4.561;
        Vector vector = Vector.cartesian(5.8901, expectedY);
        assertEquals(expectedY, vector.getY(), 0);
    }

    @Test
    public void shouldCreatePolarVectorWithCorrectXValue() {
        double radius = 15.241;
        Angle angle = Angle.radians(1.551);
        Vector vector = Vector.polar(radius, angle);
        double expectedX = radius * angle.cos();
        assertEquals(expectedX, vector.getX(), 0);
    }

    @Test
    public void shouldCreatePolarVectorWithCorrectYValue() {
        double radius = 15.241;
        Angle angle = Angle.radians(1.551);
        Vector vector = Vector.polar(radius, angle);
        double expectedY = radius * angle.sin();
        assertEquals(expectedY, vector.getY(), 0);
    }

    @Test
    public void shouldCreateVectorBetweenWithCorrectXValue() {
        Point firstPoint = Point.cartesian(6.313, -9.541);
        Point secondPoint = Point.cartesian(20.913, -13.4132);
        Vector result = Vector.between(firstPoint, secondPoint);
        double expectedX = secondPoint.getX() - firstPoint.getX();
        assertEquals(expectedX, result.getX(), 0);
    }

    @Test
    public void shouldCreateVectorBetweenWithCorrectYValue() {
        Point firstPoint = Point.cartesian(6.313, -9.541);
        Point secondPoint = Point.cartesian(20.913, -13.4132);
        Vector result = Vector.between(firstPoint, secondPoint);
        double expectedY = secondPoint.getY() - firstPoint.getY();
        assertEquals(expectedY, result.getY(), 0);
    }

    @Test
    public void shouldEqualWithVectorWithSameValues() {
        double x = 56.713;
        double y = -9.135;
        Vector firstVector = Vector.cartesian(x, y);
        Vector secondVector = Vector.cartesian(x, y);
        assertEquals(firstVector, secondVector);
    }

    @Test
    public void shouldNotEqualWithVectorWithOtherValues() {
        Vector firstVector = Vector.cartesian(1.931, -2.156);
        Vector secondVector = Vector.cartesian(10.931, 20.145);
        assertNotEquals(firstVector, secondVector);
    }

    @Test
    public void shouldNotEqualWithObjectOtherThanVector() {
        Vector vector = Vector.cartesian(9.134, -2.314);
        Object other = new Object();
        assertNotEquals(vector, other);
    }

    @Test
    public void shouldHaveCorrectXCoordinateWhenAsPoint() {
        Vector vector = Vector.cartesian(-1.391, 56.781);
        Point point = vector.asPoint();
        assertEquals(vector.getX(), point.getX(), 0);
    }

    @Test
    public void shouldHaveCorrectYCoordinateWhenAsPoint() {
        Vector vector = Vector.cartesian(-1.391, 56.781);
        Point point = vector.asPoint();
        assertEquals(vector.getY(), point.getY(), 0);
    }

    @Test
    public void shouldHaveCorrectXValueAfterPlusWithOtherVector() {
        Vector firstVector = Vector.cartesian(13.521, -9.145);
        Vector secondVector = Vector.cartesian(-1.432, 30.413);
        Vector result = firstVector.plus(secondVector);
        double expectedX = firstVector.getX() + secondVector.getX();
        assertEquals(expectedX, result.getX(), 0);
    }

    @Test
    public void shouldHaveCorrectYValueAfterPlusWithOtherVector() {
        Vector firstVector = Vector.cartesian(13.521, -9.145);
        Vector secondVector = Vector.cartesian(-1.432, 30.413);
        Vector result = firstVector.plus(secondVector);
        double expectedY = firstVector.getY() + secondVector.getY();
        assertEquals(expectedY, result.getY(), 0);
    }

    @Test
    public void shouldHaveCorrectXValueAfterMinusWithOtherVector() {
        Vector firstVector = Vector.cartesian(13.521, -9.145);
        Vector secondVector = Vector.cartesian(-1.432, 30.413);
        Vector result = firstVector.minus(secondVector);
        double expectedX = firstVector.getX() - secondVector.getX();
        assertEquals(expectedX, result.getX(), 0);
    }

    @Test
    public void shouldHaveCorrectYValueAfterMinusWithOtherVector() {
        Vector firstVector = Vector.cartesian(13.521, -9.145);
        Vector secondVector = Vector.cartesian(-1.432, 30.413);
        Vector result = firstVector.minus(secondVector);
        double expectedY = firstVector.getY() - secondVector.getY();
        assertEquals(expectedY, result.getY(), 0);
    }

    @Test
    public void shouldHaveCorrectXValueAfterTimesWithNumber() {
        Vector vector = Vector.cartesian(14.913, -5.613);
        double number = 3.14661;
        Vector result = vector.times(number);
        double expectedX = vector.getX() * number;
        assertEquals(expectedX, result.getX(), 0);
    }

    @Test
    public void shouldHaveCorrectYValueAfterTimesWithNumber() {
        Vector vector = Vector.cartesian(14.913, -5.613);
        double number = 3.14661;
        Vector result = vector.times(number);
        double expectedY = vector.getY() * number;
        assertEquals(expectedY, result.getY(), 0);
    }

    @Test
    public void shouldHaveCorrectXValueAfterByWithNumber() {
        Vector vector = Vector.cartesian(14.913, -5.613);
        double number = 3.14661;
        Vector result = vector.by(number);
        double expectedX = vector.getX() / number;
        assertEquals(expectedX, result.getX(), 0);
    }

    @Test
    public void shouldHaveCorrectYValueAfterByWithNumber() {
        Vector vector = Vector.cartesian(14.913, -5.613);
        double number = 3.14661;
        Vector result = vector.by(number);
        double expectedY = vector.getY() / number;
        assertEquals(expectedY, result.getY(), 0);
    }

    @Test
    public void shouldReturnCorrectVectorLength() {
        Vector vector = Vector.cartesian(3.981, -5.671);
        double xSquare = Math.pow(vector.getX(), 2.0);
        double ySquare = Math.pow(vector.getY(), 2.0);
        double expectedLength = Math.sqrt(xSquare + ySquare);
        assertEquals(expectedLength, vector.getLength(), 0);
    }

    @Test
    public void shouldReturnCorrectVectorAngle() {
        Vector vector = Vector.cartesian(3.981, -5.671);
        double angleRadiansValue = Math.atan2(vector.getY(), vector.getX());
        Angle expectedAngle = Angle.radians(angleRadiansValue);
        assertEquals(expectedAngle, vector.getAngle());
    }
}
