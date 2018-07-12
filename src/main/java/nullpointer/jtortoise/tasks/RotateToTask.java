package nullpointer.jtortoise.tasks;

import nullpointer.jtortoise.geometry.Angle;
import nullpointer.jtortoise.graphics.Turtle;

public class RotateToTask extends Task {
    private final Angle destinationAngle;

    public RotateToTask(Turtle turtle, Angle destinationAngle) {
        super(turtle);
        this.destinationAngle = destinationAngle;
    }

    public Angle getDestinationAngle() {
        return destinationAngle;
    }
}
