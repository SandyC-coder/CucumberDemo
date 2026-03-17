package stepsDefinitions;

import Pages.LoginPage;
import Base.BaseTest;
import io.cucumber.java.en.*;
import junit.framework.Assert;

public class Steps {

    LoginPage login;

    @Given("user is on login page")
    public void user_is_on_login_page() {
        login = new LoginPage(BaseTest.driver);
    }

    @When("user enters user email as {string} and password {string}")
    public void user_enter_user_email_as_and_password(String email, String password) {
        login.enterEmail(email);
        login.enterPassword(password);
    }

    @When("clicks login button")
    public void clicks_login_button() {
        login.clickLogin();
    }

    @Then("user should see home page")
    public void user_should_see_home_page() {
        String actualTitle = BaseTest.driver.getTitle();
        System.out.println("Current URL: " + BaseTest.driver.getCurrentUrl());
        System.out.println("Page Title: " + actualTitle);

        // Positive login assertion
        Assert.assertEquals("User is not on home page!", "My Account", actualTitle);
    }

    @Then("user should see an error message")
    public void user_should_see_an_error_message() {
        String errorText = login.getLoginErrorMessage();
        System.out.println("Login error text: " + errorText);

        // Negative login assertion
        Assert.assertTrue("Expected login error not found",
                errorText.contains("Warning: No match for E-Mail Address and/or Password."));
    }
}