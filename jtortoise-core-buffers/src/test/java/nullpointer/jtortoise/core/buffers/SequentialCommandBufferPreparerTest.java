package nullpointer.jtortoise.core.buffers;

import nullpointer.jtortoise.core.CommandBuffer;
import nullpointer.jtortoise.core.CommandProcessor;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

public class SequentialCommandBufferPreparerTest {
    private final SequentialCommandBufferPreparer preparer = new SequentialCommandBufferPreparer();
    private final CommandProcessor commandProcessor = mock(CommandProcessor.class);

    @Test
    public void shouldReturnInstanceOfSequentialCommandBuffer() {
        CommandBuffer result = preparer.prepare(commandProcessor);
        assertTrue(result instanceof SequentialCommandBuffer);
    }
}
