package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        tags = "smokeTest",//hangi senaryolarda bu etiket varsa onlar çaliştirilacak
        features = {"src/test/java/FeatureFiles/_01_login.feature",
        "src/test/java/FeatureFiles/_02_country.feature"},
        glue = {"StepDefination"},
        plugin = {"html:target\\cucumber-reports.html"}



)
public class _02_Testrunnersbelirlifeaturelar extends AbstractTestNGCucumberTests {
}
