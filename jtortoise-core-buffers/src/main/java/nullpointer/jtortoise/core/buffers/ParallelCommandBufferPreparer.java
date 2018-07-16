package nullpointer.jtortoise.core.buffers;

import nullpointer.jtortoise.core.CommandBuffer;
import nullpointer.jtortoise.core.CommandProcessor;

class ParallelCommandBufferPreparer implements CommandBufferPreparer {
    public CommandBuffer prepare(CommandProcessor commandProcessor) {
        CommandProcessingThreadFactory processingThreadFactory = new CommandProcessingThreadFactory(commandProcessor);
        SequentialCommandBufferFactory sequentialCommandBufferFactory = new SequentialCommandBufferFactory(processingThreadFactory);
        SequentialCommandBufferProvider sequentialCommandBufferProvider = new SequentialCommandBufferProvider(sequentialCommandBufferFactory);
        return new ParallelCommandBuffer(sequentialCommandBufferProvider);
    }
}
