package stepsDefinitions;

import Base.BaseTest;
import Pages.ForgottenPassword;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class ForgottenPasswordSteps {

    WebDriver driver;
    ForgottenPassword fp;

    @Given("the user is on the login page")
    public void theUserIsOnTheLoginPage() {
        driver = BaseTest.getDriver();
        driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
        fp = new ForgottenPassword(driver);
    }

    @When("the user clicks the link {string}")
    public void the_user_clicks_the_link_as(String linkText) {
        fp.clickForgottenPassword();
    }

    @And("the user enters an email address as {string}")
    public void the_user_enters_an_email_address_as(String email) {
        fp.enterEmail(email);
    }

    @And("the user clicks on {string}")
    public void the_user_clicks_on_button(String buttonName) {
        fp.clickContinue();
    }

    @Then("a confirmation message should be displayed")
    public void a_confirmation_message_should_be_displayed() {
        String actualMessage = fp.confirmationMsg();
        Assert.assertTrue("Confirmation message not displayed", actualMessage.length() > 0);
        System.out.println("Confirmation message displayed: " + actualMessage);
    }

    @Then("the user should see a warning message {string}")
    public void the_user_should_see_a_warning_message(String expectedMessage) {
        String actualMessage = fp.warningMsg();
        Assert.assertTrue(
            "Warning message did not match! Expected to contain: " + expectedMessage,
            actualMessage.toLowerCase().contains(expectedMessage.toLowerCase())
        );
        System.out.println("Warning message displayed: " + actualMessage);
    }
}