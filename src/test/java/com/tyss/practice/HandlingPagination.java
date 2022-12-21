package com.tyss.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingPagination {

	public static void main(String[] args)
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://demo.opencart.com/admin/index.php");
		driver.manage().window().maximize();
		WebElement usrname = driver.findElement(By.id("input-username"));
		usrname.clear();
		usrname.sendKeys("demo");
		WebElement pwd = driver.findElement(By.id("input-password"));
		pwd.clear();
		pwd.sendKeys("demo");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--disable-notifications");
		driver.findElement(By.xpath("//*[@id=\"menu-sale\"]")).click();
		Alert a=driver.switchTo().alert();
		a.dismiss();

	}

}
