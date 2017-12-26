package page;

import javax.xml.ws.WebEndpoint;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import junit.framework.AssertionFailedError;
import net.bytebuddy.asm.Advice.Enter;

public class EnterTimeTrackPage {
@FindBy(xpath="//div[contains(.,'Help')]")
private WebElement help;
@FindBy(linkText="About your actiTIME")
private WebElement aboutActiTIME;
@FindBy(xpath="//span[starts_with(.,'actiTIME ')]")
private WebElement version;
@FindBy(id="aboutPopupCloseButtonId")
private WebElement closebtn;
@FindBy(id="Logout")
private WebElement logout;

public EnterTimeTrackPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}

public void verifyTitle(WebDriver driver,String eTitle) {
	WebDriverWait wait=new WebDriverWait(driver, 10);
	try {
		wait.until(ExpectedConditions.titleIs(eTitle));
		Reporter.log("Pass:home page is displayed",true);
	} catch (Exception e) {
		Reporter.log("Fail:home page is not displyaed",true);
		Assert.fail();
		
	}
}

public void clickHelp() {
	help.click();
}
public void clickAboutActiTIME() {
	aboutActiTIME.click();
}
public void verifyVersion(String Eversion) {
	String Aversion=version.getText();
	Assert.assertEquals(Aversion, Eversion);//here we are not using the explicit wait n try n catch block because assert is alternative for if...else statement
	//her we can check by if ..else conditon ..inorder to eliminate this we use assert
	}
public void clickButton() {
	closebtn.click();
}
public void clickLogout() {
	logout.click();
}
}
