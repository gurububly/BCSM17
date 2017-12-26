package generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest implements IAutoConst {
	public WebDriver driver;
static {
	System.setProperty(CHROME_KEY,CHROME_VALUE );
	System.setProperty(GECKO_KEY, GECKO_VALUE);
}
@Parameters({"browser"})
@BeforeMethod(alwaysRun=true)
public void openApp(String browser) {

if(browser.equals("chrome")) {
	driver=new ChromeDriver();
}else {
	driver=new FirefoxDriver();
}	

}







}
