import org.junit.Test;
import static org.junit.Assert.*;

public class ErrorLogTest {

    @Test
    public void printError() throws Exception {
        String file = "testfile";
        String description = "Error reading file.";

        assertEquals("testfile caused an error. Error reading file.", file + " caused an error. " + description);
    }
}