package nullpointer.jtortoise.core;

public class CommandBufferException extends Exception {
    public CommandBufferException() {
        super();
    }

    public CommandBufferException(String message) {
        super(message);
    }

    public CommandBufferException(Throwable cause) {
        super(cause);
    }

    public CommandBufferException(String message, Throwable cause) {
        super(message, cause);
    }
}
