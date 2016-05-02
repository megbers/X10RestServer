package org.egbers.home.x10.resources;

import org.egbers.home.x10.domain.X10Response;
import org.egbers.home.x10.service.LightService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LightControllerResourceTest {
	
	@Mock
	private LightService lightService;
	@InjectMocks
	private LightControllerResource resource = new LightControllerResource();
	private String houseCode = "H";
	private Integer unitCode = 1;
	
	@Test
	public void turnOffShouldReturnSuccessWhenSuccessful() throws Exception {
		when(lightService.turnOff(houseCode, unitCode)).thenReturn(true);
		X10Response result = resource.turnOff(houseCode, unitCode);
		assertTrue(result.getSuccess());
	}
	
	@Test
	public void turnOnShouldReturnSuccessWhenSuccessful() throws Exception {
		when(lightService.turnOn(houseCode, unitCode)).thenReturn(true);
        X10Response result = resource.turnOn(houseCode, unitCode);
		assertTrue(result.getSuccess());
	}
	
	@Test
	public void turnOnShouldReturnFailureWhenExceptionIsRaised() throws Exception {
		when(lightService.turnOn(houseCode, unitCode)).thenThrow(new RuntimeException());
        X10Response result = resource.turnOn(houseCode, unitCode);
		assertFalse(result.getSuccess());
	}
	
	@Test
	public void turnOffShouldReturnFailureWhenExceptionIsRaised() throws Exception {
		when(lightService.turnOff(houseCode, unitCode)).thenThrow(new RuntimeException());
        X10Response result = resource.turnOff(houseCode, unitCode);
		assertFalse(result.getSuccess());
	}
	 
}
