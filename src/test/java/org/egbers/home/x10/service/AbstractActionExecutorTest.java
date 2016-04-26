package org.egbers.home.x10.service;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class AbstractActionExecutorTest {
    private AbstractActionExecutor abstractActionExecutor;
    private Runtime rt;
    private Process process;

    @Before
    public void setup() {
        abstractActionExecutor = new AbstractActionExecutor() {};
        rt = mock(Runtime.class);
        process = mock(Process.class);
        abstractActionExecutor.setRuntime(rt);
    }

    @Test
    public void callShouldExecuteCommandOnRuntime() throws Exception {
        String command = "";
        when(rt.exec(command)).thenReturn(process);

        abstractActionExecutor.call(command);

        verify(rt).exec(command);
    }

    @Test(expected=RuntimeException.class)
    public void callShouldThrowExceptionWhenRuntimeThrowsException() throws Exception {
        String command = "Throws Exception";
        when(rt.exec(command)).thenThrow(new RuntimeException());

        abstractActionExecutor.call(command);
    }
}
