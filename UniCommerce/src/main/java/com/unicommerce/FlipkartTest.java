package com.unicommerce;
import java.util.ArrayList;

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

		System.setProperty("webdriver.chrome.driver", "//usr//local//bin//chromedriver");

// Initialize browser
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.flipkart.com");
		Actions mouseMove = new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;

// Maximize browser

		driver.manage().window().maximize();

		driver.findElement(By.className("_2zrpKA")).sendKeys("8949945432");
		driver.findElement(By.xpath("//input[@type=\"password\"]")).sendKeys("test@123");
		driver.findElement(By.className("_2zrpKA")).submit();
		assert (driver.findElements(By.className("_2aUbKa")).size() == 1) : "Login should be happened.";
	Thread.sleep(10000);

	//WebElement menshoes = driver.findElement(By.linkText("Hiking & Trekking Shoes for Men"));

		Actions action = new Actions(driver);

		action.moveToElement(driver.findElement(By.xpath("//span[@class='_1QZ6fC _3Lgyp8' and text()='Men']"))).click().build().perform();

		Thread.sleep(5000);
		

		action.moveToElement(driver.findElement(By.xpath("//a[@title='Sports Shoes']"))).click().build().perform();
		
		Thread.sleep(5000);

		WebElement page2=driver.findElement(By.xpath("//a[@class='_2Xp0TH'][contains(text(),'2')]"));
		js.executeScript("arguments[0].scrollIntoView();", page2);
		
	page2.click();
	
		driver.findElement(By.xpath("//a[@class='_2Xp0TH'][contains(text(),'2')]")).click();
		
		driver.findElement(By.xpath("//a[@class='_2mylT6 _3Ockxk'][contains(text(),'Loafers')]")).click();
		
		
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
		
	    driver.switchTo().window(tabs2.get(1));
		driver.findElement(By.xpath("//button[@class='_2AkmmA _2Npkh4 _2MWPVK']")).click();
				
		
	//	WebElement menshoes = driver.findElement(By.className("_2mylT6"));
	//	js.executeScript("arguments[0].scrollIntoView();", menshoes);
	}

}
