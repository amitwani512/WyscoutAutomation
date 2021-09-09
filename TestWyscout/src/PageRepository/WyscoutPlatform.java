package PageRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import helper.BrowserOperation;
import helper.Constants;

public class WyscoutPlatform 
{
	WebDriver driver;
    WebDriverWait wait;
    
    
	By username =By.xpath(Constants.userNamePath);
	By password = By.id(Constants.passwordID);
	By loginbutton = By.id(Constants.loginBtnId);


	
	public  WyscoutPlatform(WebDriver driver)
	{
			this.driver=driver;
			wait = new WebDriverWait(driver, 30); 
	}
	
	public void typeUserName()
	{
	   wait.until(ExpectedConditions.visibilityOfElementLocated(username));
		driver.findElement(username).sendKeys(Constants.validUserName);
	//	driver.findElement(By.xpath("//*[@class='new-login-link']")).click();
		
		
	}
	
	public void typePassword()
	{
		driver.findElement(password).sendKeys(Constants.validPassword);
	}
	
	public void clickLogin()
	{
		
		driver.findElement(loginbutton).click();
		testMultipleaccessPage();
		
	}
	public void verifyValidLoginWithForceLogin () {
		typeUserName();
	    typePassword();
	    clickLogin();
	}
	
	
	
	public void validUserNameInvalidPassword()
	{
		 wait.until(ExpectedConditions.visibilityOfElementLocated(username));
		driver.findElement(username).sendKeys(Constants.validUserName);
		driver.findElement(password).sendKeys(Constants.invalidPassword);
		driver.findElement(loginbutton).click();
	}
	
	public void verifyLandingPage()
	{
		try
		{
			
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Constants.actualAccountNamePath)));
		WebElement accountName = driver.findElement(By.xpath(Constants.actualAccountNamePath));
		System.out.println("Login succesful : Test Passed");
		if(Constants.excpectedAccountName.equals(accountName.getText()))
		
		
		{
			System.out.println("Valid user "+Constants.excpectedAccountName + " : Test Passed");	
			   
	    }
		else
		{
			System.out.println("Logged in user is invalid : Test Failed");
		}
		}
	catch(NoSuchElementException e)
	{
		System.out.println("Landing Page not found login failed : Test Failed");
	}
		
		
}
	
		
	
	public void testMultipleaccessPage() 
	{
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Constants.forceLoginBtnPath)));
			   driver.findElement(By.xpath(Constants.forceLoginBtnPath)).click();
			   verifyLandingPage();
			   System.out.println("Force login Successful.");
		    
		}catch(NoSuchElementException e) {
			verifyLandingPage();
		}
		

	}



	public void incorrectCredentials()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Constants.incorrectPasswordPopUp)));
		if(driver.findElement(By.xpath(Constants.incorrectPasswordPopUp)).isDisplayed())
		{
	
		System.out.println("Invalid Credentials Pop-up displayed : Test Passed");
		}
		else
		{
			System.out.println("Invalid Credentials Pop-up not displayed : Test Failed");
		}
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[9]/div[2]/div[3]/div/a")));
		driver.findElement(By.xpath("/html/body/div[9]/div[2]/div[3]/div/a")).click();
		driver.findElement(username).clear();
		driver.findElement(password).clear();
	}
		

	public void verifyValidUserNameInvalidPassword() 
	{
			wait.until(ExpectedConditions.visibilityOfElementLocated(username));
			driver.findElement(username).sendKeys(Constants.validUserName);
			driver.findElement(password).sendKeys(Constants.invalidPassword);
			driver.findElement(loginbutton).click();
			incorrectCredentials();

	}

	public void verifyInvalidUserNameValidPassword() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(username));
		driver.findElement(username).sendKeys(Constants.invalidUserName);
		driver.findElement(password).sendKeys(Constants.validPassword);
		driver.findElement(loginbutton).click();
		incorrectCredentials();
		
	}
	
	
	public void resetPassword()
	    {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Constants.lostYourPasswordPath)));
		driver.findElement(By.xpath(Constants.lostYourPasswordPath)).click();
		
	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password_recovery_container")));
		if(driver.findElement(By.id("password_recovery_container")).isDisplayed())
		{
	
		System.out.println("Password Reset Window opens succesful : Test Passed");
		}
		else
		{
			System.out.println("Password Reset Window opening failed: Test Failed");
		}
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[9]/div[2]/div")));
		driver.findElement(By.xpath("/html/body/div[9]/div[2]/div")).click();
	    }		
}

