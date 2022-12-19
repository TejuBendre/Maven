package neoStoxUtility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

public class UtilityNew {

	//Utility class don't have main method this main used only for understanding
	
	/*public static void main(String[] args) throws IOException
	{
		readDataFrompropertyFile("userName");
		readDataFrompropertyFile("password");
		readDataFrompropertyFile("url");
		readDataFrompropertyFile("mobileNum");

	}*/

	public static String readDataFrompropertyFile(String key) throws IOException
	{
		//create object of properties class----->java
		Properties prop=new Properties();
		
		//create object of file inputStream and pass properties file path as parameter
		FileInputStream myFile=new FileInputStream("C:\\Users\\TejVijay\\eclipse-workspace\\Maven_Proj\\NeoStox.properties");
		
		prop.load(myFile);
		
		String value = prop.getProperty(key);
		//System.out.println(value);
		Reporter.log("Reading"+key+"from property file", false);
		return value;
	}
	public static void screenShot(WebDriver driver,String screenShotName) throws IOException
	{
		wait(driver,500);
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest = new File("T:\\Velocity\\Screenshot\\"+screenShotName+".png");
		FileHandler.copy(src, dest);
		Reporter.log("Taking ScreenShot",true);
	}
	
	public static void scrollIntoView(WebDriver driver,WebElement element)
	{
		wait(driver,500);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("argumnets[0].scrollIntoView(true)",element);
		Reporter.log("Scrolling into view", true);
	}
	
	public static void wait(WebDriver driver,int waitTime)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(waitTime));
		Reporter.log("Waiting for"+waitTime+"ms", true);
	}
}
