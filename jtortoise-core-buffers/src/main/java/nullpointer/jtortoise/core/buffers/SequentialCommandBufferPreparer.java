package nullpointer.jtortoise.core.buffers;

import nullpointer.jtortoise.core.CommandBuffer;
import nullpointer.jtortoise.core.CommandProcessor;

class SequentialCommandBufferPreparer implements CommandBufferPreparer {
    public CommandBuffer prepare(CommandProcessor commandProcessor) {
        CommandProcessingThreadFactory processingThreadFactory = new CommandProcessingThreadFactory(commandProcessor);
        return new SequentialCommandBuffer(processingThreadFactory);
    }
}
