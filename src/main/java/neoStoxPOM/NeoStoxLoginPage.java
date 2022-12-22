package neoStoxPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.testng.Reporter;

import neoStoxUtility.UtilityNew;



public class NeoStoxLoginPage
{
		//declaration

		@FindBy(id="MainContent_signinsignup_txt_mobilenumber")private WebElement mobileNumberField;
		@FindBy(xpath="(//a[text()='Sign In'])[2]")private WebElement signInButton;
		
		//Initialization
		public NeoStoxLoginPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		
		//usage
		
		public void sendMobileNumber(WebDriver driver,String mobNum)
		{
			UtilityNew.wait(driver, 1000);
			mobileNumberField.sendKeys(mobNum);
			//Reporter.log("Entering Mobile Number",true);
		}
		
		public void clickOnSignInButton(WebDriver driver)
		{
			UtilityNew.wait(driver, 1000);
			signInButton.click();
			//Reporter.log("Clicking on SignIn Button", true);
		}

}
