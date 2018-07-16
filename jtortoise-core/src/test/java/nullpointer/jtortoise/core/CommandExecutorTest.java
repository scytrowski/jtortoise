package nullpointer.jtortoise.core;

import nullpointer.jtortoise.commands.Command;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.mockito.Mockito.*;

public class CommandExecutorTest {
    private final CommandBuffer buffer = mock(CommandBuffer.class);
    private final CommandExecutor commandExecutor = new CommandExecutor(buffer);
    private final Command command = mock(Command.class);

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void shouldSubmitCommandOnce() throws CommandExecutionException, CommandBufferException {
        commandExecutor.execute(command);
        verify(buffer, times(1)).submit(command);
    }

    @Test
    public void shouldThrowCommandExecutionExceptionWhenCatchCommandBufferException() throws CommandBufferException, CommandExecutionException {
        doThrow(new CommandBufferException()).when(buffer).submit(command);
        expectedException.expect(CommandExecutionException.class);
        commandExecutor.execute(command);
    }
}
