package common.process_runtime;

import org.apache.commons.exec.CommandLine;
import org.junit.Test;

public class CommonsExecTest {

    @Test
    public void testCommandLine(){
        String cmdStr = "notepad.exe";
        CommandLine cmdLine = new CommandLine(cmdStr);
    }
}
