package StepDefination;

import Utilities.Excelutility;
import Utilities.GWD;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Hooks {
    @Before
    public void Before(){
        System.out.println("senario başladi");

    }
    @After
    public void After(Scenario scenario){
        System.out.println("senario bitti");
        System.out.println("scenario sonucu"+scenario.getStatus());
        System.out.println("scenario is failed ?="+scenario.isFailed());

        LocalDateTime date=LocalDateTime.now();
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd.MM.yy");


       Excelutility.writeExcel("src/test/java/ApachePoi/resources/ScenarioStatus.xlsx",scenario,GWD.threadbrowsername.get(), date.format(formatter));




        if (scenario.isFailed()){
            TakesScreenshot screenshot=(TakesScreenshot) GWD.getDriver();
            File ekranDosyasi=screenshot.getScreenshotAs(OutputType.FILE);

            try {
                FileUtils.copyFile(ekranDosyasi,new File(String.format("target/FailedScreenShots/" + scenario.getId() + date.format(formatter)+".png")));
            }catch (IOException e){
                e.printStackTrace();
            }
        }//ekran goruntusu al hata var ise
        GWD.quitDriver();

    }
}
