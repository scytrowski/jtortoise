package nullpointer.jtortoise.commands;

import nullpointer.jtortoise.graphics.PenState;
import nullpointer.jtortoise.turtles.Turtle;

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
