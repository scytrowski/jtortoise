package nullpointer.jtortoise.core;

public abstract class Command {
    private final CommandSource source;

    public Command(CommandSource source) {
        this.source = source;
    }

    public CommandSource getSource() {
        return source;
    }
}
