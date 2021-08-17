package OrangePages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import MyPackage.Driver;

@SuppressWarnings("unused")
public class OrangeListener extends Driver implements ITestListener{
	
	public void onFinish(ITestContext arg0) {			
        		
    }		

    public void onStart(ITestContext arg0) {				
        		
    }		

    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {			
        		
    }		

    public void onTestFailure(ITestResult result) {
    	
    	try {
           // ITestContext context = result.getTestContext();
          // WebDriver driver = (WebDriver)context.getAttribute("driver");
    		 Driver b = new Driver();
    		
    		
			b.takeScreenshot(result.getName().toString().trim(),driver);
		} catch (IOException e) {
			e.printStackTrace();
		}
       			
        		
    }		

    public void onTestSkipped(ITestResult arg0) {			
        		
    }		

    public void onTestStart(ITestResult arg0) {				
        		
    }		

    public void onTestSuccess(ITestResult arg0) {				
        		
    }	

}
