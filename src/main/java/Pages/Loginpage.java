package Pages;

import org.apache.commons.logging.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Elementutils;

public class Loginpage {
    WebDriver driver;
    private Elementutils utils;

    @FindBy(id = "input-email")
    WebElement Emailfield;

    @FindBy(id = "input-password")
    WebElement password;

    @FindBy(xpath = "//input[@type='submit']")
    WebElement submit;

    @FindBy(xpath = "//div[contains(@class,'alert-dismissible')]")
    WebElement warningmessage;

    public void Enteremail(String Emailtext)
    {
        utils.TypetextintoElement(Emailfield,Emailtext,15);
    }
    public void Enterpassword(String Pwdtext)
    {

        utils.TypetextintoElement(password,Pwdtext,15);
    }
    public Accountpage clickonsubmit()
    {
        utils.ClickonElement(submit,15);
        return new Accountpage(driver);
    }

    public String verifywarningmessage()
    {
        return utils.getTextFromElement(warningmessage,15);

    }

    public Loginpage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        utils = new Elementutils(driver);
    }
}
