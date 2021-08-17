package OrangeTest;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import MyPackage.Driver;
import OrangePages.OrangeDashboardPage;
import OrangePages.OrangeLoginPage;

@SuppressWarnings("unused")

@Listeners(OrangePages.OrangeListener.class)
public class OrangeHRMLogin extends Driver {
	
	public static Logger log = LogManager.getLogger(OrangeHRMLogin.class);
	
	OrangeLoginPage ol;
	OrangeDashboardPage db;

	@Test
	public void TC1_OrangeLoginPositive() throws InterruptedException {
		
		ol = new OrangeLoginPage();
		db = new OrangeDashboardPage();
		
		ol.getLoginUsername().sendKeys("Admin");
		ol.getLoginPassword().sendKeys("admin123");
		Thread.sleep(2000);
		ol.getLoginButtonClick().click();
		log.info("Loged in successfully");

		Thread.sleep(2000);

		Assert.assertTrue(db.getDashboardMenu().isDisplayed());
		log.info("Test case 01 Executed successfully");

	}

	@Test
	public void TC2_OrangeLoginNegative() throws InterruptedException {

		ol = new OrangeLoginPage();

		ol.getLoginUsername().sendKeys("InvalidUser");
		ol.getLoginPassword().sendKeys("InvalidPassword");
		Thread.sleep(2000);
		ol.getLoginButtonClick().click();

		Thread.sleep(2000);
		Assert.assertTrue(ol.getLoginErrorMsg().getText().equals("Invalid credentials"));
	}
	
	@Test
	public void TC3_OrangeLoginPositiveFail() throws InterruptedException {

		ol = new OrangeLoginPage();
		db = new OrangeDashboardPage();

		ol.getLoginUsername().sendKeys("Invalid");
		ol.getLoginPassword().sendKeys("Invalid");
		Thread.sleep(2000);
		ol.getLoginButtonClick().click();

		Thread.sleep(2000);

		Assert.assertTrue(db.getDashboardMenu().isDisplayed());
		

	}

	@Test
	public void TC4_OrangeLoginNegativeFail() throws InterruptedException {

		ol = new OrangeLoginPage();

		ol.getLoginUsername().sendKeys("Admin");
		ol.getLoginPassword().sendKeys("admin123");
		Thread.sleep(2000);
		ol.getLoginButtonClick().click();

		Thread.sleep(2000);
		Assert.assertTrue(ol.getLoginErrorMsg().getText().equals("Invalid credentials"));
	}

	@BeforeMethod
	public void browserOpen() throws IOException {
		initializeBrowser();
		
	}

	@AfterMethod
	public void browserClose() {
		browserClosedown();
	}

}
