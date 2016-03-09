package org.egbers.home.x10.resources;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import org.codehaus.jettison.json.JSONObject;
import org.egbers.home.x10.service.LightService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class LightControllerResourceTest {
	
	@Mock
	private LightService lightService;
	@InjectMocks
	private LightControllerResource resource = new LightControllerResource();
	private String houseCode = "H";
	private String unitCode = "U";
	
	@Test
	public void turnOffShouldReturnSuccessWhenSuccessful() throws Exception {
		when(lightService.turnOff(houseCode, unitCode)).thenReturn(true);
		JSONObject result = resource.turnOff(houseCode, unitCode);
		assertTrue(result.getBoolean("success"));
	}
	
	@Test
	public void turnOnShouldReturnSuccessWhenSuccessful() throws Exception {
		when(lightService.turnOn(houseCode, unitCode)).thenReturn(true);
		JSONObject result = resource.turnOn(houseCode, unitCode);
		assertTrue(result.getBoolean("success"));
	}
	
	@Test
	public void turnOnShouldReturnFailureWhenExceptionIsRaised() throws Exception {
		when(lightService.turnOn(houseCode, unitCode)).thenThrow(new RuntimeException());
		JSONObject result = resource.turnOn(houseCode, unitCode);
		assertFalse(result.getBoolean("success"));
	}
	
	@Test
	public void turnOffShouldReturnFailureWhenExceptionIsRaised() throws Exception {
		when(lightService.turnOff(houseCode, unitCode)).thenThrow(new RuntimeException());
		JSONObject result = resource.turnOff(houseCode, unitCode);
		assertFalse(result.getBoolean("success"));
	}
	 
}