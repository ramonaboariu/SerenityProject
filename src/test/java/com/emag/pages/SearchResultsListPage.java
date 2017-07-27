package com.emag.pages;

import java.util.List;
import java.util.Random;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultsListPage extends PageObject {

    @FindBy(css = ".emg-fashion-view-dots + a")
    public WebElement pagesNumbers;

    @FindBy(css = ".lazy")
    public List<WebElement> products;





    public void redirectToRandomProductsList(String searchedProduct) {
        waitFor(pagesNumbers);
        int noOfPages = Integer.parseInt(pagesNumbers.getText().trim());
        System.out.println(noOfPages);
        int pageNumber = new Random().nextInt(noOfPages);
        System.out.println(pageNumber);
        getDriver().get("https://emag.ro/search/" + searchedProduct + "/p" + pageNumber);
    }

    public void getRandomProduct() {
        Random rand = new Random();
        int randomNumebrofProducts = rand.nextInt(products.size()) + 1;
        products.get(randomNumebrofProducts).click();
    }



}
