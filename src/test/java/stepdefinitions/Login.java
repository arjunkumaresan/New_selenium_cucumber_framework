package stepdefinitions;

import Factory.Driverfactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Date;

public class Login {

    WebDriver driver;

    @Given("^User navigates to login page$")
    public void user_navigates_to_login_page() throws Throwable {

        driver = Driverfactory.getdriver();
        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.linkText("Login")).click();

    }

    @When("^User enters valid email \"([^\"]*)\"$")
    public void user_enters_valid_email(String emailtext) throws Throwable {

        driver.findElement(By.id("input-email")).sendKeys(emailtext);
    }

    @When("^User has entered valid password \"([^\"]*)\"$")
    public void user_has_entered_valid_password(String password) throws Throwable {

        driver.findElement(By.id("input-password")).sendKeys(password);
    }

    @When("^User click on login button$")
    public void user_click_on_login_button() throws Throwable {

        driver.findElement(By.xpath("//input[@type='submit']")).click();
    }

    @Then("^User should get successfully logged in$")
    public void user_should_get_successfully_logged_in() throws Throwable {

        Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
    }

    @When("^User enters invalid email \"([^\"]*)\"$")
    public void user_enters_invalid_email(String invalid_email) throws Throwable {

        driver.findElement(By.id("input-email")).sendKeys(getemailtimestamp());
    }

    @When("^User has entered invalid password \"([^\"]*)\"$")
    public void user_has_entered_invalid_password(String invalid_password) throws Throwable {

        driver.findElement(By.id("input-password")).sendKeys(invalid_password);
    }

    @Then("^User should get proper warning message regarding mismatch$")
    public void user_should_get_proper_warning_message_regarding_mismatch() throws Throwable {

        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).isDisplayed());
    }

    @When("^User don't enter email$")
    public void user_don_t_enter_email() throws Throwable {

        driver.findElement(By.id("input-email")).sendKeys("");
    }

    @When("^User don't enter password$")
    public void user_don_t_enter_password() throws Throwable {

        driver.findElement(By.id("input-password")).sendKeys("");
    }
public String getemailtimestamp()
{
    Date date = new Date();
    return "arjun"+date.toString().replace(" ","_").replace(":","_")+"gmail.com";
}
}
