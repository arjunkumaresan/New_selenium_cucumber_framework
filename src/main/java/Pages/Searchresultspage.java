package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Elementutils;

public class Searchresultspage {
    WebDriver driver;
    private Elementutils utils;

    public Searchresultspage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        utils = new Elementutils(driver);
    }

    @FindBy(linkText = "HP LP3065")
    private WebElement validproduct;

    @FindBy(xpath = "//input[@id='button-search']/following-sibling::p")
    private WebElement invalidproduct;

    public boolean validproductverification()
    {
        return utils.displayStatusofElement(validproduct,15);
    }

    public boolean invalidproductverification()
    {
        return utils.displayStatusofElement(invalidproduct,15);
    }
}
