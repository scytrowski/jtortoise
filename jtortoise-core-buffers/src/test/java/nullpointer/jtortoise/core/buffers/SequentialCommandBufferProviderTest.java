package nullpointer.jtortoise.core.buffers;

import nullpointer.jtortoise.core.CommandBuffer;
import nullpointer.jtortoise.core.Turtle;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.ConcurrentMap;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class SequentialCommandBufferProviderTest {
    @SuppressWarnings("unchecked")
    private final ConcurrentMap<Turtle, CommandBuffer> turtleBuffers = (ConcurrentMap<Turtle, CommandBuffer>) mock(ConcurrentMap.class);
    private final SequentialCommandBufferFactory bufferFactory = mock(SequentialCommandBufferFactory.class);
    private final SequentialCommandBufferProvider bufferProvider = new SequentialCommandBufferProvider(turtleBuffers, bufferFactory);
    private final Turtle turtle = mock(Turtle.class);
    private final CommandBuffer turtleBuffer = mock(CommandBuffer.class);

    @Before
    public void before() {
        when(bufferFactory.create()).thenReturn(turtleBuffer);
        when(turtleBuffers.get(turtle)).thenReturn(turtleBuffer);
    }

    @Test
    public void shouldCheckIfContainTurtleBufferOnce() {
        bufferProvider.provide(turtle);
        verify(turtleBuffers, times(1)).containsKey(turtle);
    }

    @Test
    public void shouldReturnTurtleBufferIfContain() {
        when(turtleBuffers.containsKey(turtle)).thenReturn(true);
        CommandBuffer result = bufferProvider.provide(turtle);
        assertEquals(turtleBuffer, result);
    }

    @Test
    public void shouldCreateTurtleBufferOnceIfNotContain() {
        when(turtleBuffers.containsKey(turtle)).thenReturn(false);
        bufferProvider.provide(turtle);
        verify(bufferFactory, times(1)).create();
    }

    @Test
    public void shouldPutCreatedBufferOnceIfNotContain() {
        when(turtleBuffers.containsKey(turtle)).thenReturn(false);
        bufferProvider.provide(turtle);
        verify(turtleBuffers, times(1)).put(turtle, turtleBuffer);
    }

    @Test
    public void shouldReturnCreatedBufferIfNotContain() {
        when(turtleBuffers.containsKey(turtle)).thenReturn(false);
        CommandBuffer result = bufferProvider.provide(turtle);
        assertEquals(turtleBuffer, result);
    }
}
