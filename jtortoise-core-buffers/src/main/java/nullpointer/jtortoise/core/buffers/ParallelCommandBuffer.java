package nullpointer.jtortoise.core.buffers;

import nullpointer.jtortoise.core.Command;
import nullpointer.jtortoise.core.CommandBuffer;
import nullpointer.jtortoise.core.CommandBufferException;
import nullpointer.jtortoise.core.CommandSource;

class ParallelCommandBuffer implements CommandBuffer {
    private final SequentialCommandBufferProvider bufferProvider;

    ParallelCommandBuffer(SequentialCommandBufferProvider bufferProvider) {
        this.bufferProvider = bufferProvider;
    }

    @Override
    public void submit(Command command) throws CommandBufferException {
        CommandSource source = command.getSource();
        CommandBuffer sourceBuffer = bufferProvider.provide(source);
        sourceBuffer.submit(command);
    }
}
