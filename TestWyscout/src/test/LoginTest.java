package test;

import org.openqa.selenium.WebDriver;

import PageRepository.WyscoutPlatform;
import helper.BrowserOperation;
import helper.Constants;

public class LoginTest {
    
  WebDriver driver;
	
  
	public static void main (String args[])
	{
	
		
    LoginTest wyscoutTest = new LoginTest();
    wyscoutTest.Perform();
	
	}
	
	
	public void Perform()
	{
	BrowserOperation launcher = new BrowserOperation();
	launcher.LaunchBrowser(Constants.chrome_browser);
	WyscoutPlatform loginPage = new WyscoutPlatform(launcher.getWebDriver());
	System.out.println("********************Starting Test execution********************");
	loginPage.resetPassword();
	loginPage.verifyInvalidUserNameValidPassword();
	loginPage.verifyValidUserNameInvalidPassword();
    loginPage.verifyValidLoginWithForceLogin();
	System.out.println("********************Test execution finished********************");
	launcher.closeDriver();
	}


}