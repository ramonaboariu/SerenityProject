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

    @FindBy(css = "h2.product-name a")
    private List<WebElement> nameFromCompare;


    public void addNameFromCompare() {
        System.err.println("SIZE: " +nameFromCompare.size() );
        for (int i = 0; i < nameFromCompare.size(); i++) {

            Constants.listaprodcompare.add(nameFromCompare.get(i).getText().toLowerCase());
            System.out.println("Lista Produse din Compare List" + Constants.listaprodcompare);

        }
    }
}



