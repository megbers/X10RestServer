package org.egbers.home.x10.resources;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.egbers.home.x10.service.LightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
@Path("light")
public class LightControllerResource {
	
	@Autowired
	private LightService lightService;
	
	@GET
	@Path("on/{house}/{unit}")
	@Produces(APPLICATION_JSON)
	public JSONObject turnOn(@PathParam("house") String houseCode, @PathParam("unit") String unitCode) throws JSONException {
		boolean success = lightService.turnOn(houseCode, unitCode);
		JSONObject response = new JSONObject();
		response.put("success", success);
		return response;
	}
	
	@GET
	@Path("off/{house}/{unit}")
	@Produces(APPLICATION_JSON)
	public JSONObject turnOff(@PathParam("house") String houseCode, @PathParam("unit") String unitCode) throws JSONException {
		boolean success = lightService.turnOff(houseCode, unitCode);
		JSONObject response = new JSONObject();
		response.put("success", success);
		return response;
	}

	public void setLightService(LightService lightService) {
		this.lightService = lightService;
	}
	
}
