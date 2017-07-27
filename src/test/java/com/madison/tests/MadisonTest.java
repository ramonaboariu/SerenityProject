package com.madison.tests;

import com.emag.steps.EmagSteps;
import com.madison.steps.MadisonSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

/**
 * Created by ramonaboariu on 7/26/2017.
 */

@RunWith(SerenityRunner.class)
public class MadisonTest {


    @Managed(uniqueSession = true)
    public WebDriver driver;

    @Steps
    public MadisonSteps madisonSteps;

    @Before
    public void Maximize(){
        driver.manage().window().maximize();
    }


    @Test
    public void madisonHome() {

        madisonSteps.navigateTo("http://qa2.madison.com/");

        madisonSteps.addProductsToCompareList();

        madisonSteps.addProductsToCompareList();

        madisonSteps.clickBack();
        madisonSteps.clickBack();
        madisonSteps.clickOnCompareButton();
        madisonSteps.getNameFromCompare();
        madisonSteps.getNamesFromCompare();

    }

        @After
    public void closeChromeTest() {
        driver.quit();
    }

}
