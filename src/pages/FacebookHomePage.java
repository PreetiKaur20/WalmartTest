package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util.FBConstants;
import BasePage.TestBase;



public class FacebookHomePage extends TestBase{

	  public FacebookHomePage(WebDriver driver){
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }
	 


@FindBy(name = "xhpc_message")
WebElement status;

@FindBy (xpath = "//button[contains(.,'Post')]")
WebElement postButton;

public void postStatus(String textStatus){
    status.click();
    status.sendKeys(textStatus);
    postButton.click();
}



	

}
