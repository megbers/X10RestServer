package org.egbers.home.x10.resources;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.egbers.home.x10.domain.X10Response;
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
	public X10Response turnOn(@PathParam("house") String houseCode, @PathParam("unit") String unitCode) {
        X10Response response = new X10Response();
		try{
            response.setSuccess(lightService.turnOn(houseCode, unitCode));
		}catch(Exception e) {
			response.setSuccess(false);
			response.setErrorMessage(e.getMessage());
		}
		return response;
	}
	
	@GET
	@Path("off/{house}/{unit}")
	@Produces(APPLICATION_JSON)
	public X10Response turnOff(@PathParam("house") String houseCode, @PathParam("unit") String unitCode) {
        X10Response response = new X10Response();
        try{
            response.setSuccess(lightService.turnOff(houseCode, unitCode));
        }catch(Exception e) {
            response.setSuccess(false);
            response.setErrorMessage(e.getMessage());
        }
        return response;
	}

}
