package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/java/FeatureFiles/_01_login.feature"},//feature larin yolu
        glue = {"StepDefination"}   //stepdefination class larin adi

)
public class _01_Testruners extends AbstractTestNGCucumberTests {







}
