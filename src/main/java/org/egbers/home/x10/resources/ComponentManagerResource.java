package org.egbers.home.x10.resources;

import org.egbers.home.x10.domain.X10Component;
import org.egbers.home.x10.domain.X10Response;
import org.egbers.home.x10.service.ComponentManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

//TODO Make these the correct HTTP verbs
@Component
@Path("manager")
public class ComponentManagerResource {
	
	@Autowired
	private ComponentManagerService componentManagerService;

	@GET
	@Path("AddComponent/{houseCode}/{unitCode}/{commonName}/{type}")
	@Produces(APPLICATION_JSON)
	public X10Component addComponent(@PathParam("houseCode") String houseCode, @PathParam("unitCode") Integer unitCode,
			@PathParam("commonName") String commonName, @PathParam("type") Integer type) throws Exception {
		X10Component component = new X10Component();
		component.setCommonName(commonName);
		component.setHouseCode(houseCode);
		component.setUnitCode(unitCode);
		component.setType(type);
		component.setIconLocation(getIconImageLocation(type));
		
		return componentManagerService.save(component);
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
	public List<X10Component> getAll() throws Exception {
		return componentManagerService.listAll();
	}

	@GET
	@Path("DeleteComponent/{id}")
	@Produces(APPLICATION_JSON)
	public X10Response deleteById(@PathParam("id") Long id) throws Exception {
        return new X10Response(componentManagerService.delete(id));
	}
}
