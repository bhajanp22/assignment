package com.unicommerce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public interface Locators {
	WebDriver driver = new ChromeDriver();
WebElement login = driver.findElement(By.className("_2zrpKA"));
}
