package com.coredropship.genericUtility;

public class PracticeClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileUtility fileutility = new FileUtility();
		String data = fileutility.getDataFromProprtyFile(PropertyFileKeys.URL.convertToString());
		System.out.println(data);

	}

}
