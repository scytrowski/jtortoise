package nullpointer.jtortoise.core;

import nullpointer.jtortoise.geometry.Angle;
import nullpointer.jtortoise.geometry.Point;
import nullpointer.jtortoise.graphics.Color;
import nullpointer.jtortoise.graphics.PenState;

public interface CommandFactory {
    Command createMoveTo(Turtle turtle, Point destination);
    Command createRotateTo(Turtle turtle, Angle destinationAngle);
    Command createChangePenState(Turtle turtle, PenState newPenState);
    Command createChangePenColor(Turtle turtle, Color newPenColor);
    Command createChangeFillColor(Turtle turtle, Color newFillColor);
    Command createChangeSpeed(Turtle turtle, double newSpeed);
}
