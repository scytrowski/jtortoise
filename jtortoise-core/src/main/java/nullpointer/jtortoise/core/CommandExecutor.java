package nullpointer.jtortoise.core;

public class CommandExecutor {
    private final CommandBuffer buffer;
    private final CommandExecutionExceptionHandler exceptionHandler;
    private final CommandExecutionExceptionFactory exceptionFactory;

    CommandExecutor(CommandBuffer buffer, CommandExecutionExceptionHandler exceptionHandler, CommandExecutionExceptionFactory exceptionFactory) {
        this.buffer = buffer;
        this.exceptionHandler = exceptionHandler;
        this.exceptionFactory = exceptionFactory;
    }

    public CommandExecutor(CommandBuffer buffer, CommandExecutionExceptionHandler exceptionHandler) {
        this(buffer, exceptionHandler, new CommandExecutionExceptionFactory());
    }

    public void execute(Command command) {
        try {
            buffer.submit(command);
        } catch (CommandBufferException ex) {
            emitExceptionToHandle(ex);
        }
    }

    private void emitExceptionToHandle(Exception exception) {
        CommandExecutionException executionException = exceptionFactory.create("Cannot execute command", exception);
        exceptionHandler.handle(executionException);
    }
}
