package nullpointer.jtortoise.core.buffers;

class CommandQueueException extends Exception {
    CommandQueueException() {
        super();
    }

    CommandQueueException(String message) {
        super(message);
    }

    CommandQueueException(Throwable cause) {
        super(cause);
    }

    CommandQueueException(String message, Throwable cause) {
        super(message, cause);
    }
}
