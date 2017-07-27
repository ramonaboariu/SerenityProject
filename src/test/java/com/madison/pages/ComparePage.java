package com.madison.pages;

import com.madison.utils.Constants;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.*;

/**
 * Created by ramonaboariu on 7/26/2017.
 */
public class ComparePage extends PageObject {

    @FindBy(css = "h2")
    public List<WebElement> nameFromCompare;


    public List<String> getNameFromCompare() {
        List<String> nameOfProducts = new ArrayList<>();


        for (int i = 0; i < nameFromCompare.size(); i++) {

            nameOfProducts.add(nameFromCompare.get(i).getText().toLowerCase());

        }

        System.out.println( "Sirul din compare:" +nameOfProducts);

return nameOfProducts;

    }
}