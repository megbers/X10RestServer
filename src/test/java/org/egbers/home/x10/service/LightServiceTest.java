package org.egbers.home.x10.service;

import org.egbers.x10.jfirecracker.X10Executor;
import org.egbers.x10.jfirecracker.X10Message;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class LightServiceTest {
	
	@Mock
	private X10Executor executor;
	@InjectMocks
	private LightService service = new LightService();
	private String houseCode;
	private Integer unitCode;
	
	@Before
	public void setUp() {
		houseCode = "A";
		unitCode = 1;
	}
	
	@Test
	public void turnOnShouldCallExecute() throws Exception {

		doNothing().when(executor).execute(any(X10Message.class));
		service.turnOn(houseCode, unitCode);
		verify(executor).execute(any(X10Message.class));
	}
	
	@Test
	public void turnOffShouldCallExecute() throws Exception {
		doNothing().when(executor).execute(any(X10Message.class));
		service.turnOff(houseCode, unitCode);
		verify(executor).execute(any(X10Message.class));
	}
	
	@Test(expected=RuntimeException.class)
	public void turnOnShouldThrowExceptionWhenExecutorDoes() throws Exception {
		doThrow(new RuntimeException()).when(executor).execute(any(X10Message.class));
		service.turnOn(houseCode, unitCode);
	}
	
	@Test(expected=RuntimeException.class)
	public void turnOffShouldThrowExceptionWhenExecutorDoes() throws Exception {
		doThrow(new RuntimeException()).when(executor).execute(any(X10Message.class));
		service.turnOff(houseCode, unitCode);
	}
}
