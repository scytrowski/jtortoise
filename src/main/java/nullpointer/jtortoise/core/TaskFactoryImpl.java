package nullpointer.jtortoise.core;

import nullpointer.jtortoise.geometry.Angle;
import nullpointer.jtortoise.geometry.Point;
import nullpointer.jtortoise.graphics.Color;
import nullpointer.jtortoise.graphics.PenState;
import nullpointer.jtortoise.graphics.Turtle;
import nullpointer.jtortoise.tasks.*;

public class TaskFactoryImpl implements TaskFactory {
    @Override
    public Task createMoveTo(Turtle turtle, Point destination) {
        return new MoveToTask(turtle, destination);
    }

    @Override
    public Task createRotateTo(Turtle turtle, Angle destinationAngle) {
        return new RotateToTask(turtle, destinationAngle);
    }

    @Override
    public Task createChangePenState(Turtle turtle, PenState newPenState) {
        return new ChangePenStateTask(turtle, newPenState);
    }

    @Override
    public Task createChangePenColor(Turtle turtle, Color newPenColor) {
        return new ChangePenColorTask(turtle, newPenColor);
    }

    @Override
    public Task createChangeFillColor(Turtle turtle, Color newFillColor) {
        return new ChangeFillColorTask(turtle, newFillColor);
    }

    @Override
    public Task createChangeSpeed(Turtle turtle, double newSpeed) {
        return new ChangeSpeedTask(turtle, newSpeed);
    }
}
