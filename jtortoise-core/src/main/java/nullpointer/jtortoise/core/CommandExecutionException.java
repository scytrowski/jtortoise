package nullpointer.jtortoise.core;

public class CommandExecutionException extends Exception {
    public CommandExecutionException() {
        super();
    }

    public CommandExecutionException(String message) {
        super(message);
    }

    public CommandExecutionException(Throwable cause) {
        super(cause);
    }

    public CommandExecutionException(String message, Throwable cause) {
        super(message, cause);
    }
}
