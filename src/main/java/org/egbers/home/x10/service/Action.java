package org.egbers.home.x10.service;

public class Action {
	protected String socket;
	protected String house;
	protected int value;

	public Action(String house, String socket, int value) {
		this.house = house;
		this.socket = socket;
		this.value = value;
	}

	public String getSocket() {
		return socket;
	}

	public String getHouse() {
		return house;
	}

	public int getValue() {
		return value;
	}
}
