package nullpointer.jtortoise.core.buffers;

import nullpointer.jtortoise.core.CommandBuffer;
import nullpointer.jtortoise.core.CommandSource;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

class SequentialCommandBufferProvider {
    private final ConcurrentMap<CommandSource, CommandBuffer> sourceBuffers;
    private final SequentialCommandBufferFactory bufferFactory;

    SequentialCommandBufferProvider(ConcurrentMap<CommandSource, CommandBuffer> sourceBuffers, SequentialCommandBufferFactory bufferFactory) {
        this.sourceBuffers = sourceBuffers;
        this.bufferFactory = bufferFactory;
    }

    SequentialCommandBufferProvider(SequentialCommandBufferFactory bufferFactory) {
        this(new ConcurrentHashMap<>(), bufferFactory);
    }

    public CommandBuffer provide(CommandSource source) {
        if (sourceBuffers.containsKey(source))
            return sourceBuffers.get(source);
        else {
            CommandBuffer turtleBuffer = bufferFactory.create();
            sourceBuffers.put(source, turtleBuffer);
            return turtleBuffer;
        }
    }
}
