package Assignments;

import java.io.IOException;
import java.util.Hashtable;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.FacebookHomePage;
import pages.FacebookLogin;
import util.DataUtil;
import util.FBConstants;

import com.relevantcodes.extentreports.LogStatus;

import BasePage.TestBase;

public class FacebookPostTest_Assignment2 extends TestBase {

	@Test(priority = 1)
	public void dologin() {

		openBrowser();
		driver.get(FBConstants.LoginURL);

		FacebookLogin page = new FacebookLogin(driver);
		// Usernmae and Password can change in \src\config\OR.properties file
		// Please user Usrname and password in Property file
		page.login(OR.getProperty("Username"), OR.getProperty("Password"));
		FacebookHomePage homepage = new FacebookHomePage(driver);
		homepage.postStatus("hello world1");

	}

}
