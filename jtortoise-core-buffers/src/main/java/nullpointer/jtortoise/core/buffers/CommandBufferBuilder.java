package nullpointer.jtortoise.core.buffers;

import nullpointer.jtortoise.core.CommandBuffer;
import nullpointer.jtortoise.core.CommandProcessor;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class CommandBufferBuilder {
    private final Set<CommandProcessor> commandProcessors;
    private final CommandBufferPreparer sequentialBufferPreparer;
    private final CommandBufferPreparer parallelBufferPreparer;
    private final CommandProcessorAggregator commandProcessorAggregator;

    CommandBufferBuilder(Set<CommandProcessor> commandProcessors, CommandBufferPreparer sequentialBufferPreparer, CommandBufferPreparer parallelBufferPreparer, CommandProcessorAggregator commandProcessorAggregator) {
        this.commandProcessors = commandProcessors;
        this.sequentialBufferPreparer = sequentialBufferPreparer;
        this.parallelBufferPreparer = parallelBufferPreparer;
        this.commandProcessorAggregator = commandProcessorAggregator;
    }

    public CommandBufferBuilder() {
        this(new HashSet<>(), new SequentialCommandBufferPreparer(), new ParallelCommandBufferPreparer(), new CommandProcessorAggregator());
    }

    public CommandBufferBuilder withCommandProcessor(CommandProcessor commandProcessor) {
        commandProcessors.add(commandProcessor);
        return this;
    }

    public CommandBuffer buildSequential() {
        CommandProcessor commandProcessor = prepareCommandProcessor();
        return sequentialBufferPreparer.prepare(commandProcessor);
    }

    public CommandBuffer buildParallel() {
        CommandProcessor commandProcessor = prepareCommandProcessor();
        return parallelBufferPreparer.prepare(commandProcessor);
    }

    public Collection<CommandProcessor> getCommandProcessors() {
        return Collections.unmodifiableCollection(commandProcessors);
    }

    private CommandProcessor prepareCommandProcessor() {
        return commandProcessorAggregator.aggregate(commandProcessors);
    }
}
