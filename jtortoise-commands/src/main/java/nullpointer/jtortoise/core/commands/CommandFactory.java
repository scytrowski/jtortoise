package nullpointer.jtortoise.core.commands;

import nullpointer.jtortoise.core.Command;
import nullpointer.jtortoise.core.CommandSource;
import nullpointer.jtortoise.geometry.Angle;
import nullpointer.jtortoise.geometry.Point;
import nullpointer.jtortoise.graphics.Color;
import nullpointer.jtortoise.graphics.PenState;

public class CommandFactory {
    public Command createMoveTo(CommandSource source, Point destination) {
        return new MoveToCommand(source, destination);
    }

    public Command createRotateTo(CommandSource source, Angle destinationAngle) {
        return new RotateToCommand(source, destinationAngle);
    }

    public Command createChangePenState(CommandSource source, PenState newPenState) {
        return new ChangePenStateCommand(source, newPenState);
    }

    public Command createChangePenColor(CommandSource source, Color newPenColor) {
        return new ChangePenColorCommand(source, newPenColor);
    }

    public Command createChangeFillColor(CommandSource source, Color newFillColor) {
        return new ChangeFillColorCommand(source, newFillColor);
    }

    public Command createChangeSpeed(CommandSource source, double newSpeed) {
        return new ChangeSpeedCommand(source, newSpeed);
    }
}
