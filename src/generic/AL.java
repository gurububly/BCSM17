package generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.rewrite.PropertyRewritePolicy;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.sun.jna.platform.win32.OaIdl.DATE;

public class AL {
//this is for taking the Screenshot
public static String getPhoto(WebDriver driver,String folder,String name) {
	TakesScreenshot t=(TakesScreenshot)driver;
	
	File srcfile=t.getScreenshotAs(OutputType.FILE);
	DATE d=new DATE();
	String dt=d.toString();
	String path=folder+name+dt+".png";
	File destfile=new File(path);
	
	try {
		FileUtils.copyFile(srcfile, destfile);
	} catch (Exception e) {
	
	}
return path;
}
//this is for handling propertyfile

public static String getProperty(String path,String key) {
	String v="";
	try {
		Properties p=new Properties();
		p.load(new FileInputStream(path));
		v=p.getProperty(key);
	} catch (Exception e) {
		
	} 
	return v;
}

}
