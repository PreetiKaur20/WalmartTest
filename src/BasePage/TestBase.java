package BasePage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Properties;
import java.util.concurrent.TimeUnit;









import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;












import util.FBConstants;
import util.Xls_Reader;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.ExtentTestInterruptedException;
import com.relevantcodes.extentreports.LogStatus;


public class TestBase {

	public static Properties config = null;
	public static Properties OR = null;
	public static WebDriver driver = null;


	@BeforeSuite
	public void initialize() throws IOException {
	
		config = new Properties();
		FileInputStream fp = new FileInputStream(System.getProperty("user.dir")
				+ "\\src\\config\\config.properties");
		config.load(fp);

		// load my xpaths
		OR = new Properties();
		fp = new FileInputStream(System.getProperty("user.dir")
				+ "\\src\\config\\OR.properties");
		OR.load(fp);

	
		System.out.println(config.getProperty("browserType"));

	}


	// changed to Non Static
	public static void  openBrowser() {
		if ((config.getProperty("browserType")).equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver",(System.getProperty("user.dir")+"\\geckodriver.exe"));
		
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(190, TimeUnit.SECONDS); // 120
			driver.manage().timeouts().pageLoadTimeout(190, TimeUnit.SECONDS);
			//driver.get(FBConstants.LoginURL);

		} else {
			/*System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir")	+"\\chromedriver.exe");*/
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(200, TimeUnit.SECONDS);
		//	driver.get(FBConstants.LoginURL);
		
			}
	}
		
		
		@AfterTest
		public void after()
		{
			driver.close();
		}
	

	

	



	


}
