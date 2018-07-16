package nullpointer.jtortoise.core.buffers;

import nullpointer.jtortoise.core.CommandBuffer;
import nullpointer.jtortoise.core.CommandProcessor;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class CommandBufferBuilderTest {
    @SuppressWarnings("unchecked")
    private final Set<CommandProcessor> commandProcessors = (Set<CommandProcessor>) mock(Set.class);
    private final CommandBufferPreparer sequentialBufferPreparer = mock(CommandBufferPreparer.class);
    private final CommandBuffer sequentialBuffer = mock(CommandBuffer.class);
    private final CommandBufferPreparer parallelBufferPreparer = mock(CommandBufferPreparer.class);
    private final CommandBuffer parallelBuffer = mock(CommandBuffer.class);
    private final CommandProcessorAggregator commandProcessorAggregator = mock(CommandProcessorAggregator.class);
    private final CommandProcessor aggregatedCommandProcessor = mock(CommandProcessor.class);
    private final CommandBufferBuilder bufferBuilder = new CommandBufferBuilder(commandProcessors, sequentialBufferPreparer, parallelBufferPreparer, commandProcessorAggregator);
    private final CommandProcessor commandProcessor = mock(CommandProcessor.class);

    @Before
    public void before() {
        when(sequentialBufferPreparer.prepare(aggregatedCommandProcessor)).thenReturn(sequentialBuffer);
        when(parallelBufferPreparer.prepare(aggregatedCommandProcessor)).thenReturn(parallelBuffer);
        when(commandProcessorAggregator.aggregate(commandProcessors)).thenReturn(aggregatedCommandProcessor);
    }

    @Test
    public void shouldAddCommandProcessorOnWithCommandProcessor() {
        bufferBuilder.withCommandProcessor(commandProcessor);
        verify(commandProcessors, times(1)).add(commandProcessor);
    }

    @Test
    public void shouldReturnThisOnWithCommandProcessor() {
        CommandBufferBuilder result = bufferBuilder.withCommandProcessor(commandProcessor);
        assertEquals(bufferBuilder, result);
    }

    @Test
    public void shouldAggregateCommandProcessorsOnceOnBuildSequential() {
        bufferBuilder.buildSequential();
        verify(commandProcessorAggregator, times(1)).aggregate(commandProcessors);
    }

    @Test
    public void shouldPrepareSequentialBufferOnceOnBuildSequential() {
        bufferBuilder.buildSequential();
        verify(sequentialBufferPreparer, times(1)).prepare(aggregatedCommandProcessor);
    }

    @Test
    public void shouldReturnPreparedSequentialBufferOnBuildSequential() {
        CommandBuffer result = bufferBuilder.buildSequential();
        assertEquals(sequentialBuffer, result);
    }

    @Test
    public void shouldAggregateCommandProcessorsOnceOnBuildParallel() {
        bufferBuilder.buildParallel();
        verify(commandProcessorAggregator, times(1)).aggregate(commandProcessors);
    }

    @Test
    public void shouldPrepareParallelBufferOnceOnBuildParallel() {
        bufferBuilder.buildParallel();
        verify(parallelBufferPreparer, times(1)).prepare(aggregatedCommandProcessor);
    }

    @Test
    public void shouldReturnPreparedParallelBufferOnBuildParallel() {
        CommandBuffer buffer = bufferBuilder.buildParallel();
        assertEquals(parallelBuffer, buffer);
    }
}
