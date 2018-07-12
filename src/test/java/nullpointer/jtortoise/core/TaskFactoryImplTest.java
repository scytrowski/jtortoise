package nullpointer.jtortoise.core;

import nullpointer.jtortoise.geometry.Angle;
import nullpointer.jtortoise.geometry.Point;
import nullpointer.jtortoise.graphics.Color;
import nullpointer.jtortoise.graphics.PenState;
import nullpointer.jtortoise.graphics.Turtle;
import nullpointer.jtortoise.tasks.*;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class TaskFactoryImplTest {
    private final TaskFactoryImpl taskFactory = new TaskFactoryImpl();
    private final Turtle turtle = mock(Turtle.class);

    @Test
    public void shouldCreateMoveToTaskOfCorrectType() {
        Point destination = Point.cartesian(54.13, -67.981);
        Task moveToTask = taskFactory.createMoveTo(turtle, destination);
        assertTrue(moveToTask instanceof MoveToTask);
    }

    @Test
    public void shouldCreateMoveToTaskWithCorrectTurtle() {
        Point destination = Point.cartesian(54.13, -67.981);
        Task moveToTask = taskFactory.createMoveTo(turtle, destination);
        assertEquals(turtle, moveToTask.getTurtle());
    }

    @Test
    public void shouldCreateMoveToTaskWithCorrectDestination() {
        Point destination = Point.cartesian(54.13, -67.981);
        Task moveToTask = taskFactory.createMoveTo(turtle, destination);
        assertEquals(destination, ((MoveToTask)moveToTask).getDestination());
    }

    @Test
    public void shouldCreateRotateToTaskOfCorrectType() {
        Angle destinationAngle = Angle.radians(1.5612);
        Task rotateToTask = taskFactory.createRotateTo(turtle, destinationAngle);
        assertTrue(rotateToTask instanceof RotateToTask);
    }

    @Test
    public void shouldCreateRotateToTaskWithCorrectTurtle() {
        Angle destinationAngle = Angle.radians(1.5612);
        Task rotateToTask = taskFactory.createRotateTo(turtle, destinationAngle);
        assertEquals(turtle, rotateToTask.getTurtle());
    }

    @Test
    public void shouldCreateRotateToTaskWithCorrectDestinationAngle() {
        Angle destinationAngle = Angle.radians(1.5612);
        Task rotateToTask = taskFactory.createRotateTo(turtle, destinationAngle);
        assertEquals(destinationAngle, ((RotateToTask)rotateToTask).getDestinationAngle());
    }

    @Test
    public void shouldCreateChangePenStateTaskOfCorrectType() {
        PenState newPenState = PenState.UP;
        Task changePenStateTask = taskFactory.createChangePenState(turtle, newPenState);
        assertTrue(changePenStateTask instanceof ChangePenStateTask);
    }

    @Test
    public void shouldCreateChangePenStateTaskWithCorrectTurtle() {
        PenState newPenState = PenState.UP;
        Task changePenStateTask = taskFactory.createChangePenState(turtle, newPenState);
        assertEquals(turtle, changePenStateTask.getTurtle());
    }

    @Test
    public void shouldCreateChangePenStateTaskWithCorrectPenState() {
        PenState newPenState = PenState.UP;
        Task changePenStateTask = taskFactory.createChangePenState(turtle, newPenState);
        assertEquals(newPenState, ((ChangePenStateTask)changePenStateTask).getNewPenState());
    }

    @Test
    public void shouldCreateChangePenColorTaskOfCorrectType() {
        Color newPenColor = Color.rgb(61, 128, 13);
        Task changePenColorTask = taskFactory.createChangePenColor(turtle, newPenColor);
        assertTrue(changePenColorTask instanceof ChangePenColorTask);
    }

    @Test
    public void shouldCreateChangePenColorTaskWithCorrectTurtle() {
        Color newPenColor = Color.rgb(61, 128, 13);
        Task changePenColorTask = taskFactory.createChangePenColor(turtle, newPenColor);
        assertEquals(turtle, changePenColorTask.getTurtle());
    }

    @Test
    public void shouldCreateChangePenColorTaskWithCorrectPenColor() {
        Color newPenColor = Color.rgb(61, 128, 13);
        Task changePenColorTask = taskFactory.createChangePenColor(turtle, newPenColor);
        assertEquals(newPenColor, ((ChangePenColorTask)changePenColorTask).getNewPenColor());
    }

    @Test
    public void shouldCreateChangeFillColorTaskOfCorrectType() {
        Color newFillColor = Color.rgb(13, 76, 152);
        Task changeFillColorTask = taskFactory.createChangeFillColor(turtle, newFillColor);
        assertTrue(changeFillColorTask instanceof ChangeFillColorTask);
    }

    @Test
    public void shouldCreateChangeFillColorTaskWithCorrectTurtle() {
        Color newFillColor = Color.rgb(13, 76, 152);
        Task changeFillColorTask = taskFactory.createChangeFillColor(turtle, newFillColor);
        assertEquals(turtle, changeFillColorTask.getTurtle());
    }

    @Test
    public void shouldCreateChangeFillColorTaskWithCorrectFillColor() {
        Color newFillColor = Color.rgb(13, 76, 152);
        Task changeFillColorTask = taskFactory.createChangeFillColor(turtle, newFillColor);
        assertEquals(newFillColor, ((ChangeFillColorTask)changeFillColorTask).getNewFillColor());
    }

    @Test
    public void shouldCreateChangeSpeedTaskOfCorrectType() {
        double newSpeed = 0.8912;
        Task changeSpeedTask = taskFactory.createChangeSpeed(turtle, newSpeed);
        assertTrue(changeSpeedTask instanceof ChangeSpeedTask);
    }

    @Test
    public void shouldCreateChangeSpeedTaskWithCorrectTurtle() {
        double newSpeed = 0.8912;
        Task changeSpeedTask = taskFactory.createChangeSpeed(turtle, newSpeed);
        assertEquals(turtle, changeSpeedTask.getTurtle());
    }

    @Test
    public void shouldCreateChangeSpeedTaskWithCorrectSpeed() {
        double newSpeed = 0.8912;
        Task changeSpeedTask = taskFactory.createChangeSpeed(turtle, newSpeed);
        assertEquals(newSpeed, ((ChangeSpeedTask)changeSpeedTask).getNewSpeed(), 0);
    }
}
