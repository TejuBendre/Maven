package neoStoxBase;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import neoStoxUtility.UtilityNew;





public class Listener extends BaseNew implements ITestListener
{

	public void onTestFailure(ITestResult result) 
	{
		String tcName = result.getName();
		Reporter.log("Tc " +result.getName()+" Failed please try again...", true);
		try {
			UtilityNew.screenShot(driver, tcName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	public void onTestSuccess(ITestResult result) 
	{
		Reporter.log("TC " +result.getName()+" Success...", true);
	}
	
	
	public void onTestSkipped(ITestResult result) 
	{
		Reporter.log("TC " +result.getName()+" is Skipped please check...", true);
	}
}
