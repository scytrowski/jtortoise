package nullpointer.jtortoise.core.buffers;

import nullpointer.jtortoise.core.CommandBuffer;
import nullpointer.jtortoise.core.CommandProcessor;

interface CommandBufferPreparer {
    CommandBuffer prepare(CommandProcessor commandProcessor);
}
