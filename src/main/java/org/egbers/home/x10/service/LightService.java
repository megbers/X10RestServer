package org.egbers.home.x10.service;

import java.io.IOException;

public class LightService {

	private static final int ON = 1;
	private static final int OFF = 0;
	
	private ActionExecutor actionExecutor;

	public boolean turnOn(String houseCode, String unitCode) throws IOException {
		Action action = new Action(houseCode, unitCode, ON);
		actionExecutor.execute(action);
		return true;
	}
	
	public boolean turnOff(String houseCode, String unitCode) throws IOException {
		Action action = new Action(houseCode, unitCode, OFF);
		actionExecutor.execute(action);
		return true;
	}

	public void setActionExecutor(ActionExecutor actionExecutor) {
        System.out.println("Injecting actionExecutor: " + (actionExecutor instanceof ActionExecutorFirecracker32));
		this.actionExecutor = actionExecutor;
	}

}
