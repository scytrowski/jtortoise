package nullpointer.jtortoise.commands;

import nullpointer.jtortoise.turtles.Turtle;

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
