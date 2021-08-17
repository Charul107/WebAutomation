package OrangePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import MyPackage.Driver;

public class OrangeLoginPage extends Driver{
	
	WebDriver driver;
	
	public OrangeLoginPage() {
		this.driver = Driver.driver;
	}
	
	
	// ELEMENTS DEFINITION

	By LoginUsername 	= By.id("txtUsername");
	By LoginPassword 	= By.id("txtPassword");
	By LoginButtonClick = By.id("btnLogin");
	By LoginErrorMsg 	= By.id("spanMessage");
	
	
	// GETTER METHODS FOR ELEMENTS

	public WebElement getLoginUsername() {
		return driver.findElement(LoginUsername);
	}
	
	public WebElement getLoginPassword() {
		return driver.findElement(LoginPassword);
	}

	public WebElement getLoginButtonClick() {
		return driver.findElement(LoginButtonClick);
	}
	
	public WebElement getLoginErrorMsg() {
		return driver.findElement(LoginErrorMsg);
	}


}
