package org.egbers.home.x10.service;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

public class ActionExecutorBottleRocketTest {
	private ActionExecutorBottleRocket executor;
	private Runtime rt;
	private Process process;

	@Before
	public void setUp() {
		executor = new ActionExecutorBottleRocket();
		rt = mock(Runtime.class);
		executor.setRuntime(rt);
		process = mock(Process.class);
	}

	@Test
	public void shouldCallActivateWhenPassedOn() throws Exception {
		String command = "br --port=/dev/ttyS0 --house=A --on=1";
		Action action = new Action("A", "1", 1);
		when(rt.exec(command)).thenReturn(process);

		executor.execute(action);

		verify(rt).exec(command);
	}
	
	@Test
	public void shouldCallDeactivateWhenPassedOff() throws Exception {
		String command = "br --port=/dev/ttyS0 --house=A --off=1";
		Action action = new Action("A", "1", 0);
		when(rt.exec(command)).thenReturn(process);

		executor.execute(action);

		verify(rt).exec(command);
	}
	
}
