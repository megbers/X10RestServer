package org.egbers.home.x10.domain;

import java.util.HashMap;
import java.util.Map;

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

    public int getSocketInt() {
        return Integer.valueOf(socket);
    }

	public String getHouse() {
		return house;
	}

	public int getValue() {
		return value;
	}

    public byte[] convertToBytes() {
        byte[] bytes = new byte[5];

        //Set Header and footer
        bytes[0] = (byte) 213;
        bytes[1] = (byte) 170;
        bytes[4] = (byte) 173;

        byte firstByte = (byte) (valueMapper.get(this.getHouse()) + (this.getSocketInt() > 8 ? 4 : 0));
        //If action is on or off
        byte secondByte = (byte) (valueMapper.get(this.getSocket()) + (this.getValue() == 1 ? 0 : 32));
        //else DIM or BRIGHT
        //byte secondByte = (byte) (136 + (action.isDim() ? 16 : 0));
        bytes[2] = firstByte;
        bytes[3] = secondByte;


        return bytes;
    }



    private static Map<String, Integer> valueMapper;

    static {
        valueMapper = new HashMap<>();
        //House Codes
        valueMapper.put("A", 96);
        valueMapper.put("B", 112);
        valueMapper.put("C", 64);
        valueMapper.put("D", 80);
        valueMapper.put("E", 128);
        valueMapper.put("F", 144);
        valueMapper.put("G", 160);
        valueMapper.put("H", 176);
        valueMapper.put("I", 224);
        valueMapper.put("J", 240);
        valueMapper.put("K", 192);
        valueMapper.put("L", 208);
        valueMapper.put("M", 0);
        valueMapper.put("N", 16);
        valueMapper.put("O", 32);
        valueMapper.put("P", 48);

        //Unit Codes
        valueMapper.put("1", 0);
        valueMapper.put("2", 16);
        valueMapper.put("3", 8);
        valueMapper.put("4", 24);
        valueMapper.put("5", 64);
        valueMapper.put("6", 80);
        valueMapper.put("7", 72);
        valueMapper.put("8", 88);
        valueMapper.put("9", 0);
        valueMapper.put("10", 16);
        valueMapper.put("11", 8);
        valueMapper.put("12", 24);
        valueMapper.put("13", 64);
        valueMapper.put("14", 80);
        valueMapper.put("15", 72);
        valueMapper.put("16", 88);
    }
}
