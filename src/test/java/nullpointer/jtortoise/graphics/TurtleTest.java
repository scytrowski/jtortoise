package nullpointer.jtortoise.graphics;

import nullpointer.jtortoise.core.TurtleObserver;
import nullpointer.jtortoise.geometry.Angle;
import nullpointer.jtortoise.geometry.Point;
import org.junit.Test;
import org.mockito.InOrder;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class TurtleTest {
    private final TurtleObserver observer = mock(TurtleObserver.class);
    private final Turtle turtle = new Turtle(observer);

    @Test
    public void shouldHaveCorrectAngleAfterMoveTo() {
        Point destination = Point.cartesian(6.781, -76.1356);
        Angle expectedAngle = Angle.between(turtle.getPosition(), destination);
        turtle.moveTo(destination);
        assertEquals(expectedAngle, turtle.getAngle());
    }

    @Test
    public void shouldNotifyRotatedToOnceWithCorrectAngleOnMoveTo() {
        Point destination = Point.cartesian(6.781, -76.1356);
        Angle expectedAngle = Angle.between(turtle.getPosition(), destination);
        turtle.moveTo(destination);
        verify(observer, times(1)).onRotateTo(turtle, expectedAngle);
    }

    @Test
    public void shouldHaveCorrectPositionAfterMoveTo() {
        Point destination = Point.cartesian(6.781, -76.1356);
        turtle.moveTo(destination);
        assertEquals(destination, turtle.getPosition());
    }

    @Test
    public void shouldNotifyMovedToOnceWithCorrectPointOnMoveTo() {
        Point destination = Point.cartesian(6.781, -76.1356);
        turtle.moveTo(destination);
        verify(observer, times(1)).onMoveTo(turtle, destination);
    }

    @Test
    public void shouldNotifyRotatedToBeforeNotifyMovedToOnMoveTo() {
        Point destination = Point.cartesian(6.781, -76.1356);
        turtle.moveTo(destination);
        InOrder orderVerifier = inOrder(observer);
        orderVerifier.verify(observer).onRotateTo(any(), any());
        orderVerifier.verify(observer).onMoveTo(any(), any());
    }

    @Test
    public void shouldHaveCorrectAngleAfterRotateTo() {
        Angle destinationAngle = Angle.radians(1.56789);
        turtle.rotateTo(destinationAngle);
        assertEquals(destinationAngle, turtle.getAngle());
    }

    @Test
    public void shouldNotifyRotatedToOnceWithCorrectAngleOnRotateTo() {
        Angle destinationAngle = Angle.radians(1.56789);
        turtle.rotateTo(destinationAngle);
        verify(observer, times(1)).onRotateTo(turtle, destinationAngle);
    }

    @Test
    public void shouldHaveCorrectPenStateAfterPenUp() {
        turtle.penUp();
        assertEquals(PenState.UP, turtle.getPenState());
    }

    @Test
    public void shouldNotifyPenStateChangedOnceWithCorrectPenStateOnPenUp() {
        turtle.penUp();
        verify(observer, times(1)).onChangePenState(turtle, PenState.UP);
    }

    @Test
    public void shouldHaveCorrectPenStateAfterPenDown() {
        turtle.penDown();
        assertEquals(PenState.DOWN, turtle.getPenState());
    }

    @Test
    public void shouldNotifyPenStateChangedOnceWithCorrectPenStateOnPenDown() {
        turtle.penDown();
        verify(observer, times(1)).onChangePenState(turtle, PenState.DOWN);
    }

    @Test
    public void shouldHaveCorrectPenColorAfterSetPenColor() {
        Color newPenColor = Color.rgb(15, 62, 116);
        turtle.setPenColor(newPenColor);
        assertEquals(newPenColor, turtle.getPenColor());
    }

    @Test
    public void shouldNotifyPenColorChangedOnceWithCorrectColorOnSetPenColor() {
        Color newPenColor = Color.rgb(15, 62, 116);
        turtle.setPenColor(newPenColor);
        verify(observer, times(1)).onChangePenColor(turtle, newPenColor);
    }

    @Test
    public void shouldHaveCorrectFillColorAfterSetFillColor() {
        Color newFillColor = Color.rgb(117, 251, 3);
        turtle.setFillColor(newFillColor);
        assertEquals(newFillColor, turtle.getFillColor());
    }

    @Test
    public void shouldNotifyFillColorChangedOnceWithCorrectColorOnSetFillColor() {
        Color newFillColor = Color.rgb(117, 251, 3);
        turtle.setFillColor(newFillColor);
        verify(observer, times(1)).onChangeFillColor(turtle, newFillColor);
    }

    @Test
    public void shouldHaveCorrectSpeedAfterSetSpeed() {
        double newSpeed = 0.779;
        turtle.setSpeed(newSpeed);
        assertEquals(newSpeed, turtle.getSpeed(), 0);
    }

    @Test
    public void shouldNotifySpeedChangedOnceWithCorrectValueOnSetSpeed() {
        double newSpeed = 0.779;
        turtle.setSpeed(newSpeed);
        verify(observer, times(1)).onChangeSpeed(turtle, newSpeed);
    }
}
