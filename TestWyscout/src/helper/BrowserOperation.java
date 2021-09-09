package helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserOperation
{
	WebDriver driver;
	
		public void LaunchBrowser(String browserName)
		{
			if(browserName.equals(Constants.chrome_browser)) {
			 System.setProperty(Constants.chromeDriver, Constants.chromeDriverPath);
			 driver = new ChromeDriver();
			 driver.manage().window().maximize();
			 driver.get(Constants.wyscout);
			}
			else if(browserName.equals(Constants.IE_browser)) {}
			else {}//for firefox
		}

		public WebDriver getWebDriver()
		{
			return driver;
		}
		public void closeDriver() {
			driver.quit();	
		}


}




