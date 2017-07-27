package com.madison.steps;

import com.madison.pages.ComparePage;
import com.madison.pages.MadisonHomePage;
import com.madison.pages.ProductsPage;
import com.madison.pages.ProductsViewPage;
import com.madison.utils.Constants;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import org.apache.commons.collections.CollectionUtils;
import org.junit.Assert;

import java.util.List;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

/**
 * Created by ramonaboariu on 7/26/2017.
 */
public class MadisonSteps {

    MadisonHomePage madisonHomePage;
    MadisonHomePage madisonHomePageMenu;
    MadisonHomePage madisonHomePageSubMenu;
    ProductsPage productsPage;
    ProductsViewPage productsViewPage;
    ComparePage comparePage;

    @Step
    public void navigateTo(String url) {

        madisonHomePage.navigateTo(url);
    }

    @Step
    public int redirectToRandomProductsPage() {

       return madisonHomePageMenu.redirectToRandomProductsMenu();
    }

    @Step
    public void redirectToRandomProductsSubMenu(int randomProductsMenu) {

        madisonHomePageSubMenu.redirectToRandomProductsSubMenu(randomProductsMenu);
    }

    @Step
    public void getRandomProduct() {
        productsPage.getRandomProduct();

    }

    @Step
    public void clickOnAddToCompare() {
        productsViewPage.clickOnAddToCompare();

    }

    @StepGroup
    public void addProductsToCompareList() {

        redirectToRandomProductsSubMenu(redirectToRandomProductsPage());
        getRandomProduct();
        clickOnAddToCompare();
    }

    @Step
    public void clickBack() {
        getDriver().navigate().back();
    }

    @Step
    public void clickOnCompareButton() {
        productsPage.clickOnCompareButton();
    }

    @Step
    public void getNameFromCompare() {
        //List<String> names = productsViewPage.getAllnames();


        System.out.println(CollectionUtils.isEqualCollection(Constants.listaproduse, nameofProducts));


        //Assert.assertTrue(comparePage.getNameFromCompare().contains(productsViewPage.getNameFromProductPage()));
    }

    @Step
    public void getNameFromProductPage(){
        productsViewPage.getNameFromProductPage();
    }
}