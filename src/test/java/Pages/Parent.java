package Pages;

import Utilities.GWD;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Parent {
    public void sendKeysFunction(WebElement element, String value) {

        WaitUntilVisible(element);
        ScrollToElement(element);
        element.clear();
        element.sendKeys(value);
    }

    public void WaitUntilVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(120));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public void WaitUntilClickable(WebElement element){
        WebDriverWait wait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(120));
        wait.until(ExpectedConditions.elementToBeClickable(element));

    }

    public void ScrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) GWD.getDriver();
        js.executeScript("arguments[0].scrollIntoView();", element);

    }
   public void clickFunction(WebElement element) {
       WaitUntilClickable(element);
    ScrollToElement(element);

    element.click();

    }
    public void verifyContainsText(WebElement element,String text){
        WaitUntilVisible(element);
        Assert.assertTrue(element.getText().toLowerCase().contains(text.toLowerCase()));

    }
    public void waitUntilLoading() {
        WebDriverWait wait=new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(120));
        wait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector("fuse-progress-bar > *"), 0));
    }

}
