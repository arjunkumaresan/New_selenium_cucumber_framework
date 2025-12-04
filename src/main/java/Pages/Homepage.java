package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Elementutils;


public class Homepage {

    WebDriver driver;

    private Elementutils utils;
    public Homepage(WebDriver driver)
    {

        this.driver = driver;
        PageFactory.initElements(driver,this);
        utils = new Elementutils(driver);
    }

    @FindBy(xpath = "//span[text()='My Account']")
    WebElement myaccountmenu;

    @FindBy(linkText = "Login")
    WebElement loginmenu;

    @FindBy(linkText = "Register")
    WebElement registermenu;

    @FindBy(xpath = "//input[@name='search']")
    WebElement searchvalidproduct;

    @FindBy(xpath = "//button[contains(@class,'btn btn-default')]")
    WebElement clickonsearch;


    public void clickonmyaccount()
    {
        utils.ClickonElement(myaccountmenu,15);

    }

    public Loginpage Loginoption()
    {
        utils.ClickonElement(loginmenu,15);
        return new Loginpage(driver);
    }

    public Registerpage Registeroption()
    {
        utils.ClickonElement(registermenu,15);
        return new Registerpage(driver);
    }

    public void searchvalidproduct(String product)
    {
        searchvalidproduct.sendKeys(product);
        utils.TypetextintoElement(searchvalidproduct,product,15);

    }

    public Searchresultspage searchmenu()
    {
        utils.ClickonElement(clickonsearch,15);
        return new Searchresultspage(driver);

    }

}
