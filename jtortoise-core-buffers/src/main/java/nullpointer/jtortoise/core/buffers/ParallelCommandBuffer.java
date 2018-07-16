package nullpointer.jtortoise.core.buffers;

import nullpointer.jtortoise.core.Command;
import nullpointer.jtortoise.core.CommandBuffer;
import nullpointer.jtortoise.core.CommandBufferException;
import nullpointer.jtortoise.core.Turtle;

class ParallelCommandBuffer implements CommandBuffer {
    private final SequentialCommandBufferProvider bufferProvider;

    ParallelCommandBuffer(SequentialCommandBufferProvider bufferProvider) {
        this.bufferProvider = bufferProvider;
    }

    @Override
    public void submit(Command command) throws CommandBufferException {
        Turtle turtle = command.getTurtle();
        CommandBuffer turtleBuffer = bufferProvider.provide(turtle);
        turtleBuffer.submit(command);
    }
}
