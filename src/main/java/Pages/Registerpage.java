package Pages;

import io.cucumber.java.an.E;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Elementutils;

import java.nio.file.WatchEvent;

public class Registerpage {
    WebDriver driver;
    private Elementutils utils;

    public Registerpage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        utils = new Elementutils(driver);
    }

    @FindBy(id = "input-firstname")
    private WebElement firstnamefield;

    @FindBy(id = "input-lastname")
    private WebElement lastnamefield;

    @FindBy(id = "input-email")
    private WebElement emailfield;

    @FindBy(id = "input-telephone")
    private WebElement telephonefield;

    @FindBy(id = "input-password")
    private WebElement passwordfield;

    @FindBy(id = "input-confirm")
    private  WebElement confirmfield;

    @FindBy(name = "agree")
    private WebElement agree;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement continuebutton;

    @FindBy(xpath = "//input[@name='newsletter'][@value='1']")
    private WebElement yesbcheckbox;

    @FindBy(xpath = "//div[contains(@class,'alert-dismissible')]")
    private WebElement warningmessage;

    @FindBy(xpath = "//input[@id='input-firstname']/following-sibling::div")
    private WebElement firstnamewarning;

    @FindBy(xpath = "//input[@id='input-lastname']/following-sibling::div")
    private WebElement lastnamewarning;

    @FindBy(xpath = "//input[@id='input-email']/following-sibling::div")
    private WebElement emailwarning;

    @FindBy(xpath = "//input[@id='input-telephone']/following-sibling::div")
    private WebElement telephonewarning;

    @FindBy(xpath = "//input[@id='input-password']/following-sibling::div")
    private WebElement pwdwarning;


    public void enterfirstname(String firstname)
    {
        utils.textTobeTyped(firstnamefield,15,firstname);
    }
    public void enterlastname(String lastname)
    {
        utils.textTobeTyped(lastnamefield,15,lastname);
    }
    public void enteremail(String email)
    {
        utils.textTobeTyped(emailfield,15,email);

    }
    public void entertelephone(String phone)
    {
        utils.textTobeTyped(telephonefield,15,phone);

    }
    public void enterpassword(String pwd)
    {
        utils.textTobeTyped(passwordfield,15,pwd);
    }
    public void enterconfpwd(String pwdcon)
    {
        utils.textTobeTyped(confirmfield,15,pwdcon);

    }

    public void selectagree()
    {
        utils.ClickonElement(agree,15);
    }
    public Accountsuccesspage selectcontinue()
    {
        utils.ClickonElement(continuebutton,15);
        return new Accountsuccesspage(driver);
    }

    public void checkbox()
    {
        utils.ClickonElement(yesbcheckbox,15);
    }

    public String warningverification()
    {
        return utils.getTextFromElement(warningmessage,15);
    }

    public String firstnamewarningverification()
    {
        return utils.getTextFromElement(firstnamewarning,15);
    }
    public String lastnamewarningverification()
    {
        return utils.getTextFromElement(lastnamewarning,15);
    }
    public String emailwarningverification()
    {
        return utils.getTextFromElement(emailwarning,15);
    }
    public String telephonewarningverification()
    {
        return utils.getTextFromElement(telephonewarning,15);
    }
    public String pwdwarningverification()
    {
        return utils.getTextFromElement(pwdwarning,15);
    }
}
