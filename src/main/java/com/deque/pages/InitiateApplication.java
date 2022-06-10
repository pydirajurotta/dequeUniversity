package com.deque.pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class InitiateApplication {

    public WebDriver driver;

    public static ThreadLocal<WebDriver> threadLocal = new ThreadLocal<WebDriver>();

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-notifications");
        driver = new ChromeDriver(chromeOptions);
        threadLocal.set(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://dequeuniversity.com/demo/mars");
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }


    public WebDriver getDriver(){
        return threadLocal.get();
    }

}
