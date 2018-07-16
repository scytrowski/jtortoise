package nullpointer.jtortoise.core.commands;

import nullpointer.jtortoise.core.Command;
import nullpointer.jtortoise.graphics.Color;
import nullpointer.jtortoise.core.Turtle;

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
