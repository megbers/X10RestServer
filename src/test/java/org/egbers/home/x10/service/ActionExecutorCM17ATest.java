package org.egbers.home.x10.service;

import org.egbers.home.x10.domain.Action;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ActionExecutorCM17ATest {
    private ActionExecutorCM17A executor;
    private Runtime rt;
    private Process process;

    @Before
    public void setUp() {
        executor = new ActionExecutorCM17A();
        rt = mock(Runtime.class);
        executor.setRuntime(rt);
        process = mock(Process.class);
    }

    @Test
    public void shouldCallActivateWhenPassedOn() throws Exception {
        String command = "cm17a 1 a1on";
        Action action = new Action("A", "1", 1);
        when(rt.exec(command)).thenReturn(process);

        executor.execute(action);

        verify(rt).exec(command);
    }

    @Test
    public void shouldCallDeactivateWhenPassedOff() throws Exception {
        String command = "cm17a 1 a1off";
        Action action = new Action("A", "1", 0);
        when(rt.exec(command)).thenReturn(process);

        executor.execute(action);

        verify(rt).exec(command);
    }
}
