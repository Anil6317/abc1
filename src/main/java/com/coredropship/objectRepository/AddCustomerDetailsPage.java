package com.coredropship.objectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerDetailsPage 
{
	@FindBy(name="firstname")
	private WebElement customerFirstName;
	
	@FindBy(name="lastname")
	private WebElement customerLastName;
	
	@FindBy(name="phonenumber")
	private WebElement customerPhoneNumber;
	
	@FindBy(xpath="(//form[@role='form']/descendant::button[@type='submit'])[1]")
	private WebElement submitButton;
	
	@FindBy(xpath=("//table/tbody//tr[3]/td[1]"))
	private List<WebElement>actualName;
	
	
	public AddCustomerDetailsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	/**
	 * this method is used to enter the 1st name of customer
	 * @param firstName
	 */
	public void customerFirstName(String firstName)
	{
		customerFirstName.sendKeys(firstName);
	}
	/**
	 * this method is used to enter last name of customer
	 * @param lastName
	 */
	public void customerLastName(String lastName)
	{
		customerLastName.sendKeys(lastName);
	}
	/**
	 * this method is used to enter the phone no of customer
	 * @param phoneNumber
	 */
	public void customerPhoneNumber(String phoneNumber)
	{
		customerPhoneNumber.sendKeys(phoneNumber);
	}
	/**
	 * this method is used to save customer details
	 */
	public void saveCustomerDetails()
	{
		submitButton.click();
	}
	/**
	 * this method is used to compare actual and expected name 
	 * @param text
	 */
	public void verifyCustomer(String text)
	{
		for(int i=0;i<actualName.size();i++)
		{
			String data = actualName.get(i).getText();
			System.out.println(data);
			if(text.equals(data))
			{
				System.out.println("pass");
				
			}
	    }
	}
}
