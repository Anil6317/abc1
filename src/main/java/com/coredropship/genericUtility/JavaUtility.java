
package com.coredropship.genericUtility;

import java.util.Random;

public class JavaUtility 
{
	/**
	 * this method is used to convert string to long datatype
	 * @param s
	 * @param Strategy
	 * @return
	 */
	public Object StringToAnyDataType(String s,String Strategy)
	{
		Object convertedData=null;
		if(Strategy.equals("int"))
		{
			convertedData=Integer.parseInt(s);
		}
		else if(Strategy.equals("long"))
		{
			convertedData=Long.parseLong(s);
		}
		return convertedData;
	}
	/**
	 * this method is used to generate random number
	 * @param limit
	 * @return
	 */
	public int getRandomnumber(int limit)
	{
		int randomNumber=new Random().nextInt(limit);
		return randomNumber;
	}

}
