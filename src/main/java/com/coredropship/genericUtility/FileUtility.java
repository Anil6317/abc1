package com.coredropship.genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * this class contains reasonable methods for property file
 * @author Shiva
 *
 */
public class FileUtility 
{
	private FileInputStream fis;
	private Properties property;
	/**
	 * this method is used to fetch data from property file 
	 * @param propertyFilePath
	 * @param key
	 * @return
	 */
	public void openPropertyFile()
	{
	
		try {
			fis=new FileInputStream(IConstantPath.PROPERTY_FILE_PATH);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		property=new Properties();
		try {
			property.load(fis);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public String getDataFromProprtyFile(String key)
	{
		String value=null;
		value = property.getProperty(key).trim();
		return value;
	}
	public void closePropertyFile()
	{
		try {
			fis.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	

}
