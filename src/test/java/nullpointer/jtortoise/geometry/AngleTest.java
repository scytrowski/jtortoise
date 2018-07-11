package nullpointer.jtortoise.geometry;

import org.junit.Test;

import static org.junit.Assert.*;

public class AngleTest {
    @Test
    public void shouldHaveZeroAngleWithCorrectValue() {
        double zeroAngleValue = Angle.ZERO.getValue();
        assertEquals(0, zeroAngleValue, 0);
    }

    @Test
    public void shouldCreateRadiansAngleWithCorrectValue() {
        double expectedValue = 2.567;
        Angle angle = Angle.radians(expectedValue);
        assertEquals(expectedValue, angle.getValue(), 0);
    }

    @Test
    public void shouldCreateDegreesAngleWithCorrectValue() {
        double degreesValue = 145.32;
        Angle angle = Angle.degrees(degreesValue);
        double expectedValue = Math.PI * degreesValue / 180.0;
        assertEquals(expectedValue, angle.getValue(), 0);
    }

    @Test
    public void shouldCreateAngleBetweenWithCorrectValue() {
        Point firstPoint = Point.cartesian(3.657, -17.013);
        Point secondPoint = Point.cartesian(67.134, -50.65);
        Angle angle = Angle.between(firstPoint, secondPoint);
        double dx = secondPoint.getX() - firstPoint.getX();
        double dy = secondPoint.getY() - firstPoint.getY();
        double expectedValue = Math.atan2(dy, dx);
        assertEquals(expectedValue, angle.getValue(), 0);
    }

    @Test
    public void shouldEqualWithAngleWithSameValue() {
        double radiansValue = 1.456;
        Angle firstAngle = Angle.radians(radiansValue);
        Angle secondAngle = Angle.radians(radiansValue);
        assertEquals(firstAngle, secondAngle);
    }

    @Test
    public void shouldNotEqualWithAngleWithOtherValue() {
        Angle firstAngle = Angle.radians(1.456);
        Angle secondAngle = Angle.radians(0.413);
        assertNotEquals(firstAngle, secondAngle);
    }

    @Test
    public void shouldNotEqualWithObjectOtherThanAngle() {
        Angle angle = Angle.radians(0.913);
        Object other = new Object();
        assertNotEquals(angle, other);
    }

    @Test
    public void shouldHaveCorrectValueAfterPlusWithOtherAngle() {
        Angle firstAngle = Angle.radians(1.3436);
        Angle secondAngle = Angle.radians(2.561);
        Angle result = firstAngle.plus(secondAngle);
        double expectedValue = firstAngle.getValue() + secondAngle.getValue();
        assertEquals(expectedValue, result.getValue(), 0);
    }

    @Test
    public void shouldHaveCorrectValueAfterMinusWithOtherAngle() {
        Angle firstAngle = Angle.radians(1.3436);
        Angle secondAngle = Angle.radians(2.561);
        Angle result = firstAngle.minus(secondAngle);
        double expectedValue = firstAngle.getValue() - secondAngle.getValue();
        assertEquals(expectedValue, result.getValue(), 0);
    }

    @Test
    public void shouldHaveCorrectValueAfterTimesWithNumber() {
        Angle angle = Angle.radians(1.3563);
        double number = 0.913;
        Angle result = angle.times(number);
        double expectedValue = angle.getValue() * number;
        assertEquals(expectedValue, result.getValue(), 0);
    }

    @Test
    public void shouldHaveCorrectValueAfterByWithNumber() {
        Angle angle = Angle.radians(1.3563);
        double number = 0.6713;
        Angle result = angle.by(number);
        double expectedValue = angle.getValue() / number;
        assertEquals(expectedValue, result.getValue(), 0);
    }

    @Test
    public void shouldReturnCorrectSineValue() {
        double radiansValue = 1.456;
        Angle angle = Angle.radians(radiansValue);
        double expectedSine = Math.sin(radiansValue);
        assertEquals(expectedSine, angle.sin(), 0);
    }

    @Test
    public void shouldReturnCorrectCosineValue() {
        double radiansValue = 1.456;
        Angle angle = Angle.radians(radiansValue);
        double expectedCosine = Math.cos(radiansValue);
        assertEquals(expectedCosine, angle.cos(), 0);
    }
}
