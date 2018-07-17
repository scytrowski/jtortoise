package nullpointer.jtortoise;

import nullpointer.jtortoise.core.Command;
import nullpointer.jtortoise.core.CommandExecutor;
import nullpointer.jtortoise.core.commands.CommandFactory;
import nullpointer.jtortoise.geometry.Angle;
import nullpointer.jtortoise.geometry.Point;
import nullpointer.jtortoise.graphics.Color;
import nullpointer.jtortoise.graphics.PenState;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class TortoiseTest {
    private final CommandFactory commandFactory = mock(CommandFactory.class);
    private final CommandExecutor commandExecutor = mock(CommandExecutor.class);
    private final Tortoise tortoise = new Tortoise(commandFactory, commandExecutor);
    private final Command moveToCommand = mock(Command.class);
    private final Command rotateToCommand = mock(Command.class);
    private final Command changePenStateCommand = mock(Command.class);
    private final Command changePenColorCommand = mock(Command.class);
    private final Command changeFillColorCommand = mock(Command.class);
    private final Command changeSpeedCommand = mock(Command.class);
    private final Point destination = Point.cartesian(6.781, -76.1356);
    private final Angle destinationAngle = Angle.radians(1.56789);
    private final Color newPenColor = Color.rgb(15, 62, 116);
    private final Color newFillColor = Color.rgb(117, 251, 3);
    private final double newSpeed = 0.779;

    @Before
    public void before() {
        when(commandFactory.createMoveTo(tortoise, destination)).thenReturn(moveToCommand);
        when(commandFactory.createRotateTo(eq(tortoise), any())).thenReturn(rotateToCommand);
        when(commandFactory.createChangePenState(eq(tortoise), any())).thenReturn(changePenStateCommand);
        when(commandFactory.createChangePenColor(tortoise, newPenColor)).thenReturn(changePenColorCommand);
        when(commandFactory.createChangeFillColor(tortoise, newFillColor)).thenReturn(changeFillColorCommand);
        when(commandFactory.createChangeSpeed(tortoise, newSpeed)).thenReturn(changeSpeedCommand);
    }

    @Test
    public void shouldHaveCorrectAngleAfterMoveTo() {
        Angle expectedAngle = Angle.between(tortoise.getPosition(), destination);
        tortoise.moveTo(destination);
        assertEquals(expectedAngle, tortoise.getAngle());
    }

    @Test
    public void shouldCreateRotateToCommandOnceOnMoveTo() {
        tortoise.moveTo(destination);
        verify(commandFactory, times(1)).createRotateTo(eq(tortoise), any());
    }

    @Test
    public void shouldExecuteRotateToCommandOnceOnMoveTo() {
        tortoise.moveTo(destination);
        verify(commandExecutor, times(1)).execute(rotateToCommand);
    }

    @Test
    public void shouldHaveCorrectPositionAfterMoveTo() {
        tortoise.moveTo(destination);
        assertEquals(destination, tortoise.getPosition());
    }

    @Test
    public void shouldCreateMoveToCommandOnceOnMoveTo() {
        tortoise.moveTo(destination);
        verify(commandFactory, times(1)).createMoveTo(tortoise, destination);
    }

    @Test
    public void shouldExecuteMoveToCommandOnceOnMoveTo() {
        tortoise.moveTo(destination);
        verify(commandExecutor, times(1)).execute(moveToCommand);
    }

    @Test
    public void shouldExecuteRotateToCommandBeforeMoveToCommandOnMoveTo() {
        tortoise.moveTo(destination);
        InOrder orderVerifier = inOrder(commandExecutor);
        orderVerifier.verify(commandExecutor).execute(rotateToCommand);
        orderVerifier.verify(commandExecutor).execute(moveToCommand);
    }

    @Test
    public void shouldHaveCorrectAngleAfterRotateTo() {
        tortoise.rotateTo(destinationAngle);
        assertEquals(destinationAngle, tortoise.getAngle());
    }

    @Test
    public void shouldCreateRotateToCommandOnceOnRotateTo() {
        tortoise.rotateTo(destinationAngle);
        verify(commandFactory, times(1)).createRotateTo(tortoise, destinationAngle);
    }

    @Test
    public void shouldExecuteRotateCommandOnceOnRotateTo() {
        tortoise.rotateTo(destinationAngle);
        verify(commandExecutor, times(1)).execute(rotateToCommand);
    }

    @Test
    public void shouldHaveCorrectPenStateAfterPenUp() {
        tortoise.penUp();
        assertEquals(PenState.UP, tortoise.getPenState());
    }

    @Test
    public void shouldCreateChangePenStateCommandOnceOnPenUp() {
        tortoise.penUp();
        verify(commandFactory, times(1)).createChangePenState(tortoise, PenState.UP);
    }

    @Test
    public void shouldExecuteChangePenStateCommandOnceOnPenUp() {
        tortoise.penUp();
        verify(commandExecutor, times(1)).execute(changePenStateCommand);
    }

    @Test
    public void shouldHaveCorrectPenStateAfterPenDown() {
        tortoise.penDown();
        assertEquals(PenState.DOWN, tortoise.getPenState());
    }

    @Test
    public void shouldCreateChangePenStateCommandOnceOnPenDown() {
        tortoise.penDown();
        verify(commandFactory, times(1)).createChangePenState(tortoise, PenState.DOWN);
    }

    @Test
    public void shouldExecuteChangePenStateCommandOnceOnPenDown() {
        tortoise.penDown();
        verify(commandExecutor, times(1)).execute(changePenStateCommand);
    }

    @Test
    public void shouldHaveCorrectPenColorAfterSetPenColor() {
        tortoise.setPenColor(newPenColor);
        assertEquals(newPenColor, tortoise.getPenColor());
    }

    @Test
    public void shouldCreateChangePenColorCommandOnceOnSetPenColor() {
        tortoise.setPenColor(newPenColor);
        verify(commandFactory, times(1)).createChangePenColor(tortoise, newPenColor);
    }

    @Test
    public void shouldExecuteChangePenColorCommandOnceOnSetPenColor() {
        tortoise.setPenColor(newPenColor);
        verify(commandExecutor, times(1)).execute(changePenColorCommand);
    }

    @Test
    public void shouldHaveCorrectFillColorAfterSetFillColor() {
        tortoise.setFillColor(newFillColor);
        assertEquals(newFillColor, tortoise.getFillColor());
    }

    @Test
    public void shouldCreateChangeFillColorCommandOnceOnSetFillColor() {
        tortoise.setFillColor(newFillColor);
        verify(commandFactory, times(1)).createChangeFillColor(tortoise, newFillColor);
    }

    @Test
    public void shouldExecuteChangeFillColorCommandOnceOnSetFillColor() {
        tortoise.setFillColor(newFillColor);
        verify(commandExecutor, times(1)).execute(changeFillColorCommand);
    }

    @Test
    public void shouldHaveCorrectSpeedAfterSetSpeed() {
        tortoise.setSpeed(newSpeed);
        assertEquals(newSpeed, tortoise.getSpeed(), 0);
    }

    @Test
    public void shouldCreateChangeSpeedCommandOnceOnSetSpeed() {
        tortoise.setSpeed(newSpeed);
        verify(commandFactory, times(1)).createChangeSpeed(tortoise, newSpeed);
    }

    @Test
    public void shouldExecuteChangeSpeedCommandOnceOnSetSpeed() {
        tortoise.setSpeed(newSpeed);
        verify(commandExecutor, times(1)).execute(changeSpeedCommand);
    }
}
