package org.egbers.home.x10.resources;

import com.owlike.genson.ext.jaxrs.GensonJsonConverter;
import org.glassfish.jersey.server.ResourceConfig;

public class X10RestServerApplication extends ResourceConfig {
    public X10RestServerApplication() {
        register(LightControllerResource.class);
        register(ComponentManagerResource.class);
        register(GensonJsonConverter.class);
    }
}
