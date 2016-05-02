package org.egbers.home.x10.service;

import org.egbers.x10.jfirecracker.Action;
import org.egbers.x10.jfirecracker.X10Executor;
import org.egbers.x10.jfirecracker.X10Message;
import org.springframework.beans.factory.annotation.Autowired;

public class LightService {

	@Autowired
	private X10Executor actionExecutor;

	public boolean turnOn(String houseCode, Integer unitCode) throws Exception {
		X10Message action = new X10Message(houseCode, unitCode, Action.ON);
		actionExecutor.execute(action);
		return true;
	}
	
	public boolean turnOff(String houseCode, Integer unitCode) throws Exception {
		X10Message action = new X10Message(houseCode, unitCode, Action.OFF);
		actionExecutor.execute(action);
		return true;
	}

	public void setActionExecutor(X10Executor actionExecutor) {
        System.out.println("Injecting actionExecutor: " + (actionExecutor.getClass().getName()));
		this.actionExecutor = actionExecutor;
	}

}
