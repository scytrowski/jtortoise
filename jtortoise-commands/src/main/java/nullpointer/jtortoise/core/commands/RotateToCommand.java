package nullpointer.jtortoise.core.commands;

import nullpointer.jtortoise.core.Command;
import nullpointer.jtortoise.core.CommandSource;
import nullpointer.jtortoise.geometry.Angle;

public class RotateToCommand extends Command {
    private final Angle destinationAngle;

    public RotateToCommand(CommandSource source, Angle destinationAngle) {
        super(source);
        this.destinationAngle = destinationAngle;
    }

    public Angle getDestinationAngle() {
        return destinationAngle;
    }
}
