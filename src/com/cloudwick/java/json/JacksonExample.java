package com.cloudwick.java.json;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class JacksonExample {

	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {

		
		States sta = new States();
		sta.id= "24";
		sta.name= "Fremont";
		sta.states.add("CA");
		sta.states.add("TX");
		sta.states.add("UT");

		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(new File("jackson.json"), sta);
		
		States obj = mapper.readValue(new File("jackson.json"), States.class);
		System.out.println("ID is : "+obj.id);
	}

}
