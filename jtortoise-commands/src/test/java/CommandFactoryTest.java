import nullpointer.jtortoise.core.Command;
import nullpointer.jtortoise.core.CommandSource;
import nullpointer.jtortoise.core.commands.*;
import nullpointer.jtortoise.geometry.Angle;
import nullpointer.jtortoise.geometry.Point;
import nullpointer.jtortoise.graphics.Color;
import nullpointer.jtortoise.graphics.PenState;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class CommandFactoryTest {
    private final CommandFactory factory = new CommandFactory();
    private final CommandSource source = mock(CommandSource.class);
    private final Point destination = mock(Point.class);
    private final Angle destinationAngle = mock(Angle.class);
    private final PenState newPenState = PenState.UP;
    private final Color newPenColor = mock(Color.class);
    private final Color newFillColor = mock(Color.class);
    private final double newSpeed = 0.779;

    @Test
    public void shouldReturnInstanceOfMoveToCommandOnCreateMoveTo() {
        Command result = factory.createMoveTo(source, destination);
        assertTrue(result instanceof MoveToCommand);
    }

    @Test
    public void shouldReturnCommandWithCorrectSourceOnCreateMoveTo() {
        Command result = factory.createMoveTo(source, destination);
        assertEquals(source, result.getSource());
    }

    @Test
    public void shouldReturnCommandWithCorrectDestinationOnCreateMoveTo() {
        Command result = factory.createMoveTo(source, destination);
        assertEquals(destination, ((MoveToCommand)result).getDestination());
    }

    @Test
    public void shouldReturnInstanceOfRotateToCommandOnCreateRotateTo() {
        Command result = factory.createRotateTo(source, destinationAngle);
        assertTrue(result instanceof RotateToCommand);
    }

    @Test
    public void shouldReturnCommandWithCorrectSourceOnCreateRotateTo() {
        Command result = factory.createRotateTo(source, destinationAngle);
        assertEquals(source, result.getSource());
    }

    @Test
    public void shouldReturnCommandWithCorrectDestinationAngleOnCreateRotateTo() {
        Command result = factory.createRotateTo(source, destinationAngle);
        assertEquals(destinationAngle, ((RotateToCommand)result).getDestinationAngle());
    }

    @Test
    public void shouldReturnInstanceOfChangePenStateCommandOnCreateChangePenState() {
        Command result = factory.createChangePenState(source, newPenState);
        assertTrue(result instanceof ChangePenStateCommand);
    }

    @Test
    public void shouldReturnCommandWithCorrectSourceOnCreateChangePenState() {
        Command result = factory.createChangePenState(source, newPenState);
        assertEquals(source, result.getSource());
    }

    @Test
    public void shouldReturnCommandWithCorrectNewPenStateOnCreateChangePenState() {
        Command result = factory.createChangePenState(source, newPenState);
        assertEquals(newPenState, ((ChangePenStateCommand)result).getNewPenState());
    }

    @Test
    public void shouldReturnInstanceOfChangePenColorCommandOnCreateChangePenColor() {
        Command result = factory.createChangePenColor(source, newPenColor);
        assertTrue(result instanceof ChangePenColorCommand);
    }

    @Test
    public void shouldReturnCommandWithCorrectSourceOnCreateChangePenColor() {
        Command result = factory.createChangePenColor(source, newPenColor);
        assertEquals(source, result.getSource());
    }

    @Test
    public void shouldReturnCommandWithCorrectNewPenColorOnCreateChangePenColor() {
        Command result = factory.createChangePenColor(source, newPenColor);
        assertEquals(newPenColor, ((ChangePenColorCommand)result).getNewPenColor());
    }

    @Test
    public void shouldReturnInstanceOfChangeFillColorCommandOnCreateChangeFillColor() {
        Command result = factory.createChangeFillColor(source, newFillColor);
        assertTrue(result instanceof ChangeFillColorCommand);
    }

    @Test
    public void shouldReturnCommandWithCorrectSourceOnCreateChangeFillColor() {
        Command result = factory.createChangeFillColor(source, newFillColor);
        assertEquals(source, result.getSource());
    }

    @Test
    public void shouldReturnCommandWithCorrectNewFillColorOnCreateChangeFillColor() {
        Command result = factory.createChangeFillColor(source, newFillColor);
        assertEquals(newFillColor, ((ChangeFillColorCommand)result).getNewFillColor());
    }

    @Test
    public void shouldReturnInstanceOfChangeSpeedCommandOnCreateChangedSpeed() {
        Command result = factory.createChangeSpeed(source, newSpeed);
        assertTrue(result instanceof ChangeSpeedCommand);
    }

    @Test
    public void shouldReturnCommandWithCorrectSourceOnCreateChangeSpeed() {
        Command result = factory.createChangeSpeed(source, newSpeed);
        assertEquals(source, result.getSource());
    }

    @Test
    public void shouldReturnCommandWithCorrectNewSpeedOnCreateChangedSpeed() {
        Command result = factory.createChangeSpeed(source, newSpeed);
        assertEquals(newSpeed, ((ChangeSpeedCommand)result).getNewSpeed(), 0);
    }
}
