package nullpointer.jtortoise.core;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.mockito.Mockito.*;

public class CommandExecutorTest {
    private final CommandBuffer buffer = mock(CommandBuffer.class);
    private final CommandExecutionExceptionHandler exceptionHandler = mock(CommandExecutionExceptionHandler.class);
    private final CommandExecutionExceptionFactory exceptionFactory = mock(CommandExecutionExceptionFactory.class);
    private final CommandExecutor commandExecutor = new CommandExecutor(buffer, exceptionHandler, exceptionFactory);
    private final CommandBufferException commandBufferException = mock(CommandBufferException.class);
    private final CommandExecutionException executionException = mock(CommandExecutionException.class);
    private final Command command = mock(Command.class);

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void before() {
        when(exceptionFactory.create(any(), eq(commandBufferException))).thenReturn(executionException);
    }

    @Test
    public void shouldSubmitCommandOnce() throws CommandExecutionException, CommandBufferException {
        commandExecutor.execute(command);
        verify(buffer, times(1)).submit(command);
    }

    @Test
    public void shouldCreateCommandExecutionExceptionOnceWhenCatchCommandBufferException() throws CommandBufferException {
        doThrow(commandBufferException).when(buffer).submit(command);
        commandExecutor.execute(command);
        verify(exceptionFactory, times(1)).create(any(), eq(commandBufferException));
    }

    @Test
    public void shouldHandleCommandExecutionExceptionOnceWhenCatchCommandBufferException() throws CommandBufferException {
        doThrow(commandBufferException).when(buffer).submit(command);
        commandExecutor.execute(command);
        verify(exceptionHandler, times(1)).handle(executionException);
    }
}
