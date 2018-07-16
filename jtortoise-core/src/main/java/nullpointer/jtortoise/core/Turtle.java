package nullpointer.jtortoise.core;

import nullpointer.jtortoise.geometry.Angle;
import nullpointer.jtortoise.geometry.Point;
import nullpointer.jtortoise.graphics.Color;
import nullpointer.jtortoise.graphics.Colors;
import nullpointer.jtortoise.graphics.PenState;

public class Turtle {
    private final CommandFactory commandFactory;
    private final CommandExecutor commandExecutor;
    private Point position = Point.ZERO;
    private Angle angle = Angle.ZERO;
    private PenState penState = PenState.DOWN;
    private Color penColor = Colors.BLACK;
    private Color fillColor = Colors.WHITE;
    private double speed = 0.5;

    public Turtle(CommandFactory commandFactory, CommandExecutor commandExecutor) {
        this.commandFactory = commandFactory;
        this.commandExecutor = commandExecutor;
    }

    public void moveTo(Point destination) {
        Angle newAngle = Angle.between(position, destination);
        rotateTo(newAngle);
        position = destination;
        executeMoveTo();
    }

    public void rotateTo(Angle destinationAngle) {
        angle = destinationAngle;
        executeRotateTo();
    }

    public void penUp() {
        penState = PenState.UP;
        executeChangePenState();
    }

    public void penDown() {
        penState = PenState.DOWN;
        executeChangePenState();
    }

    public void setPenColor(Color newPenColor) {
        penColor = newPenColor;
        executeChangePenColor();
    }

    public void setFillColor(Color newFillColor) {
        fillColor = newFillColor;
        executeChangeFillColor();
    }

    public void setSpeed(double newSpeed) {
        speed = newSpeed;
        executeChangeSpeed();
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

    private void executeMoveTo() {
        Command moveToCommand = commandFactory.createMoveTo(this, position);
        executeCommand(moveToCommand);
    }

    private void executeRotateTo() {
        Command rotateToCommand = commandFactory.createRotateTo(this, angle);
        executeCommand(rotateToCommand);
    }

    private void executeChangePenState() {
        Command changePenStateCommand = commandFactory.createChangePenState(this, penState);
        executeCommand(changePenStateCommand);
    }

    private void executeChangePenColor() {
        Command changePenColorCommand = commandFactory.createChangePenColor(this, penColor);
        executeCommand(changePenColorCommand);
    }

    private void executeChangeFillColor() {
        Command changeFillColorCommand = commandFactory.createChangeFillColor(this, fillColor);
        executeCommand(changeFillColorCommand);
    }

    private void executeChangeSpeed() {
        Command changeSpeedCommand = commandFactory.createChangeSpeed(this, speed);
        executeCommand(changeSpeedCommand);
    }

    private void executeCommand(Command command) {
        commandExecutor.execute(command);
    }
}
