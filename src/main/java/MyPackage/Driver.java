package MyPackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.apache.commons.io.FileUtils;

@SuppressWarnings("unused")
public class Driver {

	public static WebDriver driver;
	public static Properties props;

	public void initializeBrowser() throws IOException {
		loadProps();
		System.setProperty("webdriver.chrome.driver", props.getProperty("ChromeDriverPath"));
		//driver = new ChromeDriver();
		MutableCapabilities sauceOptions = new MutableCapabilities();

		SafariOptions browserOptions = new SafariOptions();
		browserOptions.setCapability("platformName", "macOS 10.15");
		browserOptions.setCapability("browserVersion", "13.1");
		browserOptions.setCapability("sauce:options", sauceOptions);
		
		driver = new RemoteWebDriver(
			    new URL("https://oauth-charul107-2cee7:c69e5fa4-5fb5-4803-ab7c-ae3df40d34b0@ondemand.eu-central-1.saucelabs.com:443/wd/hub"), browserOptions);
		driver.get(props.getProperty("URL"));
	}

	public void browserClosedown() {
		driver.close();
	}

	public void loadProps() throws IOException {

		props = new Properties();

		FileInputStream fis = new FileInputStream(
				"C:\\Users\\SONY\\eclipse-workspace\\WebAutomation\\src\\main\\resources\\Config.properties");
		props.load(fis);

	}
	
	public void takeScreenshot(String methodName, WebDriver driver) throws IOException {
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		 DateFormat dateFormat = new SimpleDateFormat("MMddyy_hhmm ");
		 Date date = new Date();
		 String date1= dateFormat.format(date);
		
		FileUtils.copyFile(scrFile, new File(props.getProperty("ScreenshotPath")+methodName+"_"+date1+".png"));
	}

}
