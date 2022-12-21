package com.coredropship.objectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryDetails 
{
    @FindBy(xpath="//input[@type='search']")
    private WebElement searchInventory;
    
     @FindBy(xpath="//table/tbody/tr/td[2]")
     private List<WebElement>allProductNames;
    
    public InventoryDetails (WebDriver driver)
    {
    	PageFactory.initElements(driver, this);
    }
    /**
     * this method is used to click on search text area in inventory tab
     * @param text
     */
    public void clickOnInventorySearchBox(String text)
    {
    	searchInventory.click();
    	searchInventory.sendKeys(text);
    }
    /**
     * this method is used to cpmpare inventory search results that we get after entering text in search text box
     * @param name
     */
    public void compareInventorySearchResults(String name)
    {
    	 boolean flag=false;
		   for(int i=0;i<allProductNames.size();i++)
		   {
			  String actualname = allProductNames.get(i).getText();
			
			  if(name.equals(actualname))
			  {
				  System.out.println("test passed" );
				  flag=true;
				  break;
			  }
		   }
		   if(!flag)
			   System.out.println("test case is failed");
    }
    
    
}
