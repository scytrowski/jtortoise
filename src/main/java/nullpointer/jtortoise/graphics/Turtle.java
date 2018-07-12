package nullpointer.jtortoise.graphics;

import nullpointer.jtortoise.core.TurtleObserver;
import nullpointer.jtortoise.geometry.Angle;
import nullpointer.jtortoise.geometry.Point;

public class Turtle {
    private final TurtleObserver observer;
    private Point position = Point.ZERO;
    private Angle angle = Angle.ZERO;
    private PenState penState = PenState.DOWN;
    private Color penColor = Colors.BLACK;
    private Color fillColor = Colors.WHITE;
    private double speed = 0.5;

    public Turtle(TurtleObserver observer) {
        this.observer = observer;
    }

    public void moveTo(Point destination) {
        Angle newAngle = Angle.between(position, destination);
        rotateTo(newAngle);
        position = destination;
        notifyMovedTo();
    }

    public void rotateTo(Angle destinationAngle) {
        angle = destinationAngle;
        notifyRotatedTo();
    }

    public void penUp() {
        penState = PenState.UP;
        notifyPenStateChanged();
    }

    public void penDown() {
        penState = PenState.DOWN;
        notifyPenStateChanged();
    }

    public void setPenColor(Color newPenColor) {
        penColor = newPenColor;
        notifyPenColorChanged();
    }

    public void setFillColor(Color newFillColor) {
        fillColor = newFillColor;
        notifyFillColorChanged();
    }

    public void setSpeed(double newSpeed) {
        speed = newSpeed;
        notifySpeedChanged();
    }

    public TurtleObserver getObserver() {
        return observer;
    }

    public Point getPosition() {
        return position;
    }

    public Angle getAngle() {
        return angle;
    }

    public PenState getPenState() {
        return penState;
    }

    public Color getPenColor() {
        return penColor;
    }

    public Color getFillColor() {
        return fillColor;
    }

    public double getSpeed() {
        return speed;
    }

    private void notifyMovedTo() {
        observer.onMoveTo(this, position);
    }

    private void notifyRotatedTo() {
        observer.onRotateTo(this, angle);
    }

    private void notifyPenStateChanged() {
        observer.onChangePenState(this, penState);
    }

    private void notifyPenColorChanged() {
        observer.onChangePenColor(this, penColor);
    }

    private void notifyFillColorChanged() {
        observer.onChangeFillColor(this, fillColor);
    }

    private void notifySpeedChanged() {
        observer.onChangeSpeed(this, speed);
    }
}
