package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GWDbasic {
    private static WebDriver driver;


    public static WebDriver getDriver(){



        if (driver==null){
            //extend report turkce bilgi çalişmamasi sebebiyle koyuldu
            Locale.setDefault( new Locale("EN"));
            System.setProperty("user.language","EN");

            Logger.getLogger("").setLevel(Level.SEVERE);
            System.setProperty(org.slf4j.impl.SimpleLogger.DEFAULT_LOG_LEVEL_KEY, "Error");
            System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");

            WebDriverManager.chromedriver().setup();
            driver=new ChromeDriver();

            // WebDriverManager.firefoxdriver().setup();
            //  driver=new FirefoxDriver();

        }

        return driver;
    }
    public static void quitDriver(){
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

        if (driver!=null){//driver varsa quite yap
            driver.quit();
            driver=null;
        }

    }
    public static void Bekle(int saniye)
    {
        try {
            Thread.sleep(saniye*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }




}
