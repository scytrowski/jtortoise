package nullpointer.jtortoise.core;

import nullpointer.jtortoise.geometry.Angle;
import nullpointer.jtortoise.geometry.Point;
import nullpointer.jtortoise.graphics.Color;
import nullpointer.jtortoise.graphics.PenState;
import nullpointer.jtortoise.graphics.Turtle;
import nullpointer.jtortoise.tasks.Task;

public interface TaskFactory {
    Task createMoveTo(Turtle turtle, Point destination);
    Task createRotateTo(Turtle turtle, Angle destinationAngle);
    Task createChangePenState(Turtle turtle, PenState newPenState);
    Task createChangePenColor(Turtle turtle, Color newPenColor);
    Task createChangeFillColor(Turtle turtle, Color newFillColor);
    Task createChangeSpeed(Turtle turtle, double newSpeed);
}
