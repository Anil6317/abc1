package com.coredropship.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCustomerPage 
{
	@FindBy(xpath="//a[@data-target='#customerModal']")
	private WebElement addIconButton;
	
	public CreateCustomerPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	/**
	 * this method is used to click on + button after clicking on customer tab
	 */
	public void clickOnAddIconForCustomer()
	{
		addIconButton.click();
	}

}
