package nullpointer.jtortoise.core;

import nullpointer.jtortoise.commands.Command;

public interface CommandBuffer {
    void submit(Command command) throws CommandBufferException;
}
