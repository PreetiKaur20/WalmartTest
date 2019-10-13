package Assignments;

import org.testng.annotations.Test;

import BasePage.TestBase;
import pages.FacebookHomePage;
import pages.FacebookLogin;
import util.FBConstants;

public class FacebookLoginTest_Assignment1 extends TestBase {

	@Test(priority = 1)
	public void dologin() {

		openBrowser();
		driver.get(FBConstants.LoginURL);

		FacebookLogin page = new FacebookLogin(driver);

		page.login(OR.getProperty("Username"), OR.getProperty("Password"));
		FacebookHomePage homepage = new FacebookHomePage(driver);

	}

}
