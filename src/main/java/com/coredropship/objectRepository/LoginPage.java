package com.coredropship.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * POM design pattern>>>>class name should be same as pagename and end with page
 * @author Shiva
 *
 */
public class LoginPage 
{
	@FindBy(name="user")private WebElement userNameTextField;
	@FindBy(name="password")private WebElement passwordTextField;
	@FindBy(name="btnlogin")private WebElement loginButton;
	
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	/**
	 * method to enter username and password and clicking on submit button
	 * @param username
	 * @param password
	 */
public void loginAction(String username,String password)
{
	userNameTextField.sendKeys(username);
	passwordTextField.sendKeys(password);
	loginButton.click();
}
}
