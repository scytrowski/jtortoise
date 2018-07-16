package nullpointer.jtortoise.core.buffers;

import nullpointer.jtortoise.commands.Command;
import nullpointer.jtortoise.core.CommandProcessor;

import java.util.Collection;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

class CommandProcessorRunner {
    public Collection<CompletableFuture<Void>> runAll(Collection<CommandProcessor> commandProcessors, Command command) {
        return commandProcessors.stream()
                .map(p -> p.process(command))
                .collect(Collectors.toList());
    }
}
