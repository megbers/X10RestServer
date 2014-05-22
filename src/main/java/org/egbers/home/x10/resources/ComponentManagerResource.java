package org.egbers.home.x10.resources;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;
import org.egbers.home.x10.domain.X10Component;
import org.egbers.home.x10.domain.X10ComponentJSONSerializer;
import org.egbers.home.x10.service.ComponentManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//TODO Make these the correct HTTP verbs
@Component
@Path("manager")
public class ComponentManagerResource {
	
	@Autowired
	private ComponentManagerService componentManagerService;
	@Autowired
	private X10ComponentJSONSerializer x10ComponentJSONSerializer;
	//private List<X10Component> componentList;
	
	@GET
	@Path("AddComponent/{houseCode}/{unitCode}/{commonName}/{type}")
	@Produces(APPLICATION_JSON)
	public Response addComponent(@PathParam("houseCode") String houseCode, @PathParam("unitCode") Integer unitCode, 
			@PathParam("commonName") String commonName, @PathParam("type") Integer type) throws Exception {
		X10Component component = new X10Component();
		component.setCommonName(commonName);
		component.setHouseCode(houseCode);
		component.setUnitCode(unitCode);
		component.setType(type);
		component.setIconLocation(getIconImageLocation(type));
		
		component = componentManagerService.save(component);
		JSONObject returnObject = x10ComponentJSONSerializer.serialize(component);
		return Response.status(Status.OK).entity(returnObject).build();
		
	}
	
	private String getIconImageLocation(Integer type) {
		switch(type) {
        case 0:
            return "img/light_icon.png";
        case 1:
            return "img/switch_icon.png";
        case 2:
            return "img/appliance_icon.png";
        case 3:
            return "img/outlet_icon.jpg";
        default:
        	return "";
		}
	}
	
	@GET
	@Path("AllComponents")
	@Produces(APPLICATION_JSON)
	public Response getAll() throws Exception {
		List<X10Component> componentList = componentManagerService.listAll();
		JSONArray returnObject = new JSONArray();
		for(X10Component component : componentList) {
			returnObject.put(x10ComponentJSONSerializer.serialize(component));
		}
		return Response.status(Status.OK).entity(returnObject).build();
	}
	
	@GET
	@Path("DeleteComponent/{id}")
	@Produces(APPLICATION_JSON)
	public Response deleteById(@PathParam("id") Long id) throws Exception {
		JSONObject returnObject = new JSONObject();
		returnObject.put("success", componentManagerService.delete(id));
		return Response.status(Status.OK).entity(returnObject).build();
	}
}
