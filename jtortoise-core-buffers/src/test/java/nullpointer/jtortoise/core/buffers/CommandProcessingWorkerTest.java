package nullpointer.jtortoise.core.buffers;

import nullpointer.jtortoise.core.Command;
import nullpointer.jtortoise.core.CommandProcessor;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static org.mockito.Mockito.*;

public class CommandProcessingWorkerTest {
    private final CommandQueue commandQueue = mock(CommandQueue.class);
    private final CommandProcessor commandProcessor = mock(CommandProcessor.class);
    private final CommandProcessingWorker worker = new CommandProcessingWorker(commandQueue, commandProcessor);
    private final Command command = mock(Command.class);
    @SuppressWarnings("unchecked")
    private final CompletableFuture<Void> commandProcessingFuture = (CompletableFuture<Void>) mock(CompletableFuture.class);

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void before() throws CommandQueueException {
        when(commandQueue.dequeue()).thenReturn(command);
        when(commandProcessor.canProcess(command)).thenReturn(true);
        when(commandProcessor.process(command)).thenReturn(commandProcessingFuture);
    }

    @Test
    public void shouldDequeueCommandOnce() throws CommandProcessingException, CommandQueueException {
        worker.processCommand();
        verify(commandQueue, times(1)).dequeue();
    }

    @Test
    public void shouldCheckIfCanProcessCommandOnce() throws CommandProcessingException {
        worker.processCommand();
        verify(commandProcessor, times(1)).canProcess(command);
    }

    @Test
    public void shouldProcessCommandOnce() throws CommandProcessingException {
        worker.processCommand();
        verify(commandProcessor, times(1)).process(command);
    }

    @Test
    public void shouldWaitProcessingFutureOnce() throws CommandProcessingException, ExecutionException, InterruptedException {
        worker.processCommand();
        verify(commandProcessingFuture, times(1)).get();
    }

    @Test
    public void shouldThrowCommandProcessingExceptionWhenCatchCommandQueueException() throws CommandQueueException, CommandProcessingException {
        when(commandQueue.dequeue()).thenThrow(new CommandQueueException());
        expectedException.expect(CommandProcessingException.class);
        worker.processCommand();
    }

    @Test
    public void shouldThrowCommandProcessingExceptionWhenCatchInterruptedException() throws ExecutionException, InterruptedException, CommandProcessingException {
        when(commandProcessingFuture.get()).thenThrow(new InterruptedException());
        expectedException.expect(CommandProcessingException.class);
        worker.processCommand();
    }

    @Test
    public void shouldThrowCommandProcessingExceptionWhenCatchExecutionException() throws ExecutionException, InterruptedException, CommandProcessingException {
        when(commandProcessingFuture.get()).thenThrow(mock(ExecutionException.class));
        expectedException.expect(CommandProcessingException.class);
        worker.processCommand();
    }
}
