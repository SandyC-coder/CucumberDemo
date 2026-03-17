package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class Search {
	
	WebDriver driver;
	
	// locators

@FindBy(xpath="//input[@placeholder='Search']")
WebElement textbox;

@FindBy(xpath="//button[@class='btn btn-default btn-lg']")
WebElement searchButton;


@FindBy(xpath="//div[@class='caption']//h4")
WebElement product;


@FindBy(xpath="//p[contains(text(),'There is no product that matches the search criteria.')]")
WebElement noProductMatch;


// constructor
public Search(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver,this);
}
//Action methods

public void enterProductName(String productName) {
	textbox.sendKeys(productName);
	
}
public void clickOnSearchButton() {
	searchButton.click();
	
}
public boolean isProductDisplayed () {
	return product.isDisplayed();
}

public String getNoProductMessageText() {
	return noProductMatch.getText();
}

public boolean isNoProductMessageVisible() {
    return noProductMatch.isDisplayed();
}
}
	
	
	


