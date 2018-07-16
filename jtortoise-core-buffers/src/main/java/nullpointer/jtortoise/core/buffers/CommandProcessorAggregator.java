package nullpointer.jtortoise.core.buffers;

import nullpointer.jtortoise.core.AggregatedCommandProcessor;
import nullpointer.jtortoise.core.CommandProcessor;

import java.util.Collection;

class CommandProcessorAggregator {
    public CommandProcessor aggregate(Collection<CommandProcessor> commandProcessors) {
        return new AggregatedCommandProcessor(commandProcessors);
    }
}
