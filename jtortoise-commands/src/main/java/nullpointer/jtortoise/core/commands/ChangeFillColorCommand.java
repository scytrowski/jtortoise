package nullpointer.jtortoise.core.commands;

import nullpointer.jtortoise.core.Command;
import nullpointer.jtortoise.core.CommandSource;
import nullpointer.jtortoise.graphics.Color;

public class ChangeFillColorCommand extends Command {
    private final Color newFillColor;

    public ChangeFillColorCommand(CommandSource source, Color newFillColor) {
        super(source);
        this.newFillColor = newFillColor;
    }

    public Color getNewFillColor() {
        return newFillColor;
    }
}
