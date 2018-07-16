package nullpointer.jtortoise.core.buffers;

import nullpointer.jtortoise.core.Command;
import nullpointer.jtortoise.core.CommandBufferException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.mockito.Mockito.*;

public class SequentialCommandBufferTest {
    private final CommandQueue commandQueue = mock(CommandQueue.class);
    private final CommandProcessingThreadFactory processingThreadFactory = mock(CommandProcessingThreadFactory.class);
    private final Thread processingThread = mock(Thread.class);
    private SequentialCommandBuffer buffer;
    private final Command command = mock(Command.class);

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void before() {
        when(processingThreadFactory.create(commandQueue)).thenReturn(processingThread);
        buffer = new SequentialCommandBuffer(commandQueue, processingThreadFactory);
    }

    @Test
    public void shouldCreateProcessingThreadOnceOnCreation() {
        verify(processingThreadFactory, times(1)).create(commandQueue);
    }

    @Test
    public void shouldStartProcessingThreadOnceOnCreation() {
        verify(processingThread, times(1)).start();
    }

    @Test
    public void shouldEnqueueCommandOnce() throws CommandBufferException, CommandQueueException {
        buffer.submit(command);
        verify(commandQueue, times(1)).enqueue(command);
    }

    @Test
    public void shouldThrowCommandBufferExceptionWhenCatchCommandQueueException() throws CommandBufferException, CommandQueueException {
        doThrow(new CommandQueueException()).when(commandQueue).enqueue(command);
        expectedException.expect(CommandBufferException.class);
        buffer.submit(command);
    }
}
