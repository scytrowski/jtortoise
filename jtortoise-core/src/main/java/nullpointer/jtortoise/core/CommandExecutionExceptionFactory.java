package nullpointer.jtortoise.core;

class CommandExecutionExceptionFactory {
    public CommandExecutionException create(String message, Throwable cause) {
        return new CommandExecutionException(message, cause);
    }
}
