package com.fk.page;

import com.fk.page.cart.FKChkoutPage;

public final class PageObjectFactory {

    private static FKChkoutPage flipkartPage = null;


    public static FKChkoutPage getFKCartPage() {
        if (flipkartPage == null)
        	flipkartPage = new FKChkoutPage();
        return flipkartPage;
    }

   
}
