package com.deque.tests;

import com.deque.pages.HomePage;
import com.deque.pages.InitiateApplication;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SeleniumTests extends InitiateApplication {

    WebDriver driver;


    @Test(priority = 0)
    public void verifyMainNavCSSSelector(){
        driver = getDriver();
        HomePage homePage = new HomePage(driver);
        homePage.verifyMainNavCSSSelectorIsDisplayed();
    }

    @Test(priority = 1)
    public void verifyRadioButtonsCount(){
        driver = getDriver();
        HomePage homePage = new HomePage(driver);
        homePage.verifyNumberOfRadioButtons(5);
    }

    @Test(priority = 1)
    public void addATraveler(){
        driver = getDriver();
        HomePage homePage = new HomePage(driver);
        homePage.addATraveler();
    }

    @Test(priority = 1)
    public void verifyVideoTextHeader(){
        driver = getDriver();
        HomePage homePage = new HomePage(driver);
        homePage.verifyVideoTextHeader();
    }

}
