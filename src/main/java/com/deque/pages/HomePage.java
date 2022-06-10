package com.deque.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class HomePage {

    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor javascriptExecutor;

    public HomePage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 60);
        javascriptExecutor = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css="nav#main-nav")
    WebElement mainNavigation;

    @FindBy(xpath="//a[@class='add-traveler']")
    WebElement addTravelerButton;

    @FindBy(xpath="//div[@class='vid-arrows nextvid']//i")
    WebElement videoNextNavigation;

    @FindBy(xpath="//h3[@id='video-text']")
    WebElement videoText;

    @FindBy(xpath="//h3[text()='Let the Adventure Begin!']" +
            "//ancestor::div[@class='interior-container']//input[@type='radio']")
    List<WebElement> radioButtonsList;

    @FindBy(xpath="//div[@class='passenger added-passenger']")
    List<WebElement> passengerList;

    public void verifyMainNavCSSSelectorIsDisplayed(){
        Assert.assertTrue(mainNavigation.isDisplayed(), "main-nav element is not displayed");
        System.out.println("main-nav (CSS selector) has been loaded successfully");
    }

    public void verifyNumberOfRadioButtons(int radioButtonsCount){
        Assert.assertTrue(radioButtonsList.size()==radioButtonsCount, "Number of Radio buttons on \"Let the Adventure Begin\" is not 5");
        System.out.println("Number of Radio buttons on \"Let the Adventure Begin\" is 5");
    }

    public void addATraveler(){
        javascriptExecutor.executeScript("arguments[0].click();", addTravelerButton);
        wait.until(ExpectedConditions.visibilityOfAllElements(passengerList));
        System.out.println("Number of Passenger Added : "+passengerList.size());
    }

    public void verifyVideoTextHeader(){
        javascriptExecutor.executeScript("arguments[0].click();", videoNextNavigation);
        Assert.assertTrue(videoText.getText().equals("Why Mars died"), "Video Text Header is : "+videoText.getText());
        System.out.println("Video Text Header is : "+videoText.getText());
    }
}
