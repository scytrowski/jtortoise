package nullpointer.jtortoise.commands;

import nullpointer.jtortoise.graphics.Color;
import nullpointer.jtortoise.turtles.Turtle;

public class ChangeFillColorCommand extends Command {
    private final Color newFillColor;

    public ChangeFillColorCommand(Turtle turtle, Color newFillColor) {
        super(turtle);
        this.newFillColor = newFillColor;
    }

    public Color getNewFillColor() {
        return newFillColor;
    }
}
