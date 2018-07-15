package nullpointer.jtortoise.core;

import nullpointer.jtortoise.commands.Command;

import java.util.Collection;
import java.util.concurrent.CompletableFuture;

public class AggregatedCommandProcessor implements CommandProcessor {
    private final Collection<CommandProcessor> aggregatedProcessors;

    public AggregatedCommandProcessor(Collection<CommandProcessor> aggregatedProcessors) {
        this.aggregatedProcessors = aggregatedProcessors;
    }

    @Override
    public boolean canProcess(Command command) {
        for (CommandProcessor processor : aggregatedProcessors) {
            if (!processor.canProcess(command))
                return false;
        }
        return true;
    }

    @Override
    public CompletableFuture<Void> process(Command command) {
        CompletableFuture[] futures = new CompletableFuture[aggregatedProcessors.size()];
        int i = 0;
        for (CommandProcessor processor : aggregatedProcessors) {
            futures[i] = processor.process(command);
            i += 1;
        }
        return CompletableFuture.allOf(futures);
    }
}
