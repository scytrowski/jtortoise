package nullpointer.jtortoise.core.buffers;

import nullpointer.jtortoise.commands.Command;
import nullpointer.jtortoise.core.CommandProcessor;

import java.util.Collection;
import java.util.concurrent.CompletableFuture;

class AggregatedCommandProcessor implements CommandProcessor {
    private final Collection<CommandProcessor> aggregatedProcessors;
    private final CommandProcessorChecker commandProcessorChecker;
    private final CommandProcessorRunner commandProcessorRunner;
    private final CompletableFutureAggregator futureAggregator;

    AggregatedCommandProcessor(Collection<CommandProcessor> aggregatedProcessors, CommandProcessorChecker commandProcessorChecker, CommandProcessorRunner commandProcessorRunner, CompletableFutureAggregator futureAggregator) {
        this.aggregatedProcessors = aggregatedProcessors;
        this.commandProcessorChecker = commandProcessorChecker;
        this.commandProcessorRunner = commandProcessorRunner;
        this.futureAggregator = futureAggregator;
    }

    AggregatedCommandProcessor(Collection<CommandProcessor> aggregatedProcessors) {
        this(aggregatedProcessors, new CommandProcessorChecker(), new CommandProcessorRunner(), new CompletableFutureAggregator());
    }

    @Override
    public boolean canProcess(Command command) {
        return commandProcessorChecker.checkIfAllCanProcess(aggregatedProcessors, command);
    }

    @Override
    public CompletableFuture<Void> process(Command command) {
        Collection<CompletableFuture<Void>> futures = commandProcessorRunner.runAll(aggregatedProcessors, command);
        return futureAggregator.aggregate(futures);
    }
}
