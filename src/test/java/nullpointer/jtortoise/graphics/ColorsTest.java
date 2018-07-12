package nullpointer.jtortoise.graphics;

import org.junit.Test;

import static org.junit.Assert.*;

public class ColorsTest {
    @Test
    public void shouldHaveCorrectBlackColor() {
        Color expectedColor = Color.rgb(0, 0, 0);
        assertEquals(expectedColor, Colors.BLACK);
    }

    @Test
    public void shouldHaveCorrectWhiteColor() {
        Color expectedColor = Color.rgb(255, 255, 255);
        assertEquals(expectedColor, Colors.WHITE);
    }
}
