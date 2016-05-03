package org.egbers.home.x10.resources;

import org.egbers.home.x10.domain.X10Macro;
import org.egbers.home.x10.domain.X10Response;
import org.egbers.home.x10.service.MacroManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Component
@Path("macro")
public class MacroResource {
    @Autowired
    private MacroManagerService macroManagerService;

    @POST
    @Path("add")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public X10Macro addMacro(X10Macro macro) {
        return macroManagerService.save(macro);
    }

    @GET
    @Path("all")
    @Produces(APPLICATION_JSON)
    public List<X10Macro> getAll() throws Exception {
        return macroManagerService.listAll();
    }

    @GET
    @Path("delete/{id}")
    @Produces(APPLICATION_JSON)
    public X10Response deleteById(@PathParam("id") Long id) throws Exception {
        return new X10Response(macroManagerService.delete(id));
    }

    @GET
    @Path("run/{id}")
    @Produces(APPLICATION_JSON)
    public X10Response run(@PathParam("id") Long id) throws Exception {
        X10Response response = new X10Response();
        try{
            macroManagerService.run(id);
            response.setSuccess(true);
        }catch(Exception e) {
            response.setSuccess(false);
            response.setErrorMessage(e.getMessage());
        }
        return response;
    }
}
