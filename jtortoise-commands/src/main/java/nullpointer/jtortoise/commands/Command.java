package nullpointer.jtortoise.commands;

import nullpointer.jtortoise.turtles.Turtle;

public abstract class Command {
    private final Turtle turtle;

    public Command(Turtle turtle) {
        this.turtle = turtle;
    }

    public Turtle getTurtle() {
        return turtle;
    }
}
