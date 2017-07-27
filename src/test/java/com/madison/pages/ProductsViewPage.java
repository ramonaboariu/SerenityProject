package com.madison.pages;

import com.madison.utils.Constants;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebElement;

/**
 * Created by ramonaboariu on 7/26/2017.
 */
public class ProductsViewPage extends PageObject {

    @FindBy(css = ".add-to-links li:nth-child(2)")
    public WebElement addToCompareButton;

    @FindBy(css = ".product-shop .product-name .h1")
    public WebElement name;

    public void clickOnAddToCompare() {

        waitFor(addToCompareButton);
        addToCompareButton.click();

    }

    public String  getNameFromProductPage() {

        waitFor(name);
        Constants.productName = name.getText().toLowerCase();
        System.out.println("Numele Produsului este:" + Constants.productName);
        addNameToProductList(Constants.productName);
         return Constants.productName;

    }

    public void addNameToProductList(String productName){
        Constants.listaproduse.add(productName);
        System.out.println( "Lista Produse din Product List " +Constants.listaproduse);

    }


}
