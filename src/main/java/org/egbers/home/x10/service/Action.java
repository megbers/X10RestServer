package org.egbers.home.x10.service;

public class Action {
	protected String socket;
	protected String house;
	protected boolean apply_to_all_sockets;
	protected int value;

	public Action(String house, int value) {
		this.house = house;
		this.apply_to_all_sockets = true;
		this.value = value;
	}

	public Action(String house, String socket, int value) {
		this.house = house;
		this.socket = socket;
		this.apply_to_all_sockets = false;
		this.value = value;
	}

	public String getSocket() {
		return socket;
	}

	public String getHouse() {
		return house;
	}

	public boolean getApplyToAllSockets() {
		return apply_to_all_sockets;
	}

	public int getValue() {
		return value;
	}
}
