package nullpointer.jtortoise.core.buffers;

import nullpointer.jtortoise.core.CommandProcessor;

class CommandProcessingThreadFactory {
    private final CommandProcessor commandProcessor;

    CommandProcessingThreadFactory(CommandProcessor commandProcessor) {
        this.commandProcessor = commandProcessor;
    }

    public Thread create(CommandQueue commandQueue) {
        CommandProcessingWorker processingWorker = new CommandProcessingWorker(commandQueue, commandProcessor);
        return new Thread(() -> threadAction(processingWorker));
    }

    private void threadAction(CommandProcessingWorker processingWorker) {
        try {
            while (true) {
                processingWorker.processCommand();
            }
        } catch (CommandProcessingException ex) {

        }
    }
}
