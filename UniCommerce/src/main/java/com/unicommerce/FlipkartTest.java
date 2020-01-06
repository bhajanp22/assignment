package com.unicommerce;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

@Test
public class FlipkartTest {

	public void addToCart() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", ".//lib//chromedriver");

//		String path = System.getProperty("user.dir");
//		String driverpath = path + "\\driverfolder\\chromedriver.exe";
//		System.setProperty("webdriver.chrome.driver",driverpath );
//
		
// Initialize browser
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.flipkart.com");
		Actions mouseMove = new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		
		

// Maximize browser

		driver.manage().window().maximize();

		driver.findElement(By.className("_2zrpKA")).sendKeys("8949945432");
		// login.sendKeys("8949945432");
		driver.findElement(By.xpath("//input[@type=\"password\"]")).sendKeys("test@123");
		driver.findElement(By.className("_2zrpKA")).submit();
		assert (driver.findElements(By.className("_2aUbKa")).size() == 1) : "Login should be happened.";
		Thread.sleep(10000);
		//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		// WebElement menshoes = driver.findElement(By.linkText("Hiking & Trekking Shoes
		// for Men"));

		Actions action = new Actions(driver);

		action.moveToElement(driver.findElement(By.xpath("//span[@class='_1QZ6fC _3Lgyp8' and text()='Men']"))).click()
				.build().perform();

		Thread.sleep(5000);

		action.moveToElement(driver.findElement(By.xpath("//a[@title='Sports Shoes']"))).click().build().perform();

		Thread.sleep(5000);

//		WebElement page2 = driver.findElement(By.xpath("//span[contains(text(),'Page')]"));
//		js.executeScript("arguments[0].scrollIntoView();", page2);
//		Thread.sleep(4000);

		driver.findElement(By.xpath("//a[@class='_2Xp0TH'][contains(text(),'2')]")).click();

		Thread.sleep(4000);

		List<WebElement> productList =driver.findElements(By.xpath("//a[@class='_2mylT6']"));
		int size = productList.size();
		productList.get(1).click();
		
	
		
		//driver.findElement(By.xpath("//a[@class='_2mylT6 _3Ockxk'][contains(text(),'Loafers')]")).click();

		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());

		driver.switchTo().window(tabs2.get(1));
		
		driver.findElement(By.xpath("//li[@id='swatch-0-size']")).click();
		;
		Thread.sleep(2000);

		driver.findElement(By.xpath("//button[@class='_2AkmmA _2Npkh4 _2MWPVK']")).click();
		driver.findElements(By.xpath("//a[class='_2mylT6]"));
		Thread.sleep(2000);

		driver.quit();
		// WebElement menshoes = driver.findElement(By.className("_2mylT6"));
		// js.executeScript("arguments[0].scrollIntoView();", menshoes);
		
 
		
	}

}
