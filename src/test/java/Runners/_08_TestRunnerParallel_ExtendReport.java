package Runners;


import Utilities.GWD;
import com.aventstack.extentreports.service.ExtentService;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.*;

@CucumberOptions(
        tags = "@smokeTest",
        features = {"src/test/java/FeatureFiles/_01_login.feature",
        "src/test/java/FeatureFiles/_02_country.feature"
        },
        glue = {"StepDefinitions"}
)
public class _08_TestRunnerParallel_ExtendReport extends AbstractTestNGCucumberTests {

  @BeforeClass(alwaysRun = true) // bazı java versiyon hatalırı için
  @Parameters("browser")

  public void beforeClass(String browser)
  {
    GWD.threadbrowsername.set(browser);
    //burada browser set edilecek
    // bu threade browsername set edildi.
  }
}
