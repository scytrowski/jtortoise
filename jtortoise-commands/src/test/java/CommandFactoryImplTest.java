import nullpointer.jtortoise.core.Command;
import nullpointer.jtortoise.core.Turtle;
import nullpointer.jtortoise.core.commands.*;
import nullpointer.jtortoise.geometry.Angle;
import nullpointer.jtortoise.geometry.Point;
import nullpointer.jtortoise.graphics.Color;
import nullpointer.jtortoise.graphics.PenState;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class CommandFactoryImplTest {
    private final CommandFactoryImpl factory = new CommandFactoryImpl();
    private final Turtle turtle = mock(Turtle.class);
    private final Point destination = mock(Point.class);
    private final Angle destinationAngle = mock(Angle.class);
    private final PenState newPenState = PenState.UP;
    private final Color newPenColor = mock(Color.class);
    private final Color newFillColor = mock(Color.class);
    private final double newSpeed = 0.779;

    @Test
    public void shouldReturnInstanceOfMoveToCommandOnCreateMoveTo() {
        Command result = factory.createMoveTo(turtle, destination);
        assertTrue(result instanceof MoveToCommand);
    }

    @Test
    public void shouldReturnCommandWithCorrectTurtleOnCreateMoveTo() {
        Command result = factory.createMoveTo(turtle, destination);
        assertEquals(turtle, result.getTurtle());
    }

    @Test
    public void shouldReturnCommandWithCorrectDestinationOnCreateMoveTo() {
        Command result = factory.createMoveTo(turtle, destination);
        assertEquals(destination, ((MoveToCommand)result).getDestination());
    }

    @Test
    public void shouldReturnInstanceOfRotateToCommandOnCreateRotateTo() {
        Command result = factory.createRotateTo(turtle, destinationAngle);
        assertTrue(result instanceof RotateToCommand);
    }

    @Test
    public void shouldReturnCommandWithCorrectTurtleOnCreateRotateTo() {
        Command result = factory.createRotateTo(turtle, destinationAngle);
        assertEquals(turtle, result.getTurtle());
    }

    @Test
    public void shouldReturnCommandWithCorrectDestinationAngleOnCreateRotateTo() {
        Command result = factory.createRotateTo(turtle, destinationAngle);
        assertEquals(destinationAngle, ((RotateToCommand)result).getDestinationAngle());
    }

    @Test
    public void shouldReturnInstanceOfChangePenStateCommandOnCreateChangePenState() {
        Command result = factory.createChangePenState(turtle, newPenState);
        assertTrue(result instanceof ChangePenStateCommand);
    }

    @Test
    public void shouldReturnCommandWithCorrectTurtleOnCreateChangePenState() {
        Command result = factory.createChangePenState(turtle, newPenState);
        assertEquals(turtle, result.getTurtle());
    }

    @Test
    public void shouldReturnCommandWithCorrectNewPenStateOnCreateChangePenState() {
        Command result = factory.createChangePenState(turtle, newPenState);
        assertEquals(newPenState, ((ChangePenStateCommand)result).getNewPenState());
    }

    @Test
    public void shouldReturnInstanceOfChangePenColorCommandOnCreateChangePenColor() {
        Command result = factory.createChangePenColor(turtle, newPenColor);
        assertTrue(result instanceof ChangePenColorCommand);
    }

    @Test
    public void shouldReturnCommandWithCorrectTurtleOnCreateChangePenColor() {
        Command result = factory.createChangePenColor(turtle, newPenColor);
        assertEquals(turtle, result.getTurtle());
    }

    @Test
    public void shouldReturnCommandWithCorrectNewPenColorOnCreateChangePenColor() {
        Command result = factory.createChangePenColor(turtle, newPenColor);
        assertEquals(newPenColor, ((ChangePenColorCommand)result).getNewPenColor());
    }

    @Test
    public void shouldReturnInstanceOfChangeFillColorCommandOnCreateChangeFillColor() {
        Command result = factory.createChangeFillColor(turtle, newFillColor);
        assertTrue(result instanceof ChangeFillColorCommand);
    }

    @Test
    public void shouldReturnCommandWithCorrectTurtleOnCreateChangeFillColor() {
        Command result = factory.createChangeFillColor(turtle, newFillColor);
        assertEquals(turtle, result.getTurtle());
    }

    @Test
    public void shouldReturnCommandWithCorrectNewFillColorOnCreateChangeFillColor() {
        Command result = factory.createChangeFillColor(turtle, newFillColor);
        assertEquals(newFillColor, ((ChangeFillColorCommand)result).getNewFillColor());
    }

    @Test
    public void shouldReturnInstanceOfChangeSpeedCommandOnCreateChangedSpeed() {
        Command result = factory.createChangeSpeed(turtle, newSpeed);
        assertTrue(result instanceof ChangeSpeedCommand);
    }

    @Test
    public void shouldReturnCommandWithCorrectTurtleOnCreateChangeSpeed() {
        Command result = factory.createChangeSpeed(turtle, newSpeed);
        assertEquals(turtle, result.getTurtle());
    }

    @Test
    public void shouldReturnCommandWithCorrectNewSpeedOnCreateChangedSpeed() {
        Command result = factory.createChangeSpeed(turtle, newSpeed);
        assertEquals(newSpeed, ((ChangeSpeedCommand)result).getNewSpeed(), 0);
    }
}
