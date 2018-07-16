package nullpointer.jtortoise.core.buffers;

import nullpointer.jtortoise.core.CommandProcessor;
import org.junit.Test;

import java.util.Collection;
import java.util.Collections;

import static org.junit.Assert.assertTrue;

public class CommandProcessorAggregatorTest {
    private final CommandProcessorAggregator commandProcessorAggregator = new CommandProcessorAggregator();
    private final Collection<CommandProcessor> commandProcessors = Collections.emptyList();

    @Test
    public void shouldReturnInstanceOfAggregatedCommandProcessor() {
        CommandProcessor result = commandProcessorAggregator.aggregate(commandProcessors);
        assertTrue(result instanceof AggregatedCommandProcessor);
    }
}
