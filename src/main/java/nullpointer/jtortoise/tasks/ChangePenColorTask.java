package nullpointer.jtortoise.tasks;

import nullpointer.jtortoise.graphics.Color;
import nullpointer.jtortoise.graphics.Turtle;

public class ChangePenColorTask extends Task {
    private final Color newPenColor;

    public ChangePenColorTask(Turtle turtle, Color newPenColor) {
        super(turtle);
        this.newPenColor = newPenColor;
    }

    public Color getNewPenColor() {
        return newPenColor;
    }
}
