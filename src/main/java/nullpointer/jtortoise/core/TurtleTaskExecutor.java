package nullpointer.jtortoise.core;

import nullpointer.jtortoise.tasks.Task;

import java.util.concurrent.CompletableFuture;

public interface TurtleTaskExecutor {
    CompletableFuture<Void> submit(Task task);
}
