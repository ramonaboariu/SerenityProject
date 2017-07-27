package com.madison.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

/**
 * Created by ramonaboariu on 7/26/2017.
 */
public class MadisonHomePage extends PageObject {


    @FindBy(css = "ol[class='nav-primary']>li>a")
    public List<WebElement> productsmenu;

    @FindBy(css="ul[class='catblocks']>li>a")
    public List<WebElement>productsubmenu;



    public void navigateTo(String url) {

        getDriver().get(url);
    }

    public int redirectToRandomProductsMenu() {

        Random rand = new Random();
        System.out.println(productsmenu.size());// pt size de lista
        int randomProductsMenu = rand.nextInt(productsmenu.size() - 1);
        System.out.println("The product menu item is " + productsmenu.get(randomProductsMenu).getText());
        productsmenu.get(randomProductsMenu).click();
        return randomProductsMenu;

    }

    public void redirectToRandomProductsSubMenu(int randomProductsMenu) {

        isElementVisible(By.cssSelector("ul.catblocks>li"));

        if(isElementVisible(By.cssSelector("ul.catblocks>li")))
            System.out.println("Exista subcategorii! ");
        else
            System.out.println("Nu exista subcategorii");

if (randomProductsMenu<4) {
    Random rand = new Random();
    System.out.println(productsubmenu.size());// pt size de lista
    int randomProductsSubMenu = rand.nextInt(productsubmenu.size() - 1);
    System.out.println("The product submenu item is " + productsubmenu.get(randomProductsSubMenu).getText());
    productsubmenu.get(randomProductsSubMenu).click();
}
    }


}