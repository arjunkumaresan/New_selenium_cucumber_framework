package utilities;

import io.cucumber.java.cs.A;
import io.cucumber.java.cs.Ale;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;

public class Elementutils {

    WebDriver driver;

    public Elementutils(WebDriver driver)
    {
        this.driver = driver;
    }

    public WebElement WaitforElement(WebElement element,long durationInSeconds)
    {
        WebElement webelement = null;
        try
        {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
            return wait.until(ExpectedConditions.elementToBeClickable(element));
        }
        catch(Throwable e)
        {
            e.printStackTrace();
        }
        return webelement;

    }
    public void ClickonElement(WebElement element,long durationInSeconds)
    {
        WebElement webelement = WaitforElement(element,durationInSeconds);
        webelement.click();
    }
    public void TypetextintoElement(WebElement element,String typeintotext,long durationInSeconds)
    {
      WebElement webelement = WaitforElement(element,durationInSeconds);
        webelement.click();
        webelement.clear();
        webelement.sendKeys(typeintotext);
    }
    public void Selectoptiondropdown(WebElement element,String dropdown,long duratuionInSeconds)
    {
        WebElement webelement = WaitforElement(element,duratuionInSeconds);
        Select select = new Select(webelement);
        select.selectByVisibleText(dropdown);
    }
    public Alert WaitforAlert(long durationInSeconds)
    {
        Alert alert = null;

        try
        {
            WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(durationInSeconds));
            alert = wait.until(ExpectedConditions.alertIsPresent());
        }
        catch(Throwable e)
        {
            e.printStackTrace();
        }
        return alert;

    }
    public void alertaccept(long durationInSeconds)
    {
        Alert alert = WaitforAlert(durationInSeconds);
        alert.accept();
    }
    public void alertdismiss(long durationInSeconds)
    {
        Alert alert = WaitforAlert(durationInSeconds);
        alert.dismiss();
    }
    public WebElement waitforVisibilityofelement(WebElement element,long durationInSeconds)
    {
        WebElement webelement = null;

        try
        {
            WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(durationInSeconds));
            webelement = wait.until(ExpectedConditions.visibilityOf(element));
        }
        catch (Throwable e)
        {
            e.printStackTrace();
        }
        return webelement;
    }
    public void mouseclick(WebElement element,long durationInSeconds)
    {
        WebElement webelement = waitforVisibilityofelement(element,durationInSeconds);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().build().perform();

    }
    public void javaScriptclick(WebElement element,long durationInSeconds)
    {
        WebElement webelement = waitforVisibilityofelement(element,durationInSeconds);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",webelement);
    }
    public void textTobeTyped(WebElement element,long durationInSeconds,String typetobeenter)
    {
        WebElement webelement = waitforVisibilityofelement(element,durationInSeconds);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value='"+typetobeenter+"'",webelement);
    }
    public String getTextFromElement(WebElement element,long durationInSeconds)
    {
        WebElement webelement = waitforVisibilityofelement(element,durationInSeconds);
        return webelement.getText();
    }
    public boolean displayStatusofElement(WebElement element,long durationInSeconds)
    {
        WebElement webelement =  waitforVisibilityofelement(element,durationInSeconds);
        return webelement.isDisplayed();
    }
//       try
//       {
//
//           WebElement webelement = waitforVisibilityofelement(element,durationInSeconds);
//           Thread.sleep(3000);
//           webelement.isDisplayed();
//       }
//       catch (Throwable e)
//       {
//           return false;
//       }
//
//    }

}
