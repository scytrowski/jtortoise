package nullpointer.jtortoise.core;

import javafx.scene.shape.MoveTo;
import nullpointer.jtortoise.geometry.Angle;
import nullpointer.jtortoise.geometry.Point;
import nullpointer.jtortoise.graphics.Color;
import nullpointer.jtortoise.graphics.PenState;
import nullpointer.jtortoise.graphics.Turtle;
import nullpointer.jtortoise.tasks.MoveToTask;
import nullpointer.jtortoise.tasks.Task;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class TurtleObserverImplTest {
    private final TaskFactory taskFactory = mock(TaskFactory.class);
    private final TurtleTaskExecutor taskExecutor = mock(TurtleTaskExecutor.class);
    private final TurtleObserverImpl observer = new TurtleObserverImpl(taskFactory, taskExecutor);
    private final Turtle turtle = mock(Turtle.class);

    @Test
    public void shouldSubmitCorrectTaskOnceOnMoveTo() {
        Point destination = Point.cartesian(-5.671, 13.981);
        Task moveToTask = mock(Task.class);
        when(taskFactory.createMoveTo(turtle, destination)).thenReturn(moveToTask);
        observer.onMoveTo(turtle, destination);
        verify(taskExecutor, times(1)).submit(moveToTask);
    }

    @Test
    public void shouldSubmitCorrectTaskOnceOnRotateTo() {
        Angle destinationAngle = Angle.radians(1.982);
        Task rotateToTask = mock(Task.class);
        when(taskFactory.createRotateTo(turtle, destinationAngle)).thenReturn(rotateToTask);
        observer.onRotateTo(turtle, destinationAngle);
        verify(taskExecutor, times(1)).submit(rotateToTask);
    }

    @Test
    public void shouldSubmitCorrectTaskOnceOnChangePenState() {
        PenState newPenState = PenState.UP;
        Task changePenStateTask = mock(Task.class);
        when(taskFactory.createChangePenState(turtle, newPenState)).thenReturn(changePenStateTask);
        observer.onChangePenState(turtle, newPenState);
        verify(taskExecutor, times(1)).submit(changePenStateTask);
    }

    @Test
    public void shouldSubmitCorrectTaskOnceOnChangePenColor() {
        Color newPenColor = Color.rgb(25, 78, 115);
        Task changePenColorTask = mock(Task.class);
        when(taskFactory.createChangePenColor(turtle, newPenColor)).thenReturn(changePenColorTask);
        observer.onChangePenColor(turtle, newPenColor);
        verify(taskExecutor, times(1)).submit(changePenColorTask);
    }

    @Test
    public void shouldSubmitCorrectTaskOnceOnChangeFillColor() {
        Color newFillColor = Color.rgb(25, 78, 115);
        Task changeFillColorTask = mock(Task.class);
        when(taskFactory.createChangeFillColor(turtle, newFillColor)).thenReturn(changeFillColorTask);
        observer.onChangeFillColor(turtle, newFillColor);
        verify(taskExecutor, times(1)).submit(changeFillColorTask);
    }

    @Test
    public void shouldSubmitCorrectTaskOnceOnChangeSpeed() {
        double newSpeed = 0.6719;
        Task changeSpeedTask = mock(Task.class);
        when(taskFactory.createChangeSpeed(turtle, newSpeed)).thenReturn(changeSpeedTask);
        observer.onChangeSpeed(turtle, newSpeed);
        verify(taskExecutor, times(1)).submit(changeSpeedTask);
    }
}
