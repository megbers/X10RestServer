package org.egbers.home.x10.service;

import org.springframework.beans.factory.annotation.Autowired;

public class LightService {

	private static final int ON = 1;
	private static final int OFF = 0;
	
	@Autowired
	private ActionExecutor actionExecutor;
	
	public boolean turnOn(String houseCode, String unitCode) {
		Action action = new Action(houseCode, unitCode, ON);
		actionExecutor.execute(action);
		return true;
	}
	
	public boolean turnOff(String houseCode, String unitCode) {
		Action action = new Action(houseCode, unitCode, OFF);
		actionExecutor.execute(action);
		return true;
	}

	public void setActionExecutor(ActionExecutor actionExecutor) {
		this.actionExecutor = actionExecutor;
	}
	
}
