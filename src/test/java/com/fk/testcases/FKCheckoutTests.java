package com.fk.testcases;

import java.util.logging.Logger;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fk.page.PageObjectFactory;
import com.fk.page.cart.FKChkoutPage;

public class FKCheckoutTests {

	private static final Logger logger = Logger.getLogger(FKCheckoutTests.class.getName());
	private FKChkoutPage flipkartPage = PageObjectFactory.getFKCartPage();

	@Test(priority = 1)
	public void verifyCheckoutFlow() {
		logger.info("Verifying checkout flow");
		Assert.assertTrue(flipkartPage.verifyCheckoutFlow(), "Checkout flow not working as expected");

	}

}