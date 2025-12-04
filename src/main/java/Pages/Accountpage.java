package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Elementutils;

public class Accountpage {
    WebDriver driver;

    private Elementutils utils;

    public Accountpage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        utils = new Elementutils(driver);
    }

    @FindBy(linkText = "Edit your account information")
    WebElement edityouraccountinfo;

    public boolean displaystatusofaccount()

    {
        return utils.displayStatusofElement(edityouraccountinfo,15);
    }
}
