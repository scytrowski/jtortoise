package nullpointer.jtortoise.core.buffers;

import nullpointer.jtortoise.commands.Command;
import nullpointer.jtortoise.core.CommandBuffer;
import nullpointer.jtortoise.core.CommandBufferException;

class SequentialCommandBuffer implements CommandBuffer {
    private final CommandQueue commandQueue;
    private final Thread processingThread;

    SequentialCommandBuffer(CommandQueue commandQueue, CommandProcessingThreadFactory processingThreadFactory) {
        this.commandQueue = commandQueue;
        processingThread = processingThreadFactory.create(commandQueue);
        processingThread.start();
    }

    SequentialCommandBuffer(CommandProcessingThreadFactory processingThreadFactory) {
        this(new CommandQueue(), processingThreadFactory);
    }

    @Override
    public void submit(Command command) throws CommandBufferException {
        try {
            commandQueue.enqueue(command);
        } catch (CommandQueueException ex) {
            throw new CommandBufferException("Cannot submit command", ex);
        }
    }
}
