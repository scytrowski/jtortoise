package nullpointer.jtortoise.tasks;

import nullpointer.jtortoise.graphics.PenState;
import nullpointer.jtortoise.graphics.Turtle;

public class ChangePenStateTask extends Task {
    private final PenState newPenState;

    public ChangePenStateTask(Turtle turtle, PenState newPenState) {
        super(turtle);
        this.newPenState = newPenState;
    }

    public PenState getNewPenState() {
        return newPenState;
    }
}
