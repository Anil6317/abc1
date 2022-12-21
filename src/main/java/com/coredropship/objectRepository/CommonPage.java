package com.coredropship.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CommonPage 
{
@FindBy(xpath="//span[text()='Product']")
private WebElement productTab;

@FindBy(xpath="//span[text()='Customer']")
private WebElement customerTab;

@FindBy(xpath="//span[text()='Inventory']")
private WebElement inventoryTab;

public CommonPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}
/**
 * this method is used to click on product tab in home page
 */
public void clickProduct()
{
	productTab.click();
}
/**
 * this method is used to click on customer tab in home page
 */
public void clickCustomer()
{
	customerTab.click();
}
/**
 * this method is used to click on inventory tab in home  page
 */
public void clickInventory()
{
	inventoryTab.click();
}
}
