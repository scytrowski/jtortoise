package nullpointer.jtortoise.core;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class CommandExecutionExceptionFactoryTest {
    private final CommandExecutionExceptionFactory exceptionFactory = new CommandExecutionExceptionFactory();
    private final String message = "Some exception message";
    private final Exception cause = mock(Exception.class);

    @Test
    public void shouldCreateCommandExecutionExceptionWithCorrectMessage() {
        CommandExecutionException result = exceptionFactory.create(message, cause);
        assertEquals(message, result.getMessage());
    }

    @Test
    public void shouldCreateCommandExecutionExceptionWithCorrectCause() {
        CommandExecutionException result = exceptionFactory.create(message, cause);
        assertEquals(cause, result.getCause());
    }
}
