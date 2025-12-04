package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Elementutils;

public class Accountsuccesspage {
    WebDriver driver;
    private Elementutils utils;
    public Accountsuccesspage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        utils = new Elementutils(driver);
    }

    @FindBy(xpath = "//div[@id='content']/h1")
    private WebElement successmessage;

    public String successmessageverification()
    {
        return utils.getTextFromElement(successmessage,15);
    }
}
