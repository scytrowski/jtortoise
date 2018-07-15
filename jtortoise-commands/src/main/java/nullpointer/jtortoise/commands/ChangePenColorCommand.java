package nullpointer.jtortoise.commands;

import nullpointer.jtortoise.graphics.Color;
import nullpointer.jtortoise.turtles.Turtle;

public class ChangePenColorCommand extends Command {
    private final Color newPenColor;

    public ChangePenColorCommand(Turtle turtle, Color newPenColor) {
        super(turtle);
        this.newPenColor = newPenColor;
    }

    public Color getNewPenColor() {
        return newPenColor;
    }
}
