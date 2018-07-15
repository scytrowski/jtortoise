package nullpointer.jtortoise.graphics;

public class Color {
    private final int red;
    private final int green;
    private final int blue;

    private Color(int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public static Color rgb(int red, int green, int blue) {
        return new Color(red, green, blue);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Color) {
            Color otherColor = (Color)obj;
            return red == otherColor.red && green == otherColor.green && blue == otherColor.blue;
        } else
            return false;
    }

    public int getRed() {
        return red;
    }

    public int getGreen() {
        return green;
    }

    public int getBlue() {
        return blue;
    }
}
