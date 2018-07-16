package nullpointer.jtortoise.core;

public interface CommandBuffer {
    void submit(Command command) throws CommandBufferException;
}
