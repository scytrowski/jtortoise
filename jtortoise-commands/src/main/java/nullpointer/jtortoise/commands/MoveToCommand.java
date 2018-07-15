package nullpointer.jtortoise.commands;

import nullpointer.jtortoise.geometry.Point;
import nullpointer.jtortoise.turtles.Turtle;

public class MoveToCommand extends Command {
    private final Point destination;

    public MoveToCommand(Turtle turtle, Point destination) {
        super(turtle);
        this.destination = destination;
    }

    public Point getDestination() {
        return destination;
    }
}
