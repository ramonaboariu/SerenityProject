package com.madison.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * Created by ramonaboariu on 7/26/2017.
 */
public class ProductsPage extends PageObject {


    @FindBy(css = "ul.products-grid>li>a")
    public List<WebElement> products;

    @FindBy(css = "button.button[title='Compare']")
    public WebElement compare;


    public void getRandomProduct() {
        int size = products.size();
        Random rand = new Random();
        waitFor(products.get(size - 1));
        System.out.println(products.size());// pt size de lista
        int randomProduct1 = rand.nextInt(size-1);
        System.out.println("The product submenu item is " + products.get(randomProduct1).getText());
        products.get(randomProduct1).click();

    }

    public void clickOnCompareButton() {

        waitFor(compare);
        compare.click();
        String initial = switchToNewestOpenedTab();
        getDriver().switchTo().window(initial);

    }

    public String switchToNewestOpenedTab() {
        final Set<String> winSet = getDriver().getWindowHandles();
        final List<String> winList = new ArrayList<String>(winSet);
        Assert.assertTrue("There is only one tab!", winList.size() > 1);
        final String previousTab = winList.get(winList.size() - 2);
        final String newTab = winList.get(winList.size() - 1);
        getDriver().switchTo().window(newTab);
        getDriver().manage().window().maximize();
        return previousTab;
    }

}
