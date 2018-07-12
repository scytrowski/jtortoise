package nullpointer.jtortoise.core;

import nullpointer.jtortoise.geometry.Angle;
import nullpointer.jtortoise.geometry.Point;
import nullpointer.jtortoise.graphics.Color;
import nullpointer.jtortoise.graphics.PenState;

public interface TurtleObserver {
    void onMoveTo(Point destination);
    void onRotateTo(Angle destinationAngle);
    void onChangePenState(PenState newPenState);
    void onChangePenColor(Color newPenColor);
    void onChangeFillColor(Color newFillColor);
    void onChangeSpeed(double newSpeed);
}
