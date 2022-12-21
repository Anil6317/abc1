package com.coredropship.objectRepository;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.coredropship.genericUtility.WebDriverUtility;

public class AddProductPage
{
	@FindBy(name="prodcode") 
	private WebElement productCode;
	
	@FindBy(xpath="//input[@placeholder='Name']")
	private WebElement productName;
	
	@FindBy (xpath="//h5[.='Add Product']/../following::div[@class='form-group']/child::textarea")
	private WebElement desc;
	
	@FindBy(name="quantity")
	private WebElement quantity;
	
	@FindBy(xpath="//input[@placeholder='On Hand']")
	private WebElement productonHand;
	
	@FindBy(name="price")
	private WebElement productprice;
	
	@FindBy(name="category")
	private WebElement productcategory;
	
	@FindBy(name="supplier")
	private WebElement productsupplier;
	
	@FindBy(xpath="//input[@placeholder='Date Stock In']")                                       
	private WebElement dateStockIn2;
	
	@FindBy(xpath="//h5[text()='Add Product']/../../div[2]/form/button[@type='submit']")
	private WebElement save;
	
	@FindBy(xpath="//table/tbody/tr/td[1]")
	private List<WebElement> productIds;
	
	public AddProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	/** 
	 * this method is used to add product code
	 * @param actualID
	 */
	public void  pCode(String actualID)
	{
		productCode.sendKeys(actualID);
	}
	/**
	 * this method is used to enter product name
	 * @param pName
	 */
	public void pName(String pName ) 
	{
		productName.sendKeys(pName);
	}
	/**
	 * this method is used to enter product description
	 * @param description
	 */
	public void pDescription(String description)
    {
		desc.sendKeys(description);
	}
	/**
	 * this method is used to enter product quantity
	 * @param qnt
	 */
	public void pQuant(String qnt)
	{
		quantity.sendKeys(qnt);
	}
	/**
	 * this method is used to enter product that is in hand 
	 * @param onHand
	 */
	public void inHandProd(String onHand)
	{
		productonHand.sendKeys(onHand);
	}
	/**
	 * this method is used to price of  product
	 * @param price
	 */
	public void pPrice(String  price)
	{
		productprice.sendKeys(price);
	}
	/**
	 * this method is used to enter category of product
	 * @param webDriverUtility
	 * @param text
	 */
	public void pCategory(WebDriverUtility webDriverUtility,String text)
	{
		webDriverUtility.selectByVisibleText(productcategory, text);
	}
	/**
	 * this method is used to enter supplier name
	 * @param webDriverUtility
	 * @param text
	 */
	public void pSupplier(WebDriverUtility webDriverUtility,String text)
	{
		webDriverUtility.selectByVisibleText(productsupplier, text);
	}
	/**
	 * this  method is used to describe date of stock in
	 * @param dateOfStockIn
	 * @throws InterruptedException 
	 */
	
	
	public void pDateStock(WebDriverUtility webdriverutility,long timeout,String datevalue) 
	{
		webdriverutility.explicitWait(dateStockIn2, timeout);
		dateStockIn2.click();
		
		dateStockIn2.sendKeys(datevalue);
	}
	/**
	 * this method is used to save all details of product
	 */
	public void saveButton()
	{
		save.click();
	}
	public void compareID(String productcode)
	{
		 boolean flag=false;
		   for(int i=0;i<productIds.size();i++)
		   {
			   String id=productIds.get(i).getText();
			   if(id.equals(productcode))
			   {
				   System.out.println("pass>>>> product created suucessfully");
				   flag=true;
				   break;
			   }
		   }
		   if(!flag) {
			   System.out.println("test case is failed");
		   }
	}
	
	
		
	}
	
	
	


