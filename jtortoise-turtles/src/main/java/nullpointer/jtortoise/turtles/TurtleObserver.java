package nullpointer.jtortoise.turtles;

import nullpointer.jtortoise.geometry.Angle;
import nullpointer.jtortoise.geometry.Point;
import nullpointer.jtortoise.graphics.Color;
import nullpointer.jtortoise.graphics.PenState;

public interface TurtleObserver {
    void onMoveTo(Turtle turtle, Point destination);
    void onRotateTo(Turtle turtle, Angle destinationAngle);
    void onChangePenState(Turtle turtle, PenState newPenState);
    void onChangePenColor(Turtle turtle, Color newPenColor);
    void onChangeFillColor(Turtle turtle, Color newFillColor);
    void onChangeSpeed(Turtle turtle, double newSpeed);
}
