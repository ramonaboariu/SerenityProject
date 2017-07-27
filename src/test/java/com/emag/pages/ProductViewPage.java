package com.emag.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

/**
 * Created by ramonaboariu on 7/26/2017.
 */
public class ProductViewPage extends PageObject {

    @FindBy(css = ".btn.btn-primary.btn-emag.btn-block.yeahIWantThisProduct.gtm_680klw")
    public WebElement addToCart;

    @FindBy(css = ".pad-sep-xs a.btn[href*='add-to-cart-module_go-to-cart_button']")
    public WebElement cartDetails;

    @FindBy(css = ".page-title")
    public WebElement pagetitle;

    @FindBy(css = ".line-item-title.main-product-title")
    public WebElement productname;

    public void addToCart() {
        waitFor(addToCart);
        String title = pagetitle.getText();
        System.out.println(title);
        addToCart.click();
        waitFor(cartDetails);
        cartDetails.click();
        String productTitle = productname.getText();
        Assert.assertEquals(title, productTitle);
    }
}
