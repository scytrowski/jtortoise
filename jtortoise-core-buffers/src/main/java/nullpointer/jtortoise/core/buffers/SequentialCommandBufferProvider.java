package nullpointer.jtortoise.core.buffers;

import nullpointer.jtortoise.core.CommandBuffer;
import nullpointer.jtortoise.core.Turtle;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

class SequentialCommandBufferProvider {
    private final ConcurrentMap<Turtle, CommandBuffer> turtleBuffers;
    private final SequentialCommandBufferFactory bufferFactory;

    SequentialCommandBufferProvider(ConcurrentMap<Turtle, CommandBuffer> turtleBuffers, SequentialCommandBufferFactory bufferFactory) {
        this.turtleBuffers = turtleBuffers;
        this.bufferFactory = bufferFactory;
    }

    SequentialCommandBufferProvider(SequentialCommandBufferFactory bufferFactory) {
        this(new ConcurrentHashMap<>(), bufferFactory);
    }

    public CommandBuffer provide(Turtle turtle) {
        if (turtleBuffers.containsKey(turtle))
            return turtleBuffers.get(turtle);
        else {
            CommandBuffer turtleBuffer = bufferFactory.create();
            turtleBuffers.put(turtle, turtleBuffer);
            return turtleBuffer;
        }
    }
}
