package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util.FBConstants;
import BasePage.TestBase;



public class FacebookLogin extends TestBase{

@FindBy (name ="email")
private WebElement username;

@FindBy (name ="pass")
private WebElement pwd;

@FindBy (xpath ="//*[@aria-label='Log In']")
private WebElement LoginButton;


public FacebookLogin(WebDriver driver){
    this.driver = driver;
    PageFactory.initElements(driver, this);
}


public void login(String name,String password){
	username.sendKeys(name);
	pwd.sendKeys(password);
	LoginButton.click();
}


	

}
