package OrangePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import MyPackage.Driver;

public class OrangeDashboardPage {

	WebDriver driver;

	public OrangeDashboardPage() {
		this.driver = Driver.driver;
	}

	// ELEMENTS DEFINITION

	By DashboardMenu = By.id("mainMenuFirstLevelUnorderedList");

	// GETTER METHODS FOR ELEMENTS

	public WebElement getDashboardMenu() {
		return driver.findElement(DashboardMenu);
	}
}
