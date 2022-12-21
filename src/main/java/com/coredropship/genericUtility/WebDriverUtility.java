package com.coredropship.genericUtility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * this class contains common webdriver actions
 * @author Shiva
 *
 */

public class WebDriverUtility 
{
	WebDriver driver;
	/**
	 * this method is used to launch the browser based on key
	 * maximize the browser
	 * provide implicitly wait
	 * launch app by using url
	 * 
	 * @param browser
	 * @param 
	 * @param
	 * @return
	 */
	public WebDriver launchapplication(String browser,long timeout,String url)
	{
		
		if(browser.equals("chrome")) 
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(browser.equals("firefox"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new FirefoxDriver();
		}
		else if(browser.equals("ie"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new InternetExplorerDriver();
		}
		else
		{
			System.out.println("please enter the valid broweser name");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
		driver.get(url);
		return driver;
	}
	public void closeBrowser()
	{
		driver.close();
	}
	/**
	 * to select the values a/c to index
	 * @param element
	 * @param index
	 */
	public void selectbyIndex(WebElement element,int index)
	{
		Select s =new Select(element);
		s.selectByIndex(index);
	}
	/**
	 * to select values a/c to visible text
	 * @param element
	 * @param vtext
	 */
	
	public void selectByVisibleText(WebElement element,String vtext)
	{
		Select s =new Select(element);
		s.selectByVisibleText(vtext);
	}
	/**
	 *to select  values c/c to  values
	 * @param element
	 * @param values
	 */
	public void selectByValues(WebElement element,String value)
	{
		Select s =new Select(element);
		s.selectByVisibleText(value);
	}
	/**
	 * to deselect a/c to index
	 * @param element
	 * @param index
	 */
	public void deselectByIndex(WebElement element,int index)
	{
		Select s =new Select(element);
		s.deselectByIndex(index);	
	}
	/**
	 * to deselect a/c to visible text
	 * @param element
	 * @param vtext
	 */
	public void deselectByVisibleText(WebElement element,String vtext)
	{
		Select s =new Select(element);
		s.deselectByVisibleText(vtext);
	}
	/**
	 * to deselect all values 
	 * @param element
	 */
	public void deslectAll(WebElement element)
	{
		Select s =new Select(element);
		s.deselectAll();
	}
	/**
	 * to accept the alert we use accept
	 * @param driver
	 */
	public void switch_to_alert_accept()
	{
		driver.switchTo().alert().accept(); 
	}
	/**
	 * to dismiss the alert we use dismiss
	 * @param driver
	 */
	public void switch_to_alert_dismiss()
	{
		driver.switchTo().alert();
	}
	/**
	 * this method is used get text of alert pop-up
	 * @return
	 */
	public String switch_to_alert_getText()
	{
		String actualtext = driver.switchTo().alert().getText();
		return actualtext;
	}
	/**
	 * explicit wait condition for presence of element located
	 * @param driver
	 */
	public void waitexpected_condition(long timeout,By element)
	{
		WebDriverWait wait=new WebDriverWait(driver,timeout);
		wait.until(ExpectedConditions.presenceOfElementLocated(element));
	}
	/**
	 * to move to any particular element
	 * @param driver
	 * @param element
	 */
	public void mouseHoverToElement(WebDriver driver,WebElement element)
	{
		Actions a =new Actions(driver);
		a.moveToElement(element).perform();
		
	}
	
	/**
	 * to right click on element
	 * @param driver
	 * @param element
	 */
	public void rightClickOnElement(WebDriver driver,WebElement element)
	{
		Actions a =new Actions(driver);
		a.contextClick(element).perform();;
	}
	/**
	 * to double click on element
	 * @param driver
	 * @param element
	 */
	public void doubleClickOnElememt(WebDriver driver,WebElement element)
	{
		Actions a =new Actions(driver);
		a.doubleClick(element).perform();
	}
	/**
	 * to switch to window based on title
	 * @param driver
	 * @param title
	 */
	public void switchToWindow(WebDriver driver,String title)
	{
		Set<String> allid = driver.getWindowHandles();
		Iterator<String> it = allid.iterator();
		while(it.hasNext())
		{
			String wid = it.next();
			driver.switchTo().window(wid);
			if(driver.getTitle().contains(title))
			{
				break;
			}
		}
	}
	/**
	 * this method is used to move or switch to particular frame by using index
	 * @param driver
	 * @param index
	 */
	public void switchToFrameByIndex(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	/**
	 * this method is used to scroll to bottom of page by using javascript executor 
	 */
	public void scrollToBottomOfPage()
	{
		JavascriptExecutor j=(JavascriptExecutor)driver;
		j.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
	/** 
	 * this method is used to perform mouse action i.e move to a particular element
	 * @param driver
	 * @param element
	 */
	public void moveToElement(WebDriver driver,WebElement element)
	{
		Actions a=new Actions(driver);
		a.moveToElement(element);
		a.perform();
	}
	/**
	 * this method is used to wait till clickable element is present 
	 * @param element
	 * @param timeout
	 */
	public void explicitWait(WebElement element,long timeout)
	{
		WebDriverWait wait=new WebDriverWait(driver,timeout);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	
}
