package nullpointer.jtortoise.core.commands;

import nullpointer.jtortoise.core.Command;
import nullpointer.jtortoise.core.CommandSource;

public class ChangeSpeedCommand extends Command {
    private final double newSpeed;

    public ChangeSpeedCommand(CommandSource source, double newSpeed) {
        super(source);
        this.newSpeed = newSpeed;
    }

    public double getNewSpeed() {
        return newSpeed;
    }
}
