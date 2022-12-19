package neoStoxPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import neoStoxUtility.UtilityNew;



public class NeoStoxHomePage 
{
	@FindBy(xpath="(//a[text()='OK'])[2]")private WebElement okButton;
	@FindBy(xpath="(//a[text()='Close'])[5]")private WebElement closeButton;
	@FindBy(id="lbl_username")private WebElement userName;
	@FindBy(id="lbl_curbalancetop")private WebElement acBalance;
	@FindBy(xpath="//span[text()='Logout']")private WebElement logOutButton;
	
	public NeoStoxHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	
	public void handlePOPUP(WebDriver driver) throws InterruptedException
	{
		if(okButton.isDisplayed())
		{
			
		UtilityNew.wait(driver, 1000);
		Thread.sleep(1000);
		okButton.click();
		Reporter.log("Handling PopUp", true);
		Reporter.log("Clicking on ok button of popup", true);
		UtilityNew.wait(driver, 1000);
		
		closeButton.click();
		Reporter.log("Clcking on close button of popoup", true);
		}
		else
		{
			Reporter.log("Threre is no popup", true);
			Thread.sleep(1000);
		}
	}
	
	public String getActualUsername(WebDriver driver)
	{
		UtilityNew.wait(driver, 1000);
		String actaulUserName = userName.getText();
		Reporter.log("Getting Actual Username", true);
		String realUserName=actaulUserName.substring(3);
		Reporter.log("Actual User name is :"+realUserName,true);
		return actaulUserName;
		
	}
	
	public String getAccountBalance(WebDriver driver)
	{
		UtilityNew.wait(driver, 1000);
		String accBalance=acBalance.getText();
		Reporter.log("Getting Account Balance", true);
		Reporter.log("Account Balance is:    "+accBalance,true);
		
		
		
		
		return accBalance;
	}
	
	public void logout(WebDriver driver)
	{
		UtilityNew.wait(driver, 1000);
		userName.click();
		UtilityNew.wait(driver, 1000);
		logOutButton.click();
		Reporter.log("Logging Out", true);
	}

}
