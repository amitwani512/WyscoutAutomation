package helper;

import org.openqa.selenium.By;

public class Constants {
 public static String chrome_browser = "chrome";
 public static String IE_browser = "Internet_exploxer";
 public static String firefox_browser = "Firefox";
 public static String wyscout = "https://platformrc.wyscout.com/app/";
 public static String userNamePath = "//*[@id='login_username']";
 public static String passwordID= "login_password";
 public static String loginBtnId = "login_button";
 public static String userNameID = "login_username";
 public static String chromeDriverPath = "/Users/apple/Documents/Automation/chromedriver";
 public static String chromeDriver = "webdriver.chrome.driver";
 public static String validUserName = "amit.wani@hudl.com";
 public static String validPassword = "pw_IndiaTest!";
 public static String invalidUserName = "wani.amit@hudl.com";
 public static String invalidPassword = "pw_indiatest!";
 public static String forceLoginBtnPath = "//*[@id='login_restrictor_dialog_container']/div/div[2]/button";
 public static String excpectedAccountName = "Amit";
 public static String actualAccountNamePath = "//div[@class='account_name']/h1"; 
 public static String lostYourPasswordPath = "//*[@class='new-login-link']";
 public static String passwordAssistancePopup = "/html/body/div/div/div/div/div/h1"; 
 public static String message = "Password Assistance";
 public static String incorrectPasswordPopUp = "/html/body/div[9]/div[1]/div";
 public static String logoutBtnPath = "/html/body/div[12]/div[1]/div/div/div/div[3]/div[2]/a/span[1]";
}
