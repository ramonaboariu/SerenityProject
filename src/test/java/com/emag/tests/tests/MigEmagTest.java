package com.emag.tests.tests;

import java.util.List;
import java.util.Random;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.emag.steps.EmagSteps;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;

@RunWith(SerenityRunner.class)
public class MigEmagTest {


    @Managed(uniqueSession = true)
    public WebDriver driver;

    WebElement addToCart, search, cartDetails, dynamicElement, dynamicElement2, dynamicElement3;
    Random rand = new Random();
    String searchedProduct = "telefon";

    @Steps
    public EmagSteps emagSteps;

    @Before
    public void maximize(){
        driver.manage().window().maximize();
    }
    @Test
    public void emagSearch() {

        emagSteps.navigateTo("https://emag.ro");
        emagSteps.searchTerm(searchedProduct);


        emagSteps.navigateToRandomResultsPage(searchedProduct);
        emagSteps.getRandomProduct();
        emagSteps.addToCart();
        emagSteps.cartProducts();
    }

        @After
        public void closeChromeTest() {
            driver.quit();
        }

    }



