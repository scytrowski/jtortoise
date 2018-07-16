package nullpointer.jtortoise.core.buffers;

import nullpointer.jtortoise.core.Command;
import nullpointer.jtortoise.core.CommandProcessor;

import java.util.Collection;

class CommandProcessorChecker {
    public boolean checkIfAllCanProcess(Collection<CommandProcessor> commandProcessors, Command command) {
        for (CommandProcessor commandProcessor : commandProcessors) {
            if (!commandProcessor.canProcess(command))
                return false;
        }
        return true;
    }
}
