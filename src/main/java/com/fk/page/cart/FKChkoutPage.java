package com.fk.page.cart;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fk.util.BasePage;
import com.fk.util.TestUtil;

public class FKChkoutPage extends BasePage implements FKChkoutPageConstants {

	TestUtil testUtil = new TestUtil();

	private ChromeDriver driver = getDTChromeDriver();

	@FindBy(xpath = "//a[contains(text(),'Login & Signup')]")
	private WebElement login;

	@FindBy(xpath = "//input[contains(@class,'_2zrpKA _1dBPDZ')]")
	private WebElement inputEmail;

	@FindBy(xpath = "//input[contains(@type,'password')]")
	private WebElement inputPwd;

	@FindBy(xpath = "//button[contains(@class,'_2AkmmA _1LctnI _7UHT_c')]")
	private WebElement submit;

	@FindBy(xpath = "//div[contains(text(),'My Account')]")
	private WebElement myAccount;

	@FindBy(xpath = "//div[@class='_3zdbog _3Ed3Ub']//li/span[contains(text(),'Men')]")
	private WebElement selectMen;

	@FindBy(linkText = "Sports Shoes")
	private WebElement sportsShoes;

	@FindBy(xpath = "//nav[@class='_1ypTlJ']")
	private WebElement navBar;

	@FindBy(xpath = "//nav[@class='_1ypTlJ']/a[2]")
	private WebElement nextPage;

	@FindBy(xpath = "//a[@class='_2mylT6']")
	private List<WebElement> selectShoe;

	@FindBy(xpath = "//li[contains(@id,'size')]/a")
	private List<WebElement> selectSize;

	@FindBy(xpath = "//button[@class='_2AkmmA _2Npkh4 _2MWPVK']")
	private WebElement addToCart;

	public FKChkoutPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean isFKHomePageOpened() {
		driver.get(FKURL);
		if (testUtil.checkElemIsPresentOnPage(login))
			return true;
		return false;

	}

	public boolean verifyCheckoutFlow() {
		isFKHomePageOpened();
		isLoggedIn(USERNAME, PASSWORD);
		selectMensSportsShoes();
		testUtil.customClick(nextPage);
		testUtil.pause(2000);
		testUtil.customClick(selectShoe.get(0));
		testUtil.selectWindow(selectShoe.get(0).getAttribute("title").trim());
		for (int i = 0; i < selectSize.size(); i++) {
			if (selectSize.get(i).getCssValue("border").contains("solid")) {
				selectSize.get(i).click();
				break;
			}
		}
		testUtil.customClick(addToCart);
		testUtil.pause(2000);	
		if (driver.getTitle().contains("Cart"))
			return true;

		return false;
	}

	public void selectMensSportsShoes() {
		if (testUtil.checkElemIsPresentOnPage(selectMen)) {
			testUtil.moveToElement(selectMen);
			testUtil.customClick(sportsShoes);
		}
	}

	public boolean isLoggedIn(String user, String password) {
		if (testUtil.checkElemIsPresentOnPage(inputEmail)) {
			type(inputEmail, user);
			type(inputPwd, password);
			testUtil.customClick(submit);
		}
		if (testUtil.checkElemIsPresentOnPage(myAccount))
			return true;
		return false;
	}

	public void type(WebElement we, String str) {
		we.clear();
		we.sendKeys(str);
	}

}
