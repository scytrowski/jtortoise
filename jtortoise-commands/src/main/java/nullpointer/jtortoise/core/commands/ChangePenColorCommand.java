package nullpointer.jtortoise.core.commands;

import nullpointer.jtortoise.core.Command;
import nullpointer.jtortoise.core.CommandSource;
import nullpointer.jtortoise.graphics.Color;

public class ChangePenColorCommand extends Command {
    private final Color newPenColor;

    public ChangePenColorCommand(CommandSource source, Color newPenColor) {
        super(source);
        this.newPenColor = newPenColor;
    }

    public Color getNewPenColor() {
        return newPenColor;
    }
}
