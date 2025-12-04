package stepdefinitions;


import java.util.Map;

import Pages.Accountsuccesspage;
import Pages.Homepage;
import Pages.Registerpage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.Common_utils;
import utilities.Driverfactory;

import java.util.Map;

public class Register {

    WebDriver driver;
    private Registerpage registerpage;
    private Accountsuccesspage acntpage;
    private Common_utils utils;

    @Given("^User navigate to register page$")
    public void user_navigate_to_register_page() throws Throwable {

        driver  = Driverfactory.getDriver();
        Homepage homepage = new Homepage(driver);
        homepage.clickonmyaccount();
        registerpage = homepage.Registeroption();

    }

    @When("^User enters the details into below fields$")
    public void user_enters_the_details_into_below_fields(DataTable dataTable) throws Throwable {

        Map<String, String> datamap = dataTable.asMap(String.class,String.class);
        registerpage.enterfirstname(datamap.get("firstname"));
        registerpage.enterlastname(datamap.get("lastname"));
        registerpage.enteremail(datamap.get("email"));
        registerpage.entertelephone(datamap.get("telephone"));
        registerpage.enterpassword(datamap.get("password"));
        registerpage.enterconfpwd(datamap.get("password"));


    }

    @When("^User selects privacy policy$")
    public void user_selects_privacy_policy() throws Throwable {


        registerpage.selectagree();

    }

    @When("^User clicks on continue button$")
    public void user_clicks_on_continue_button() throws Throwable {


        acntpage = registerpage.selectcontinue();

    }

    @Then("^User account shout get created successfully$")
    public void user_account_shout_get_created_successfully() throws Throwable {


        Assert.assertEquals("Your Account Has Been Created!",acntpage.successmessageverification());

    }

    @When("^User select yes for news letter$")
    public void user_select_yes_for_news_letter() throws Throwable {


        registerpage.checkbox();

    }

    @Then("^User account shout get proper warning message about duplicate email$")
    public void user_account_shout_get_proper_warning_message_about_duplicate_email() throws Throwable {


        Assert.assertTrue(registerpage.warningverification().contains("Warning: E-Mail Address is already registered!"));

    }

    @When("^User don't enter any details into fields$")
    public void user_don_t_enter_any_details_into_fields() throws Throwable {

    }

    @Then("^User should get proper warning message for every mandatory fields$")
    public void user_should_get_proper_warning_message_for_every_mandatory_fields() throws Throwable {

        Assert.assertTrue(registerpage.warningverification().contains("Warning: You must agree to the Privacy Policy!"));
        Assert.assertEquals("First Name must be between 1 and 32 characters!",registerpage.firstnamewarningverification());
        Assert.assertEquals("Last Name must be between 1 and 32 characters!",registerpage.lastnamewarningverification());
        Assert.assertEquals("E-Mail Address does not appear to be valid!",registerpage.emailwarningverification());
        Assert.assertEquals("Telephone must be between 3 and 32 characters!",registerpage.telephonewarningverification());
        Assert.assertEquals("Password must be between 4 and 20 characters!",registerpage.pwdwarningverification());


    }
}
