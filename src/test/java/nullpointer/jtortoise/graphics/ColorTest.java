package nullpointer.jtortoise.graphics;

import org.junit.Test;

import static org.junit.Assert.*;

public class ColorTest {
    @Test
    public void shouldCreateRgbColorWithCorrectRedComponent() {
        int expectedRed = 37;
        Color color = Color.rgb(expectedRed, 89, 127);
        assertEquals(expectedRed, color.getRed(), 0);
    }

    @Test
    public void shouldCreateRgbColorWithCorrectGreenComponent() {
        int expectedGreen = 89;
        Color color = Color.rgb(37, expectedGreen, 127);
        assertEquals(expectedGreen, color.getGreen(), 0);
    }

    @Test
    public void shouldCreateRgbColorWithCorrectBlueComponent() {
        int expectedBlue = 127;
        Color color = Color.rgb(37, 89, expectedBlue);
        assertEquals(expectedBlue, color.getBlue(), 0);
    }

    @Test
    public void shouldEqualWithColorWithSameComponents() {
        int r = 116;
        int g = 72;
        int b = 211;
        Color selfColor = Color.rgb(r, g, b);
        Color otherColor = Color.rgb(r, g, b);
        assertEquals(selfColor, otherColor);
    }

    @Test
    public void shouldNotEqualWithColorWithOtherComponents() {
        Color selfColor = Color.rgb(116, 72, 211);
        Color otherColor = Color.rgb(17, 91, 12);
        assertNotEquals(selfColor, otherColor);
    }

    @Test
    public void shouldNotEqualWithObjectOtherThanColor() {
        Color color = Color.rgb(17, 91, 12);
        Object other = new Object();
        assertNotEquals(color, other);
    }
}
