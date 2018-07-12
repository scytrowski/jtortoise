package nullpointer.jtortoise.tasks;

import nullpointer.jtortoise.geometry.Point;
import nullpointer.jtortoise.graphics.Turtle;

public class MoveToTask extends Task {
    private final Point destination;

    public MoveToTask(Turtle turtle, Point destination) {
        super(turtle);
        this.destination = destination;
    }

    public Point getDestination() {
        return destination;
    }
}
