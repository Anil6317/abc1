package com.coredropship.genericUtility;

public class CallGenericUtility {

	public static void main(String[] args) 
	{
		JavaUtility javautility=new JavaUtility();
		
		int i=(Integer)javautility.StringToAnyDataType("124", "int");
		System.out.println(i);
	}

}
