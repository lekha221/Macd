package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage 
{
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id='headerComp']/div/div[2]/div[2]/div[2]")
	WebElement loginSignupButton;
	
	@FindBy(xpath="/html/body/ngb-modal-window/div/div/app-login-modal/div/div[1]/div/div[2]/div")
	WebElement loginViaPassword;
	
	@FindBy(xpath="/html/body/ngb-modal-window/div/div/app-login-modal/div/div[2]/form/div/div[1]/input")
	WebElement mobileNo;
	
	@FindBy(xpath="//*[@id='password']")
	WebElement password;
	
	@FindBy(xpath="/html/body/ngb-modal-window/div/div/app-login-modal/div/div[2]/form/div/div[4]/div[3]/button")
	WebElement loginButton;
	
	@FindBy(xpath="/html/body/ngb-modal-window/div/div/app-login-modal/div/div[2]/form/div/div[2]/label")
	WebElement invalidUserPassMessage;
	
	@FindBy(xpath="//*[@id='headerComp']/div/div[2]/div[2]/div[3]")
	WebElement myAccount;
	
	public void clickLoginSignup()
	{
		loginSignupButton.click();
	}
	public void clickLoginViaPassword()
	{
		loginViaPassword.click();
	}
	public void enterMobileNo(String mbno)
	{
		mobileNo.sendKeys(mbno);
	}
	public void enterPassword(String pass)
	{
		password.sendKeys(pass);
	}
	public void clickLoginButton()
	{
		loginButton.click();
	}
	public void checkInvalidUserPassMessage()
	{
		Assert.assertEquals("Invalid username or password", invalidUserPassMessage.getText());
	}
	public void checkLogin()
	{
		Assert.assertEquals("My Account", myAccount.getText());
	}
}



