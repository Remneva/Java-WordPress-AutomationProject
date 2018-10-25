package org.cucumber.rcs.runners;

import com.codeborne.selenide.Configuration;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)

@CucumberOptions(
        plugin = {"html:target/cucumber-report/smoketest", "json:target/cucumber.json"},
        features = "src/test/java/org/cucumber/rcs/test",
        glue = "org/cucumber/rcs/steps",
        tags = "@Test")

public class SmokeTest {
    @BeforeClass
    static public void setupConfig() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        Configuration.browser = "chrome";

    }

}
