package nullpointer.jtortoise.core.buffers;

import nullpointer.jtortoise.commands.Command;
import nullpointer.jtortoise.core.CommandBuffer;
import nullpointer.jtortoise.core.CommandBufferException;
import nullpointer.jtortoise.turtles.Turtle;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class ParallelCommandBufferTest {
    private final SequentialCommandBufferProvider bufferProvider = mock(SequentialCommandBufferProvider.class);
    private final ParallelCommandBuffer buffer = new ParallelCommandBuffer(bufferProvider);
    private final Command command = mock(Command.class);
    private final Turtle turtle = mock(Turtle.class);
    private final CommandBuffer turtleBuffer = mock(CommandBuffer.class);

    @Before
    public void before() {
        when(command.getTurtle()).thenReturn(turtle);
        when(bufferProvider.provide(turtle)).thenReturn(turtleBuffer);
    }

    @Test
    public void shouldGetCommandTurtleOnce() throws CommandBufferException {
        buffer.submit(command);
        verify(command, times(1)).getTurtle();
    }

    @Test
    public void shouldProvideTurtleBufferOnce() throws CommandBufferException {
        buffer.submit(command);
        verify(bufferProvider, times(1)).provide(turtle);
    }

    @Test
    public void shouldSubmitToTurtleBufferOnce() throws CommandBufferException {
        buffer.submit(command);
        verify(turtleBuffer, times(1)).submit(command);
    }
}
