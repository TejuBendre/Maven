package neoStoxTest;



import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
//import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import neoStoxBase.BaseNew;
import neoStoxPOM.NeoStoxHomePage;
import neoStoxPOM.NeoStoxLoginPage;
import neoStoxPOM.NeoStoxPasswordPage;
import neoStoxPOM.NeoStoxSignInPage;
import neoStoxUtility.UtilityNew;

@Listeners(neoStoxBase.Listener.class)
public class ValidateNeoStoxAccBalanceNew extends BaseNew
{
	NeoStoxLoginPage login;
	NeoStoxPasswordPage password;
	NeoStoxHomePage home;
	NeoStoxSignInPage signIn;
	
	@BeforeClass
	public void launchNeoStox() throws InterruptedException, IOException
	{
		launchBrowser(); //from base class
		
		login=new NeoStoxLoginPage(driver);
		password=new NeoStoxPasswordPage(driver);
		home=new NeoStoxHomePage(driver);
		signIn=new NeoStoxSignInPage(driver);
		
	}
	
	@BeforeMethod
	public void logintoNeoStox() throws EncryptedDocumentException, IOException, InterruptedException
	{
		signIn.clickOnSignButton(driver);
		Thread.sleep(1000);
		
		login.sendMobileNumber(driver, UtilityNew.readDataFrompropertyFile("mobileNum"));
		login.clickOnSignInButton(driver);
		UtilityNew.wait(driver, 1000);
		
		password.enterPassword(driver, UtilityNew.readDataFrompropertyFile("password"));
		Thread.sleep(1000);
		password.clickOnSubmitButton(driver);
		Thread.sleep(2000);
		
		home.handlePOPUP(driver);
	}
  @Test
  public void validateAccBalance() throws EncryptedDocumentException, IOException 
  {
	  Assert.assertNotNull(home.getAccountBalance(driver), "TC failed unable to fetch account balance");
	  //Utility.screenShot(driver, "accBalance"); instead of this we use listener to get screenshot in neostoxUtility package
	//  Assert.fail();
  }
  
  @Test(priority = -1)
  public void validateUserID() throws EncryptedDocumentException, IOException 
  {
	  Assert.assertEquals(home.getActualUsername(driver), UtilityNew.readDataFrompropertyFile("userName"),"TC is failed Actual and expected User Name are not matching");
	  
	 // Utility.screenShot(driver, home.getActualUsername(driver));instead of this we use listener to get screenshot
  }
  
  
  @AfterMethod
  public void logOutFromNeoStox()
  {
	  home.logout(driver);
  }
  
  @AfterClass
  public void closeBrowser()
  {
	 // Reporter.log("Closing browser",true);
	  driver.close();
  }
}
