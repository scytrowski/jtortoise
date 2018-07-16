package nullpointer.jtortoise.core.buffers;

import nullpointer.jtortoise.core.Command;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class CommandQueue {
    private final BlockingQueue<Command> queue;

    CommandQueue(BlockingQueue<Command> queue) {
        this.queue = queue;
    }

    CommandQueue() {
        this(new LinkedBlockingQueue<>());
    }

    public void enqueue(Command command) throws CommandQueueException {
        try {
            queue.put(command);
        } catch (InterruptedException ex) {
            throw new CommandQueueException("Cannot put to queue", ex);
        }
    }

    public Command dequeue() throws CommandQueueException {
        try {
            return queue.take();
        } catch (InterruptedException ex) {
            throw new CommandQueueException("Cannot take from queue", ex);
        }
    }
}
