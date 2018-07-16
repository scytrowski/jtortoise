package nullpointer.jtortoise.core.commands;

import nullpointer.jtortoise.core.Command;
import nullpointer.jtortoise.core.Turtle;

public class ChangeSpeedCommand extends Command {
    private final double newSpeed;

    public ChangeSpeedCommand(Turtle turtle, double newSpeed) {
        super(turtle);
        this.newSpeed = newSpeed;
    }

    public double getNewSpeed() {
        return newSpeed;
    }
}
