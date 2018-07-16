package nullpointer.jtortoise.core.buffers;

import nullpointer.jtortoise.core.Command;
import nullpointer.jtortoise.core.CommandProcessor;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

class CommandProcessingWorker {
    private CommandQueue commandQueue;
    private CommandProcessor commandProcessor;

    CommandProcessingWorker(CommandQueue commandQueue, CommandProcessor commandProcessor) {
        this.commandQueue = commandQueue;
        this.commandProcessor = commandProcessor;
    }

    public void processCommand() throws CommandProcessingException {
        try {
            Command commandToProcess = commandQueue.dequeue();
            if (commandProcessor.canProcess(commandToProcess)) {
                CompletableFuture<Void> commandProcessingFuture = commandProcessor.process(commandToProcess);
                commandProcessingFuture.get();
            }
        } catch (CommandQueueException ex) {
            throw new CommandProcessingException("Cannot dequeue command", ex);
        } catch (InterruptedException | ExecutionException ex) {
            throw new CommandProcessingException("Cannot process command", ex);
        }
    }
}
