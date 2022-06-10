package com.deque.tests;

import com.deque.axe.AXE;
import com.deque.html.axecore.results.Results;
import com.deque.html.axecore.results.Rule;
import com.deque.html.axecore.selenium.AxeBuilder;
import com.deque.html.axecore.selenium.AxeReporter;
import com.deque.pages.InitiateApplication;
import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.InputStream;
import java.net.URL;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class SeleniumIntegrationWithAxeCore extends InitiateApplication {

    WebDriver driver;
    private static final URL scriptURL = SeleniumIntegrationWithAxeCore.class.getResource("axe.min.js");

    @Test
    public void verifyNumberOfViolationsInDequeUniversityApp(){
        driver = getDriver();
        Results result = new AxeBuilder().analyze(driver);
        List<Rule> violations = result.getViolations();
        if(violations.size() == 0) {
            System.out.println("No Violations Found");
        } else{
            AxeReporter.writeResultsToJsonFile("src/test/java/results/testAccessibility.json", result);
            assertTrue(false, violations+"\nViolations Found : "+violations.size());
        }
    }

    @Test(enabled=false)
    public void dequeUniversityAllyTest(){
        JSONObject responseJSON = new AXE.Builder(driver, scriptURL).analyze();
        JSONArray violations = responseJSON.getJSONArray("violations");

        if(violations.length() == 0){
            System.out.println("No Violations Found");
        }
        else{
            AXE.writeResults("dequeUniversityAllyTest", responseJSON);
            Assert.assertTrue(false, AXE.report(violations));
        }
    }
}