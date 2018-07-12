package nullpointer.jtortoise.core;

import nullpointer.jtortoise.geometry.Angle;
import nullpointer.jtortoise.geometry.Point;
import nullpointer.jtortoise.graphics.Color;
import nullpointer.jtortoise.graphics.PenState;
import nullpointer.jtortoise.graphics.Turtle;
import nullpointer.jtortoise.tasks.*;

public class TurtleObserverImpl implements TurtleObserver {
    private final TaskFactory taskFactory;
    private final TurtleTaskExecutor taskExecutor;

    public TurtleObserverImpl(TaskFactory taskFactory, TurtleTaskExecutor taskExecutor) {
        this.taskFactory = taskFactory;
        this.taskExecutor = taskExecutor;
    }

    @Override
    public void onMoveTo(Turtle turtle, Point destination) {
        submitMoveToTask(turtle, destination);
    }

    @Override
    public void onRotateTo(Turtle turtle, Angle destinationAngle) {
        submitRotateToTask(turtle, destinationAngle);
    }

    @Override
    public void onChangePenState(Turtle turtle, PenState newPenState) {
        submitChangePenStateTask(turtle, newPenState);
    }

    @Override
    public void onChangePenColor(Turtle turtle, Color newPenColor) {
        submitChangePenColorTask(turtle, newPenColor);
    }

    @Override
    public void onChangeFillColor(Turtle turtle, Color newFillColor) {
        submitChangeFillColorTask(turtle, newFillColor);
    }

    @Override
    public void onChangeSpeed(Turtle turtle, double newSpeed) {
        submitChangeSpeedTask(turtle, newSpeed);
    }

    private void submitMoveToTask(Turtle turtle, Point destination) {
        submitTask(taskFactory.createMoveTo(turtle, destination));
    }

    private void submitRotateToTask(Turtle turtle, Angle destinationAngle) {
        submitTask(taskFactory.createRotateTo(turtle, destinationAngle));
    }

    private void submitChangePenStateTask(Turtle turtle, PenState newPenState) {
        submitTask(taskFactory.createChangePenState(turtle, newPenState));
    }

    private void submitChangePenColorTask(Turtle turtle, Color newPenColor) {
        submitTask(taskFactory.createChangePenColor(turtle, newPenColor));
    }

    private void submitChangeFillColorTask(Turtle turtle, Color newFillColor) {
        submitTask(taskFactory.createChangeFillColor(turtle, newFillColor));
    }

    private void submitChangeSpeedTask(Turtle turtle, double newSpeed) {
        submitTask(taskFactory.createChangeSpeed(turtle, newSpeed));
    }

    private void submitTask(Task task) {
        taskExecutor.submit(task);
    }
}
