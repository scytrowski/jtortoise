package nullpointer.jtortoise.core.buffers;

import nullpointer.jtortoise.core.CommandBuffer;
import nullpointer.jtortoise.core.CommandProcessor;
import org.junit.Test;

import java.util.Collection;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class CommandBufferBuilderTest {
    private final CommandBufferBuilder bufferBuilder = new CommandBufferBuilder();
    private final CommandProcessor commandProcessor = mock(CommandProcessor.class);

    @Test
    public void shouldAddCommandProcessorOnWithCommandProcessor() {
        bufferBuilder.withCommandProcessor(commandProcessor);
        Collection<CommandProcessor> commandProcessors = bufferBuilder.getCommandProcessors();
        assertTrue(commandProcessors.contains(commandProcessor));
    }

    @Test
    public void shouldReturnThisOnWithCommandProcessor() {
        CommandBufferBuilder result = bufferBuilder.withCommandProcessor(commandProcessor);
        assertEquals(bufferBuilder, result);
    }

    @Test
    public void shouldReturnInstanceOfSequentialCommandBufferOnBuildSequential() {
        CommandBuffer result = bufferBuilder.buildSequential();
        assertTrue(result instanceof SequentialCommandBuffer);
    }

    @Test
    public void shouldReturnInstanceOfParallelCommandBufferOnBuildParallel() {
        CommandBuffer result = bufferBuilder.buildParallel();
        assertTrue(result instanceof ParallelCommandBuffer);
    }
}
