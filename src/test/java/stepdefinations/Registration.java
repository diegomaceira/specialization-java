package stepdefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class Registration {

    @Given("User on web app")
    public void user_on_web_app() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("user_on_web_app");
    }
    @When("I enter user as {string} and password as {string}")
    public void i_enter_user_as_and_password_as(String string, String string2) throws Throwable{
        // Write code here that turns the phrase above into concrete actions
        System.out.println("i_enter_user_as_and_password_as");
    }
    @When("I submit button login page")
    public void i_submit_button_login_page() throws Throwable{
        // Write code here that turns the phrase above into concrete actions
        System.out.println("i_submit_button_login_page");
    }
    @Then("I redirect to userhome page")
    public void i_redirect_to_userhome_page() throws Throwable{
        // Write code here that turns the phrase above into concrete actions
       System.out.println("i_redirect_to_userhome_page");
    }
}
