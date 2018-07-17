package nullpointer.jtortoise.core.commands;

import nullpointer.jtortoise.core.Command;
import nullpointer.jtortoise.core.CommandSource;
import nullpointer.jtortoise.geometry.Point;

public class MoveToCommand extends Command {
    private final Point destination;

    public MoveToCommand(CommandSource source, Point destination) {
        super(source);
        this.destination = destination;
    }

    public Point getDestination() {
        return destination;
    }
}
