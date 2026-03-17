package Pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.TimeoutException;

public class ForgottenPassword {

    WebDriver driver;

    public ForgottenPassword(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[contains(@class, 'form-group')]//a[normalize-space()='Forgotten Password']")
    private WebElement forgottenPasswordLink;

    @FindBy(xpath="//input[@id='input-email']")
    private WebElement emailField;

    @FindBy(xpath="//input[@value='Continue']")
    private WebElement continueButton;

    @FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
    private WebElement warning;

    @FindBy(css = ".alert.alert-success")
    private WebElement confirmation;

    // Action Methods
    public void clickForgottenPassword() {
        forgottenPasswordLink.click();
    }

    public void enterEmail(String email) {
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void clickContinue() {
        continueButton.click();
    }

    public String warningMsg() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.visibilityOf(warning));
            return warning.getText();
        } catch (TimeoutException e) {
            return "";
        }
    }

    public String confirmationMsg() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.visibilityOf(confirmation));
            return confirmation.getText();
        } catch (TimeoutException e) {
            return "";
        }
    }
}