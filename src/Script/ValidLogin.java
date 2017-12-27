package Script;

import org.testng.annotations.Test;

import generic.BaseTest;
import generic.XL;
import page.EnterTimeTrackPage;
import page.LoginPage;

public class ValidLogin extends BaseTest{
@Test(priority=1,groups= {"smoke","login"})
public void testValidLogin() {
	String un=XL.getCellValue(XL_PATH,"ValidLogin", 1, 0);
	String pw=XL.getCellValue(XL_PATH,"ValidLogin" ,1, 1);
	String eTitle=XL.getCellValue(XL_PATH,"ValidLogin", 1, 2);
	
	//enter valid username
	LoginPage l=new LoginPage(driver);
	l.setUserName(un);
	
	//enter valid password
	l.setPassword(pw);
	//click login
	l.clickLogin();
	//check homepage is displayed
	EnterTimeTrackPage e=new EnterTimeTrackPage(driver);
	e.verifyTitle(driver, eTitle);
}
}
