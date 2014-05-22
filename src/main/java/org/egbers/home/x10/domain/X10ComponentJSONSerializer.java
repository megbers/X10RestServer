package org.egbers.home.x10.domain;

import org.codehaus.jettison.json.JSONObject;

public class X10ComponentJSONSerializer {
	public JSONObject serialize(X10Component component) throws Exception{
		JSONObject object = new JSONObject();
		object.put("id", component.getId());
		object.put("commonName", component.getCommonName());
		object.put("houseCode", component.getHouseCode());
		object.put("iconLocation", component.getIconLocation());
		object.put("unitCode", component.getUnitCode());
		object.put("type", component.getType());
		return object;
	}
 }
