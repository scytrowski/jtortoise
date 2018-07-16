package nullpointer.jtortoise.core.buffers;

import nullpointer.jtortoise.core.Command;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.concurrent.BlockingQueue;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class CommandQueueTest {
    @SuppressWarnings("unchecked")
    private final BlockingQueue<Command> queue = (BlockingQueue<Command>) mock(BlockingQueue.class);
    private final CommandQueue commandQueue = new CommandQueue(queue);
    private final Command command = mock(Command.class);

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void before() throws InterruptedException {
        when(queue.take()).thenReturn(command);
    }

    @Test
    public void shouldPutToQueueOnceOnEnqueue() throws CommandQueueException, InterruptedException {
        commandQueue.enqueue(command);
        verify(queue, times(1)).put(command);
    }

    @Test
    public void shouldThrowCommandQueueExceptionWhenCatchInterruptedExceptionOnEnqueue() throws CommandQueueException, InterruptedException {
        doThrow(new InterruptedException()).when(queue).put(command);
        expectedException.expect(CommandQueueException.class);
        commandQueue.enqueue(command);
    }

    @Test
    public void shouldTakeFromQueueOnceOnDequeue() throws CommandQueueException, InterruptedException {
        commandQueue.dequeue();
        verify(queue, times(1)).take();
    }

    @Test
    public void shouldReturnTakenCommandOnDequeue() throws CommandQueueException {
        Command result = commandQueue.dequeue();
        assertEquals(command, result);
    }

    @Test
    public void shouldThrowCommandQueueExceptionWhenCatchInterruptedExceptionOnDequeue() throws CommandQueueException, InterruptedException {
        when(queue.take()).thenThrow(new InterruptedException());
        expectedException.expect(CommandQueueException.class);
        commandQueue.dequeue();
    }
}
