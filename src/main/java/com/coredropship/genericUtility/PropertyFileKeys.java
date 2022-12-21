package com.coredropship.genericUtility;

public enum PropertyFileKeys
{
	BROWSER("browser"),URL("url"),USERNAME("username"),PASSWORD("password"),TIMEOUT("timeout"),RANDOM_NUMBER_LIMIT("randomNumberLimit");
	private String keys;
	//setter
	private PropertyFileKeys(String keys)
	{
		this.keys=keys;
		
	}
	//getter
	public String convertToString()
	{
		return keys.toString();
	}

}


