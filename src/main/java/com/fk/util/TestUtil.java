package com.fk.util;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class TestUtil extends BasePage {

	private static final Logger logger = Logger.getLogger(TestUtil.class.getName());

	private ChromeDriver driver = getDTChromeDriver();

	public void customClick(WebElement we) {
		if (checkElemIsPresentOnPage(we)) {
			we.click();
		}

	}

	public void waitUntilPageLoads() {
		logger.info("Page Opened " + driver.getCurrentUrl());
		@SuppressWarnings("deprecation")
		FluentWait<WebDriver> fWait = new FluentWait<WebDriver>(driver).withTimeout(200, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.MILLISECONDS).ignoring(NoSuchElementException.class);

		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver sharedDriver) {
				return ((JavascriptExecutor) sharedDriver).executeScript("return document.readyState").toString()
						.equals("complete");
			}
		};

		fWait.until(expectation);
	}

	public void selectWindow(String data) {
		try {
			if (!(data.equals("null"))) {
				for (String winHandle : driver.getWindowHandles()) {
					driver.switchTo().window(winHandle);
					logger.info("Window title " + driver.getTitle());
					if (driver.getTitle().contains(data)) {
						break;
					}
				}
			}
			if (data.equals("null")) {
				Set<String> str1 = driver.getWindowHandles();
				Iterator<String> it = str1.iterator();
				while (it.hasNext()) {
					String child = it.next();
					driver.switchTo().window(child);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void moveToElement(WebElement we) {
		Actions actions = new Actions(driver);
		actions.moveToElement(we);
		actions.perform();
	}

	@SuppressWarnings("deprecation")
	public boolean checkElemIsPresentOnPage(WebElement elementName) {
		try {
			FluentWait<WebDriver> fWait = new FluentWait<WebDriver>(driver).withTimeout(120, TimeUnit.SECONDS)
					.pollingEvery(5, TimeUnit.MILLISECONDS).ignoring(NoSuchElementException.class);
			fWait.until(ExpectedConditions.visibilityOf(elementName));
			if (elementName.isDisplayed() && elementName.isEnabled()) {
				return true;
			}
		} catch (Exception e) {
			logger.info("Element not found ");
		}
		return false;
	}

	public void pause(int i) {
		try {
			Thread.sleep(i);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
