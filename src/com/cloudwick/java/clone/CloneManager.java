package com.cloudwick.java.clone;

public class CloneManager {

	public static void main(String[] args) {

		UserClone userobj = new UserClone();
		userobj.name="MohanaKrishna";
		
		System.out.println(userobj.name);
		
		UserClone userobj2=	(UserClone) userobj.clone();
		
		System.out.println(userobj2.name);


	}

}
