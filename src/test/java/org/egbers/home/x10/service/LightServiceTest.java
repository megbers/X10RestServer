package org.egbers.home.x10.service;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class LightServiceTest {
	
	@Mock
	private ActionExecutor executor;
	@InjectMocks
	private LightService service = new LightService();
	private String houseCode;
	private String unitCode;
	
	@Before
	public void setUp() {
		houseCode = "A";
		unitCode = "1";
	}
	
	@Test
	public void turnOnShouldCallExecute() throws Exception {
		doNothing().when(executor).execute(any(Action.class));
		service.turnOn(houseCode, unitCode);
		verify(executor).execute(any(Action.class));
	}
	
	@Test
	public void turnOffShouldCallExecute() throws Exception {
		doNothing().when(executor).execute(any(Action.class));
		service.turnOff(houseCode, unitCode);
		verify(executor).execute(any(Action.class));
	}
	
	@Test(expected=RuntimeException.class)
	public void turnOnShouldThrowExceptionWhenExecutorDoes() throws Exception {
		doThrow(new RuntimeException()).when(executor).execute(any(Action.class));
		service.turnOn(houseCode, unitCode);
	}
	
	@Test(expected=RuntimeException.class)
	public void turnOffShouldThrowExceptionWhenExecutorDoes() throws Exception {
		doThrow(new RuntimeException()).when(executor).execute(any(Action.class));
		service.turnOff(houseCode, unitCode);
	}
}
