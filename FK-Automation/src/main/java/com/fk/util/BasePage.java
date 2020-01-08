package com.fk.util;

import java.io.File;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BasePage {

	private static ChromeDriver driver;

	@SuppressWarnings("deprecation")
	public ChromeDriver getDTChromeDriver() {
		if (driver == null) {

			if (getOperatingSystem().contains("Windows") || getOperatingSystem().contains("windows")) {
				System.setProperty("webdriver.chrome.driver", new File("").getAbsolutePath() + "/chromedriver.exe");
				DesiredCapabilities capabilities = DesiredCapabilities.chrome();
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--disable-web-security");
				capabilities.setCapability(ChromeOptions.CAPABILITY, options);
				driver = new ChromeDriver(capabilities);

			} else {
				System.setProperty("webdriver.chrome.driver", new File("").getAbsolutePath() + "/chromedriver");
				driver = new ChromeDriver();
			}

			driver.manage().window().maximize();
			return driver;
		}
		return driver;
	}

	public String getOperatingSystem() {
		String osName = System.getProperty("os.name");
		System.out.println(osName);
		return osName;
	}

}
