package nullpointer.jtortoise.core;

import nullpointer.jtortoise.geometry.Angle;
import nullpointer.jtortoise.geometry.Point;
import nullpointer.jtortoise.graphics.Color;
import nullpointer.jtortoise.graphics.PenState;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class TurtleTest {
    private final CommandFactory commandFactory = mock(CommandFactory.class);
    private final CommandExecutor commandExecutor = mock(CommandExecutor.class);
    private final Turtle turtle = new Turtle(commandFactory, commandExecutor);
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
        when(commandFactory.createMoveTo(turtle, destination)).thenReturn(moveToCommand);
        when(commandFactory.createRotateTo(eq(turtle), any())).thenReturn(rotateToCommand);
        when(commandFactory.createChangePenState(eq(turtle), any())).thenReturn(changePenStateCommand);
        when(commandFactory.createChangePenColor(turtle, newPenColor)).thenReturn(changePenColorCommand);
        when(commandFactory.createChangeFillColor(turtle, newFillColor)).thenReturn(changeFillColorCommand);
        when(commandFactory.createChangeSpeed(turtle, newSpeed)).thenReturn(changeSpeedCommand);
    }

    @Test
    public void shouldHaveCorrectAngleAfterMoveTo() {
        Angle expectedAngle = Angle.between(turtle.getPosition(), destination);
        turtle.moveTo(destination);
        assertEquals(expectedAngle, turtle.getAngle());
    }

    @Test
    public void shouldCreateRotateToCommandOnceOnMoveTo() {
        turtle.moveTo(destination);
        verify(commandFactory, times(1)).createRotateTo(eq(turtle), any());
    }

    @Test
    public void shouldExecuteRotateToCommandOnceOnMoveTo() {
        turtle.moveTo(destination);
        verify(commandExecutor, times(1)).execute(rotateToCommand);
    }

    @Test
    public void shouldHaveCorrectPositionAfterMoveTo() {
        turtle.moveTo(destination);
        assertEquals(destination, turtle.getPosition());
    }

    @Test
    public void shouldCreateMoveToCommandOnceOnMoveTo() {
        turtle.moveTo(destination);
        verify(commandFactory, times(1)).createMoveTo(turtle, destination);
    }

    @Test
    public void shouldExecuteMoveToCommandOnceOnMoveTo() {
        turtle.moveTo(destination);
        verify(commandExecutor, times(1)).execute(moveToCommand);
    }

    @Test
    public void shouldExecuteRotateToCommandBeforeMoveToCommandOnMoveTo() {
        turtle.moveTo(destination);
        InOrder orderVerifier = Mockito.inOrder(commandExecutor);
        orderVerifier.verify(commandExecutor).execute(rotateToCommand);
        orderVerifier.verify(commandExecutor).execute(moveToCommand);
    }

    @Test
    public void shouldHaveCorrectAngleAfterRotateTo() {
        turtle.rotateTo(destinationAngle);
        assertEquals(destinationAngle, turtle.getAngle());
    }

    @Test
    public void shouldCreateRotateToCommandOnceOnRotateTo() {
        turtle.rotateTo(destinationAngle);
        verify(commandFactory, times(1)).createRotateTo(turtle, destinationAngle);
    }

    @Test
    public void shouldExecuteRotateCommandOnceOnRotateTo() {
        turtle.rotateTo(destinationAngle);
        verify(commandExecutor, times(1)).execute(rotateToCommand);
    }

    @Test
    public void shouldHaveCorrectPenStateAfterPenUp() {
        turtle.penUp();
        assertEquals(PenState.UP, turtle.getPenState());
    }

    @Test
    public void shouldCreateChangePenStateCommandOnceOnPenUp() {
        turtle.penUp();
        verify(commandFactory, times(1)).createChangePenState(turtle, PenState.UP);
    }

    @Test
    public void shouldExecuteChangePenStateCommandOnceOnPenUp() {
        turtle.penUp();
        verify(commandExecutor, times(1)).execute(changePenStateCommand);
    }

    @Test
    public void shouldHaveCorrectPenStateAfterPenDown() {
        turtle.penDown();
        assertEquals(PenState.DOWN, turtle.getPenState());
    }

    @Test
    public void shouldCreateChangePenStateCommandOnceOnPenDown() {
        turtle.penDown();
        verify(commandFactory, times(1)).createChangePenState(turtle, PenState.DOWN);
    }

    @Test
    public void shouldExecuteChangePenStateCommandOnceOnPenDown() {
        turtle.penDown();
        verify(commandExecutor, times(1)).execute(changePenStateCommand);
    }

    @Test
    public void shouldHaveCorrectPenColorAfterSetPenColor() {
        turtle.setPenColor(newPenColor);
        assertEquals(newPenColor, turtle.getPenColor());
    }

    @Test
    public void shouldCreateChangePenColorCommandOnceOnSetPenColor() {
        turtle.setPenColor(newPenColor);
        verify(commandFactory, times(1)).createChangePenColor(turtle, newPenColor);
    }

    @Test
    public void shouldExecuteChangePenColorCommandOnceOnSetPenColor() {
        turtle.setPenColor(newPenColor);
        verify(commandExecutor, times(1)).execute(changePenColorCommand);
    }

    @Test
    public void shouldHaveCorrectFillColorAfterSetFillColor() {
        turtle.setFillColor(newFillColor);
        assertEquals(newFillColor, turtle.getFillColor());
    }

    @Test
    public void shouldCreateChangeFillColorCommandOnceOnSetFillColor() {
        turtle.setFillColor(newFillColor);
        verify(commandFactory, times(1)).createChangeFillColor(turtle, newFillColor);
    }

    @Test
    public void shouldExecuteChangeFillColorCommandOnceOnSetFillColor() {
        turtle.setFillColor(newFillColor);
        verify(commandExecutor, times(1)).execute(changeFillColorCommand);
    }

    @Test
    public void shouldHaveCorrectSpeedAfterSetSpeed() {
        turtle.setSpeed(newSpeed);
        assertEquals(newSpeed, turtle.getSpeed(), 0);
    }

    @Test
    public void shouldCreateChangeSpeedCommandOnceOnSetSpeed() {
        turtle.setSpeed(newSpeed);
        verify(commandFactory, times(1)).createChangeSpeed(turtle, newSpeed);
    }

    @Test
    public void shouldExecuteChangeSpeedCommandOnceOnSetSpeed() {
        turtle.setSpeed(newSpeed);
        verify(commandExecutor, times(1)).execute(changeSpeedCommand);
    }
}
