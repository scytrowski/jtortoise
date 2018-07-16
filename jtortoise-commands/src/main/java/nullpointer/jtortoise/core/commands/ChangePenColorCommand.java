package nullpointer.jtortoise.core.commands;

import nullpointer.jtortoise.core.Command;
import nullpointer.jtortoise.graphics.Color;
import nullpointer.jtortoise.core.Turtle;

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
