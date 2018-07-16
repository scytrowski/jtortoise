package nullpointer.jtortoise.core.buffers;

import nullpointer.jtortoise.commands.Command;
import nullpointer.jtortoise.core.CommandProcessor;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;
import java.util.concurrent.CompletableFuture;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class AggregatedCommandProcessorTest {
    @SuppressWarnings("unchecked")
    private final Collection<CommandProcessor> aggregatedProcessors = (Collection<CommandProcessor>) mock(Collection.class);
    private final CommandProcessorChecker commandProcessorChecker = mock(CommandProcessorChecker.class);
    private final CommandProcessorRunner commandProcessorRunner = mock(CommandProcessorRunner.class);
    private final CompletableFutureAggregator futureAggregator = mock(CompletableFutureAggregator.class);
    private final AggregatedCommandProcessor processor = new AggregatedCommandProcessor(aggregatedProcessors, commandProcessorChecker, commandProcessorRunner, futureAggregator);
    @SuppressWarnings("unchecked")
    private final Collection<CompletableFuture<Void>> futures = (Collection<CompletableFuture<Void>>) mock(Collection.class);
    @SuppressWarnings("unchecked")
    private final CompletableFuture<Void> aggregatedFuture = (CompletableFuture<Void>) mock(CompletableFuture.class);
    private final Command command = mock(Command.class);

    @Before
    public void before() {
        when(commandProcessorRunner.runAll(aggregatedProcessors, command)).thenReturn(futures);
        when(futureAggregator.aggregate(futures)).thenReturn(aggregatedFuture);
    }

    @Test
    public void shouldCheckIfCanProcessAllOnceOnCanProcess() {
        processor.canProcess(command);
        verify(commandProcessorChecker, times(1)).checkIfAllCanProcess(aggregatedProcessors, command);
    }

    @Test
    public void shouldRunAllProcessorsOnceOnProcess() {
        processor.process(command);
        verify(commandProcessorRunner, times(1)).runAll(aggregatedProcessors, command);
    }

    @Test
    public void shouldAggregateFuturesOnceOnProcess() {
        processor.process(command);
        verify(futureAggregator, times(1)).aggregate(futures);
    }

    @Test
    public void shouldReturnCorrectAggregatedFutureOnProcess() {
        CompletableFuture<Void> result = processor.process(command);
        assertEquals(aggregatedFuture, result);
    }
}
