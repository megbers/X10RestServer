package org.egbers.home.x10.service;

import java.io.IOException;

public class ActionExecutorBottleRocket implements ActionExecutor {
	private Runtime runtime;
	protected static final String program_name = "br";
	protected static final String port_param = "--port=";
	protected static final String house_param = "--house=";
	protected static final String on_param = "--on=";
	protected static final String off_param = "--off=";
	protected static final String on = "--ON";
	protected static final String off = "--OFF";

	protected static final String default_port = "/dev/ttyS0";
	protected static final String default_command_start = program_name + " "
			+ port_param + default_port + " " + house_param;

	public ActionExecutorBottleRocket() {
		runtime = Runtime.getRuntime();
	}

	protected void call(String command) throws IOException {
		runtime.exec(command);
	}

	public void activate(String house, String socket) throws IOException {
		String command = default_command_start + house + " " + on_param
				+ socket;
		call(command);
	}

	public void activate(String house) throws IOException {
		String command = default_command_start + house + " " + on;
		call(command);
	}

	public void deactivate(String house, String socket) throws IOException {
		String command = default_command_start + house + " " + off_param
				+ socket;
		call(command);
	}

	public void deactivate(String house) throws IOException {
		String command = default_command_start + house + " " + off;
		call(command);
	}

	public void execute(Action action) throws IOException {
		if (action.getApplyToAllSockets()) {
			if (action.getValue() == 1)
				activate(action.getHouse());
			else if (action.getValue() == 0)
				deactivate(action.getHouse());
		} else {
			if (action.getValue() == 1)
				activate(action.getHouse(), action.getSocket());
			else if (action.getValue() == 0)
				deactivate(action.getHouse(), action.getSocket());
		}
	}

	public void setRuntime(Runtime runtime) {
		this.runtime = runtime;
	}

}
