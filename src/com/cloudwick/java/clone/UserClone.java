package com.cloudwick.java.clone;

public class UserClone implements Cloneable {

	
	public String name;
	public Object clone()
	{
		
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
