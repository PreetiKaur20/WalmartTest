package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util.FBConstants;
import BasePage.TestBase;

public class WalmartPage extends TestBase {

	@FindBy(xpath = "//*[@id='join-light']/form/div/nav/ul/li[2]/a")
	private WebElement loginlink;

	@FindBy(xpath = "//*[@id='join-light']/form/div/div[1]/input")
	private WebElement username;

	@FindBy(xpath = "//*[@id='join-light']/form/div/div[2]/input")
	private WebElement pwd;

	@FindBy(xpath = "//*[@id='join-light']/form/div/div[3]/button")
	private WebElement LoginButton;

	@FindBy(xpath = "(//*[@class='rvs-star-svg'])[14]")
	private WebElement star;

	@FindBy(xpath = "//*[@id='reviews-section']/modal-dialog/div/div/write-review/div/ng-dropdown/div/span")
	private WebElement opt;

	@FindBy(xpath = "//*[@id='reviews-section']/modal-dialog/div/div/write-review/div/ng-dropdown/div/ul/li[2]")
	private WebElement selectdrop;

	@FindBy(xpath = "//*[@id='reviews-section']/modal-dialog/div/div/write-review/div/div[1]/textarea")
	private WebElement writereview;

	@FindBy(xpath = "//*[@id='reviews-section']/modal-dialog/div/div/write-review/sub-navigation/div/div[2]")
	private WebElement submit;

	public WalmartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void login(String name, String password) {
		loginlink.click();
		username.sendKeys(name);
		pwd.sendKeys(password);
		LoginButton.click();
	}

	public void selectstar() {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("window.scrollBy(0,900)");
		Actions act = new Actions(driver);
		act.moveToElement(star).build().perform();
		star.click();
	}

	public void selectdropdown() {
		opt.click();
		selectdrop.click();
	}

	public void writeReview(String review) throws InterruptedException {
		Thread.sleep(5000);
		writereview.sendKeys(review);

	}

	public void clicksubmit() {
		submit.click();

	}

}
