package com.cloudwick.java.enumer;

public enum StateEnum {

	CA("1", 98789), TX("2", 45678), UT("7", 76453);

	private StateEnum(String id, int x) {

		stateid=id;
		zip=x;
	}

	private String stateid;
	private int zip;
	public String getStateid() {
		return stateid;
	}
	public int getZip() {
		return zip;
	}
	
	
}
