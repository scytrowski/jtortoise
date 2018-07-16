package nullpointer.jtortoise.core;

import nullpointer.jtortoise.commands.Command;

public class CommandExecutor {
    private final CommandBuffer buffer;

    public CommandExecutor(CommandBuffer buffer) {
        this.buffer = buffer;
    }

    public void execute(Command command) throws CommandExecutionException {
        try {
            buffer.submit(command);
        } catch (CommandBufferException ex) {
            throw new CommandExecutionException("Cannot execute command", ex);
        }
    }
}
