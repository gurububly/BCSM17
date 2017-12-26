package page;

import static org.testng.Assert.fail;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import generic.AL;

public class LoginPage {
	//all these are declarations
@FindBy(id="username")
private WebElement untb;
@FindBy(name="pwd")
private WebElement pwtb;
@FindBy(xpath="//div[.='Login ']")
private WebElement logintb;
@FindBy(xpath="//span[contains(.,'invalid')]")
private WebElement errmsg;
//this is initialisation inside a constructor n this means telling that this is the object of the page
public LoginPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}

public void  setUserName(String un) {
	untb.sendKeys(un);
}
public void setPassword(String pw) {
	pwtb.sendKeys(pw);
}
public void clickLogin() {
	logintb.click();
}
public void verifyErrorMsg(WebDriver driver) {

	WebDriverWait wait=new WebDriverWait(driver,10 );
	try {
		wait.until(ExpectedConditions.visibilityOf(errmsg));
		Reporter.log("Pass:error msg is displayed",true);//this satement is to know if elemment is present then control comes to next line
	} catch (Exception e) {
		Reporter.log("Fail:error msf is not displayed",true);
		Assert.fail();//to tell the testng that make this as fail since testng doesent know which is pass n fail
		
	}
}
}
