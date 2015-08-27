package com.cloudwick.java.json;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;



public class JsonExample {

	public static void main(String[] args) throws IOException, ParseException {
		// TODO Auto-generated method stub
		
		createJsonData();
		JsonData();

	}

	public static void createJsonData() throws IOException {
	
		
			JSONObject ob = new JSONObject();
			ob.put("id","24");
			ob.put("name", "Fremont");
			
			// JSONArray is same as list in java
			
			JSONArray list = new JSONArray();
			list.add("CA");
			list.add("TX");
			list.add("UT");
		ob.put("states",list);
		
		FileWriter writer = new FileWriter("states.json");
		writer.write(ob.toJSONString());
		writer.flush();
		writer.close();

			
		}
	public static void JsonData() throws IOException, ParseException
	{
		
		
		JSONParser parser = new JSONParser();
		FileReader reader = new FileReader("states.json");
		Object obj = parser.parse(reader);
		
		JSONObject jsonData = (JSONObject) obj;
		
		String id =(String)jsonData.get("id");
		System.out.println("ID: "+id);
		
		String name = (String) jsonData.get("name");
		System.out.println("Name: "+name);
		
		JSONArray states = (JSONArray) jsonData.get("states");
		
		Iterator<String> itr = states.iterator();
		
		while(itr.hasNext())
		{
			
			System.out.println(itr.next());
		}
	}

}
