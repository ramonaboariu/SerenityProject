package com.madison.steps;

import com.madison.pages.ComparePage;
import com.madison.pages.MadisonHomePage;
import com.madison.pages.ProductsPage;
import com.madison.pages.ProductsViewPage;
import com.madison.utils.Constants;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.steps.ScenarioSteps;
import org.apache.commons.collections.CollectionUtils;
import org.junit.Assert;

import java.util.List;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

/**
 * Created by ramonaboariu on 7/26/2017.
 */
public class MadisonSteps extends ScenarioSteps {

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
        getNameFromProductPage();
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
    public void getNamesFromCompare() {

        System.out.println("lista: "+Constants.listaproduse);
        System.out.println("prodcompare: "+Constants.listaprodcompare);
        Assert.assertTrue(CollectionUtils.isEqualCollection(Constants.listaproduse, Constants.listaprodcompare));

    }

    @Step
    public String  getNameFromProductPage(){
        return productsViewPage.getNameFromProductPage();
    }

    @Step
    public void getNameFromCompare()
    {
        comparePage.addNameFromCompare();
    }
}