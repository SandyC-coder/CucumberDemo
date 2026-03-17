package Pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	WebDriver driver;
	

@FindBy(xpath="//input[@id='input-email']") 
WebElement email;

@FindBy(xpath="//input[@id='input-password']") 
WebElement password;

@FindBy(xpath="//input[@value='Login']") 
WebElement login;

// New: Locator for the error message
@FindBy(css = ".alert.alert-danger")
WebElement loginErrorMessage;

// constructor
public LoginPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver,this);
}
	// Actions Methods

public void enterEmail(String UserEmail) {
	
	email.sendKeys(UserEmail);
}

public void enterPassword(String pass) {
	password.sendKeys(pass);
}

public void clickLogin() {
	login.click();
}


// New method to get the error message
public String getLoginErrorMessage() {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.visibilityOf(loginErrorMessage));
    return loginErrorMessage.getText();

}
}