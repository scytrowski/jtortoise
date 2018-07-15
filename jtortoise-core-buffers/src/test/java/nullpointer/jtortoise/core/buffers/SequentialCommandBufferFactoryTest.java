package nullpointer.jtortoise.core.buffers;

import nullpointer.jtortoise.core.CommandBuffer;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class SequentialCommandBufferFactoryTest {
    private final CommandProcessingThreadFactory processingThreadFactory = mock(CommandProcessingThreadFactory.class);
    private final Thread processingThread = mock(Thread.class);
    private final SequentialCommandBufferFactory bufferFactory = new SequentialCommandBufferFactory(processingThreadFactory);

    @Before
    public void before() {
        when(processingThreadFactory.create(any())).thenReturn(processingThread);
    }

    @Test
    public void shouldCreateInstanceOfSequentialCommandBuffer() {
        CommandBuffer result = bufferFactory.create();
        assertTrue(result instanceof SequentialCommandBuffer);
    }
}
