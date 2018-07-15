package nullpointer.jtortoise.core;

import nullpointer.jtortoise.commands.Command;

import java.util.concurrent.CompletableFuture;

public interface CommandProcessor {
    boolean canProcess(Command command);
    CompletableFuture<Void> process(Command command);
}
