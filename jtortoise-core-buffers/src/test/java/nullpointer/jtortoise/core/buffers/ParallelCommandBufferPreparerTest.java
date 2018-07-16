package nullpointer.jtortoise.core.buffers;

import nullpointer.jtortoise.core.CommandBuffer;
import nullpointer.jtortoise.core.CommandProcessor;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

public class ParallelCommandBufferPreparerTest {
    private final ParallelCommandBufferPreparer preparer = new ParallelCommandBufferPreparer();
    private final CommandProcessor commandProcessor = mock(CommandProcessor.class);

    @Test
    public void shouldReturnInstanceOfParallelCommandBuffer() {
        CommandBuffer result = preparer.prepare(commandProcessor);
        assertTrue(result instanceof ParallelCommandBuffer);
    }
}
