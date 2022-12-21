package com.coredropship.objectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateProductPage 
{
    @FindBy(xpath="//div[@class='card-header py-3']/h4/a")
    private WebElement addIconButton;
    
    @FindBy(xpath="//table/tbody/tr/td[5]/div/div/a")
    private List<WebElement> editIconWithDotsButton;
    
    @FindBy(xpath="//table/tbody/tr/td[1]")
    private List<WebElement>AllIds;
    
    @FindBy(xpath="//ul[@class='dropdown-menu text-center show']//a[@class='btn btn-warning bg-gradient-warning btn-block']")
    private WebElement editButton;
    

 public CreateProductPage (WebDriver driver)
{
    PageFactory.initElements(driver, this);	
}
 /**
  * this method is used to click on + symbol after clicking on product tab
  */
  public  void clickOnAddIconForProduct()
   {
	  addIconButton .click();
   }
  /**
   * this method is used to click on 3 dots in product list page i.e for editing
   * 
   * @param id
   */
  public void clickOnThreeDotsEditIconForProduct(String id)
  {
	  
	  for(int i=0;i<AllIds.size();i++)
	   {
		  String pid1=AllIds.get(i).getText();
		  if(pid1.equals(id))
		  {
			  editIconWithDotsButton.get(i).click();
			  break;
		  }
	   } 
  }
  /**
   * this method is used to click on edit button for editing
   */
  public void editButtonForProduct()
  {
	  editButton.click();
  }
  

}