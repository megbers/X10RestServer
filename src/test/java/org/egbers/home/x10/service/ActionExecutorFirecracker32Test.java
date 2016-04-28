package org.egbers.home.x10.service;

import org.egbers.home.x10.domain.Action;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ActionExecutorFirecracker32Test {
    private ActionExecutorFirecracker32 executor;
    private Runtime rt;
    private Process process;

    @Before
    public void setUp() {
        executor = new ActionExecutorFirecracker32();
        rt = mock(Runtime.class);
        executor.setRuntime(rt);
        process = mock(Process.class);
    }

    @Test
    public void shouldCallActivateWhenPassedOn() throws Exception {
        String command = "Fireck32 /c=1 /h=a /d=1 /a=on";
        Action action = new Action("A", "1", 1);
        when(rt.exec(command)).thenReturn(process);

        executor.execute(action);

        verify(rt).exec(command);
    }

    @Test
    public void shouldCallDeactivateWhenPassedOff() throws Exception {
        String command = "Fireck32 /c=1 /h=a /d=1 /a=off";
        Action action = new Action("A", "1", 0);
        when(rt.exec(command)).thenReturn(process);

        executor.execute(action);

        verify(rt).exec(command);
    }
}
