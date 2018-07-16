package nullpointer.jtortoise.core.commands;

import nullpointer.jtortoise.core.Command;
import nullpointer.jtortoise.graphics.PenState;
import nullpointer.jtortoise.core.Turtle;

public class ChangePenStateCommand extends Command {
    private final PenState newPenState;

    public ChangePenStateCommand(Turtle turtle, PenState newPenState) {
        super(turtle);
        this.newPenState = newPenState;
    }

    public PenState getNewPenState() {
        return newPenState;
    }
}
