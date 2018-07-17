package nullpointer.jtortoise.core.buffers;

import nullpointer.jtortoise.core.Command;
import nullpointer.jtortoise.core.CommandBuffer;
import nullpointer.jtortoise.core.CommandBufferException;
import nullpointer.jtortoise.core.CommandSource;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class ParallelCommandBufferTest {
    private final SequentialCommandBufferProvider bufferProvider = mock(SequentialCommandBufferProvider.class);
    private final ParallelCommandBuffer buffer = new ParallelCommandBuffer(bufferProvider);
    private final Command command = mock(Command.class);
    private final CommandSource source = mock(CommandSource.class);
    private final CommandBuffer turtleBuffer = mock(CommandBuffer.class);

    @Before
    public void before() {
        when(command.getSource()).thenReturn(source);
        when(bufferProvider.provide(source)).thenReturn(turtleBuffer);
    }

    @Test
    public void shouldGetCommandSourceOnce() throws CommandBufferException {
        buffer.submit(command);
        verify(command, times(1)).getSource();
    }

    @Test
    public void shouldProvideSourceBufferOnce() throws CommandBufferException {
        buffer.submit(command);
        verify(bufferProvider, times(1)).provide(source);
    }

    @Test
    public void shouldSubmitToSourceBufferOnce() throws CommandBufferException {
        buffer.submit(command);
        verify(turtleBuffer, times(1)).submit(command);
    }
}
