package com.madison.pages;

import com.madison.utils.Constants;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ramonaboariu on 7/26/2017.
 */
public class ProductsViewPage extends PageObject {

    @FindBy(css = ".add-to-links li:nth-child(2)")
    public WebElement addToCompareButton;

    @FindBy(css = "h1")
    public WebElement name;



    public void clickOnAddToCompare() {

        waitFor(addToCompareButton);
        addToCompareButton.click();


    }


    public void getNameFromProductPage() {

        waitFor(name);
        Constants.productName = name.getText().toLowerCase();
        //Constants.listaproduse.add(Constants.productName);
        getName();
         //return name.getText().toLowerCase();
        //System.out.println("Numele Produsului este:" + name);


    }

    public void getName(){
        Constants.listaproduse.add(Constants.productName);
    }


}
