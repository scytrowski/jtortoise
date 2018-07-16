package nullpointer.jtortoise.core.commands;

import nullpointer.jtortoise.core.Command;
import nullpointer.jtortoise.geometry.Point;
import nullpointer.jtortoise.core.Turtle;

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
