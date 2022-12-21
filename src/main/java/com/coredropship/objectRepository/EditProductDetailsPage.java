package com.coredropship.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.coredropship.genericUtility.WebDriverUtility;

public class EditProductDetailsPage
{
   @FindBy(name="prodname")
   private WebElement productName;
   
   @FindBy(name="category")
   private WebElement productCategory;
   
   @FindBy(xpath="//button[@class='btn btn-warning btn-block']")
   private WebElement updateButton;
   
   public EditProductDetailsPage(WebDriver driver)
   {
	   PageFactory.initElements(driver, this);
   }
   /**
    * this is used for entering product name in edit details page
    * @param text
    */
   public void updateProductName(String text)
   {
	   productName.clear();
	   productName.sendKeys(text);
   }
   /**
    * this is used for updating category of product
    * @param webdriverutility
    * @param text
    */
   public void updateProductCategory(WebDriverUtility webdriverutility,String text)
   {
	   webdriverutility.selectByVisibleText(productCategory, text);
   }
   /**
    * this is used for clicking on update button
    */
   public void clickOnUpdate()
   {
	   updateButton.click(); 
   }
   /**
    * this method is ysed to compare actual text that we get after updating and getting text from alert pop-up
    * @param webdriverutility
    * @param text
    */
   public void verifyText(WebDriverUtility webdriverutility,String text) {
	  String actualtext= webdriverutility.switch_to_alert_getText();
	  
	  if(actualtext.contains(text))
	  {
		  System.out.println("test case passed >>>>>>");
	  }
	  
	  
	   
   }
   

	
}
   

