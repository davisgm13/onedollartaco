package com.onedollartaco.propertiesfiles;

import java.io.FileInputStream; 
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

//hacks
import java.io.FileOutputStream;
import java.io.OutputStream;


public class PropertiesFilesIO {
//public class App {

  public static void main( String[] args ){

	  
	  Properties prophack = new Properties();
		OutputStream output = null;

		try {
	  // hack for finding hte path
		output = new FileOutputStream("config.properties.output");

		// set the properties value
		prophack.setProperty("database", "localhost");
		prophack.setProperty("dbuser", "mkyong");
		prophack.setProperty("dbpassword", "password");

		// save properties to project root folder
		prophack.store(output, null);
		
		} catch (IOException io) {
			io.printStackTrace();
		} 
		
    	Properties prop = new Properties();
    	InputStream input = null;
    	
    	try {
        
    		String filename = "config.properties";
    		// orig sample code: input = PropertiesFilesIO.class.getClassLoader().getResourceAsStream(filename);
    		//  for non-static : prop.load(getClass().getClassLoader().getResourceAsStream("config.properties"));
    		input = new FileInputStream(filename);
    		if(input==null){
    	            System.out.println("Sorry, unable to find " + filename);
    		    return;
    		}

    		//load a properties file from class path, inside static method
    		prop.load(input);
 
                //get the property value and print it out
                System.out.println(prop.getProperty("database"));
    	        System.out.println(prop.getProperty("dbuser"));
    	        System.out.println(prop.getProperty("dbpassword"));
 
    	} catch (IOException ex) {
    		ex.printStackTrace();
        } finally{
        	if(input!=null){
        		try {
				input.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
        	}
        }
 
    }
}
