package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;


//Bana neler lazım:  1 browser tipi lazım burada ona göre oluşturucam
// her bir paralel çalışan süreç için sadece o sürece özel static bir değişken lazım
// çünkü runner classdaki işaret edilen tüm senaryolarda aynısını çalışması lazım.
// demekki her pipeline için (Local) ve de ona özel static bir drivera ihtiyacım var
//donanımdaki adı pipeline , yazılımdaki adı Thread , paralel çalışan her bir süreç
public class GWD {
    private static WebDriver driver;
    //bana 1 browser lazim ona gore olusturacam
    //her bir paralell calişinc surec icin sadece o surece ozel static bir degişken lazim
    //cunku runner classindaki işaret edilen tum senariyolarda aynisini çalişmasi lazim
    //hem local hem static bir driver ihtiyacimiz var her pipeline için local ve ona ozel driver lazim
    //donanim adi pipline,yaziimdaki adi Thread,paralell çalişan her bir sureç


    private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();
    public static ThreadLocal<String> threadbrowsername = new ThreadLocal<>();

   //threaddriver get dedigin zaman ilgili Thread deki driver verecek
    //threaddriver set dedigin ilgili driver set edilir
    public static WebDriver getDriver() {
        //extend report turkce bilgi çalişmamasi sebebiyle koyuldu
        Locale.setDefault(new Locale("EN"));
        System.setProperty("user.language", "EN");
        Logger.getLogger("").setLevel(Level.SEVERE);
        System.setProperty(org.slf4j.impl.SimpleLogger.DEFAULT_LOG_LEVEL_KEY, "Error");

        if (threadbrowsername.get()==null)//paralel calişmayan yani exemel parametre gelmeyen cagiramayan
           threadbrowsername.set("chrome");


        if (threadDriver.get() == null) {

            String browsername=threadbrowsername.get();//bu threddeki browsernami verdi
            switch (browsername){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    threadDriver.set(new ChromeDriver()); break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    threadDriver.set(new FirefoxDriver());break;


                case "safari":
                    WebDriverManager.safaridriver().setup();
                    threadDriver.set(new SafariDriver());break;


                case "edge":
                    WebDriverManager.edgedriver().setup();
                    threadDriver.set(new EdgeDriver()); break;


            }

        }

        return threadDriver.get();
    }

    public static void quitDriver() {
       Bekle(5);

        if (threadDriver.get() != null) {//driver varsa quite yap
            threadDriver.get().quit();

            WebDriver driver=threadDriver.get();
           driver= null;
            threadDriver.set(driver);//tekrar gelirse yenilenmiş ve içi boş olsun
        }

    }

    public static void Bekle(int saniye) {
        try {
            Thread.sleep(saniye * 50000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
