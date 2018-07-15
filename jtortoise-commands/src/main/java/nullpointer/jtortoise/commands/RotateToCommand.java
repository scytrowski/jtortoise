package nullpointer.jtortoise.commands;

import nullpointer.jtortoise.geometry.Angle;
import nullpointer.jtortoise.turtles.Turtle;

public class RotateToCommand extends Command {
    private final Angle destinationAngle;

    public RotateToCommand(Turtle turtle, Angle destinationAngle) {
        super(turtle);
        this.destinationAngle = destinationAngle;
    }

    public Angle getDestinationAngle() {
        return destinationAngle;
    }
}
