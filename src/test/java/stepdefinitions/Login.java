package stepdefinitions;


import Pages.Accountpage;
import Pages.Homepage;
import Pages.Loginpage;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.Common_utils;
import utilities.Driverfactory;

import java.util.Date;

public class Login {

    WebDriver driver;
    private Loginpage loginpage;
    private Homepage homepage;

    private Accountpage accountpage;



    @Given("^User navigates to login page$")
    public void user_navigates_to_login_page() throws Throwable {

        driver = Driverfactory.getDriver();
        homepage = new Homepage(driver);
        homepage.clickonmyaccount();
        loginpage = homepage.Loginoption();

    }

    @When("^User enters valid email \"([^\"]*)\"$")
    public void user_enters_valid_email(String emailtext) throws Throwable {


        loginpage.Enteremail(emailtext);
    }

    @When("^User has entered valid password \"([^\"]*)\"$")
    public void user_has_entered_valid_password(String password) throws Throwable {

        loginpage.Enterpassword(password);
    }

    @When("^User click on login button$")
    public void user_click_on_login_button() throws Throwable {

        accountpage = loginpage.clickonsubmit();
    }

    @Then("^User should get successfully logged in$")
    public void user_should_get_successfully_logged_in() throws Throwable {


        Assert.assertTrue(accountpage.displaystatusofaccount());
    }

    @When("^User enters invalid email \"([^\"]*)\"$")
    public void user_enters_invalid_email(String invalid_email) throws Throwable {

        Common_utils utils = new Common_utils();
        loginpage.Enteremail(utils.getemailtimestamp());
    }

    @When("^User has entered invalid password \"([^\"]*)\"$")
    public void user_has_entered_invalid_password(String invalid_password) throws Throwable {

        loginpage.Enterpassword(invalid_password);
    }

    @Then("^User should get proper warning message regarding mismatch$")
    public void user_should_get_proper_warning_message_regarding_mismatch() throws Throwable {


        Assert.assertTrue(loginpage.verifywarningmessage().contains("Warning: No match for E-Mail Address and/or Password."));
    }

    @When("^User don't enter email$")
    public void user_don_t_enter_email() throws Throwable {


        loginpage.Enteremail(" ");
    }

    @When("^User don't enter password$")
    public void user_don_t_enter_password() throws Throwable {


        loginpage.Enterpassword(" ");
    }

}
