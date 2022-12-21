package com.tyss.practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StaticTable {

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("http://rmgtestingserver:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.xpath("//td[@class='tabUnSelected']/a[text()='Organizations']")).click();
	    String expectedOrg="tcs40";
		List<WebElement>listoforg=driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr/td[3]"));
		for(int i=1;i<listoforg.size();i++)
		{
			String listOfActualOrg=listoforg.get(i).getText();
			System.out.println(listOfActualOrg);
			if(listOfActualOrg.equals(expectedOrg))
			{
				driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr["+(i+2)+"]/td/input")).click();
				break;
			}
			else
				System.out.println("failed");
		}
		
		
		
		

	}

}
