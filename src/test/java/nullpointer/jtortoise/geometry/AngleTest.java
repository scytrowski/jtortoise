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
}
