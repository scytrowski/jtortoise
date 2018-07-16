package nullpointer.jtortoise.core.commands;

import nullpointer.jtortoise.core.Command;
import nullpointer.jtortoise.core.CommandFactory;
import nullpointer.jtortoise.core.Turtle;
import nullpointer.jtortoise.geometry.Angle;
import nullpointer.jtortoise.geometry.Point;
import nullpointer.jtortoise.graphics.Color;
import nullpointer.jtortoise.graphics.PenState;

public class CommandFactoryImpl implements CommandFactory {
    @Override
    public Command createMoveTo(Turtle turtle, Point destination) {
        return new MoveToCommand(turtle, destination);
    }

    @Override
    public Command createRotateTo(Turtle turtle, Angle destinationAngle) {
        return new RotateToCommand(turtle, destinationAngle);
    }

    @Override
    public Command createChangePenState(Turtle turtle, PenState newPenState) {
        return new ChangePenStateCommand(turtle, newPenState);
    }

    @Override
    public Command createChangePenColor(Turtle turtle, Color newPenColor) {
        return new ChangePenColorCommand(turtle, newPenColor);
    }

    @Override
    public Command createChangeFillColor(Turtle turtle, Color newFillColor) {
        return new ChangeFillColorCommand(turtle, newFillColor);
    }

    @Override
    public Command createChangeSpeed(Turtle turtle, double newSpeed) {
        return new ChangeSpeedCommand(turtle, newSpeed);
    }
}
