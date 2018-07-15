package nullpointer.jtortoise.core.buffers;

import nullpointer.jtortoise.core.AggregatedCommandProcessor;
import nullpointer.jtortoise.core.CommandBuffer;
import nullpointer.jtortoise.core.CommandProcessor;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class CommandBufferBuilder {
    private final Set<CommandProcessor> commandProcessors = new HashSet<>();
    private CommandProcessingThreadFactory processingThreadFactory;

    public CommandBufferBuilder withCommandProcessor(CommandProcessor commandProcessor) {
        commandProcessors.add(commandProcessor);
        return this;
    }

    public CommandBuffer buildSequential() {
        createCommonDependencies();
        return new SequentialCommandBuffer(processingThreadFactory);
    }

    public CommandBuffer buildParallel() {
        createCommonDependencies();
        SequentialCommandBufferFactory bufferFactory = new SequentialCommandBufferFactory(processingThreadFactory);
        SequentialCommandBufferProvider bufferProvider = new SequentialCommandBufferProvider(bufferFactory);
        return new ParallelCommandBuffer(bufferProvider);
    }

    public Collection<CommandProcessor> getCommandProcessors() {
        return Collections.unmodifiableCollection(commandProcessors);
    }

    private void createCommonDependencies() {
        CommandProcessor aggregatedCommandProcessor = new AggregatedCommandProcessor(commandProcessors);
        processingThreadFactory = new CommandProcessingThreadFactory(aggregatedCommandProcessor);
    }
}
