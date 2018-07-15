package nullpointer.jtortoise.core.buffers;

import nullpointer.jtortoise.core.CommandBuffer;

class SequentialCommandBufferFactory {
    private final CommandProcessingThreadFactory processingThreadFactory;

    SequentialCommandBufferFactory(CommandProcessingThreadFactory processingThreadFactory) {
        this.processingThreadFactory = processingThreadFactory;
    }

    public CommandBuffer create() {
        return new SequentialCommandBuffer(processingThreadFactory);
    }
}
