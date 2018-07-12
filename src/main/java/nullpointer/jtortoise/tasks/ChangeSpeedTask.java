package nullpointer.jtortoise.tasks;

import nullpointer.jtortoise.graphics.Turtle;

public class ChangeSpeedTask extends Task {
    private final double newSpeed;

    public ChangeSpeedTask(Turtle turtle, double newSpeed) {
        super(turtle);
        this.newSpeed = newSpeed;
    }

    public double getNewSpeed() {
        return newSpeed;
    }
}
