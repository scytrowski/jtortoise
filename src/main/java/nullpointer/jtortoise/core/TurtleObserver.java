package nullpointer.jtortoise.core;

import nullpointer.jtortoise.geometry.Angle;
import nullpointer.jtortoise.geometry.Point;
import nullpointer.jtortoise.graphics.Color;
import nullpointer.jtortoise.graphics.PenState;
import nullpointer.jtortoise.graphics.Turtle;

public interface TurtleObserver {
    void onMoveTo(Turtle turtle, Point destination);
    void onRotateTo(Turtle turtle, Angle destinationAngle);
    void onChangePenState(Turtle turtle, PenState newPenState);
    void onChangePenColor(Turtle turtle, Color newPenColor);
    void onChangeFillColor(Turtle turtle, Color newFillColor);
    void onChangeSpeed(Turtle turtle, double newSpeed);
}
