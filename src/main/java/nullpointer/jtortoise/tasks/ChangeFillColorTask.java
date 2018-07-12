package nullpointer.jtortoise.tasks;

import nullpointer.jtortoise.graphics.Color;
import nullpointer.jtortoise.graphics.Turtle;

public class ChangeFillColorTask extends Task {
    private final Color newFillColor;

    public ChangeFillColorTask(Turtle turtle, Color newFillColor) {
        super(turtle);
        this.newFillColor = newFillColor;
    }

    public Color getNewFillColor() {
        return newFillColor;
    }
}
