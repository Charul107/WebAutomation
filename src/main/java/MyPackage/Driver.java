package MyPackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.io.FileUtils;

@SuppressWarnings("unused")
public class Driver {

	public static WebDriver driver;
	public static Properties props;

	public void initializeBrowser() throws IOException {
		loadProps();
		System.setProperty("webdriver.chrome.driver", props.getProperty("ChromeDriverPath"));
		driver = new ChromeDriver();
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
