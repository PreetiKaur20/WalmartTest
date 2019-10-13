package Assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import BasePage.TestBase;
import pages.WalmartPage;

public class WalmartReview_Assignment3 {
	static WebDriver driver;

	// public static void main(String[] args) throws InterruptedException {

	@Test
	public void walmart() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\waheyguru\\Desktop\\chromedriver.exe");
		driver = new ChromeDriver();
		WalmartPage wapage = new WalmartPage(driver);
		driver.manage().timeouts().implicitlyWait(220, TimeUnit.SECONDS);
		driver.get("https://wallethub.com/join/light");
		wapage.login("preetikaurtest@gmail.com", "Testing@123");

		driver.get("https://wallethub.com/profile/test-insurance-company-13732055i");

		wapage.selectstar();
		wapage.selectdropdown();

		wapage.writeReview(getAlphaNumericString(320));
		wapage.clicksubmit();

	}

	public void explicitWait(WebElement ele, int Time) {
		WebDriverWait wait = new WebDriverWait(driver, Time);

		wait.until(ExpectedConditions.visibilityOf(ele));
	}

	public  String getAlphaNumericString(int n) {

		// chose a Character random from this String
		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz";

		// create StringBuffer size of AlphaNumericString
		StringBuilder sb = new StringBuilder(n);

		for (int i = 0; i < n; i++) {

			// generate a random number between
			// 0 to AlphaNumericString variable length
			int index = (int) (AlphaNumericString.length() * Math.random());

			// add Character one by one in end of sb
			sb.append(AlphaNumericString.charAt(index));
		}

		return sb.toString();
	}

}
