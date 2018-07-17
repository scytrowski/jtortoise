package nullpointer.jtortoise.core.commands;

import nullpointer.jtortoise.core.Command;
import nullpointer.jtortoise.core.CommandSource;
import nullpointer.jtortoise.graphics.PenState;

public class ChangePenStateCommand extends Command {
    private final PenState newPenState;

    public ChangePenStateCommand(CommandSource source, PenState newPenState) {
        super(source);
        this.newPenState = newPenState;
    }

    public PenState getNewPenState() {
        return newPenState;
    }
}
