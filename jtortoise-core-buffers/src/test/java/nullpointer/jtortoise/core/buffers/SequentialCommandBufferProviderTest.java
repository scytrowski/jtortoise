package nullpointer.jtortoise.core.buffers;

import nullpointer.jtortoise.core.CommandBuffer;
import nullpointer.jtortoise.core.CommandSource;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.ConcurrentMap;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class SequentialCommandBufferProviderTest {
    @SuppressWarnings("unchecked")
    private final ConcurrentMap<CommandSource, CommandBuffer> sourceBuffers = (ConcurrentMap<CommandSource, CommandBuffer>) mock(ConcurrentMap.class);
    private final SequentialCommandBufferFactory bufferFactory = mock(SequentialCommandBufferFactory.class);
    private final SequentialCommandBufferProvider bufferProvider = new SequentialCommandBufferProvider(sourceBuffers, bufferFactory);
    private final CommandSource source = mock(CommandSource.class);
    private final CommandBuffer turtleBuffer = mock(CommandBuffer.class);

    @Before
    public void before() {
        when(bufferFactory.create()).thenReturn(turtleBuffer);
        when(sourceBuffers.get(source)).thenReturn(turtleBuffer);
    }

    @Test
    public void shouldCheckIfContainSourceBufferOnce() {
        bufferProvider.provide(source);
        verify(sourceBuffers, times(1)).containsKey(source);
    }

    @Test
    public void shouldReturnSourceBufferIfContain() {
        when(sourceBuffers.containsKey(source)).thenReturn(true);
        CommandBuffer result = bufferProvider.provide(source);
        assertEquals(turtleBuffer, result);
    }

    @Test
    public void shouldCreateSourceBufferOnceIfNotContain() {
        when(sourceBuffers.containsKey(source)).thenReturn(false);
        bufferProvider.provide(source);
        verify(bufferFactory, times(1)).create();
    }

    @Test
    public void shouldPutCreatedBufferOnceIfNotContain() {
        when(sourceBuffers.containsKey(source)).thenReturn(false);
        bufferProvider.provide(source);
        verify(sourceBuffers, times(1)).put(source, turtleBuffer);
    }

    @Test
    public void shouldReturnCreatedBufferIfNotContain() {
        when(sourceBuffers.containsKey(source)).thenReturn(false);
        CommandBuffer result = bufferProvider.provide(source);
        assertEquals(turtleBuffer, result);
    }
}
