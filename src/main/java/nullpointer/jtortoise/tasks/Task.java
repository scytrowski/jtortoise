package nullpointer.jtortoise.tasks;

import nullpointer.jtortoise.graphics.Turtle;

public abstract class Task {
    private final Turtle turtle;

    public Task(Turtle turtle) {
        this.turtle = turtle;
    }

    public Turtle getTurtle() {
        return turtle;
    }
}
