package nullpointer.jtortoise.core.buffers;

class CommandProcessingException extends Exception {
    CommandProcessingException() {
        super();
    }

    CommandProcessingException(String message) {
        super(message);
    }

    CommandProcessingException(Throwable cause) {
        super(cause);
    }

    CommandProcessingException(String message, Throwable cause) {
        super(message, cause);
    }
}
