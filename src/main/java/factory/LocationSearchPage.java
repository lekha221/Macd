package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LocationSearchPage 
{
	WebDriver driver;
	public LocationSearchPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id='menu-search']")
	WebElement locationSearch;
	
	@FindBy(xpath="//*[@id='aahaar-wrapper']/app-set-location/div/div/div[2]/div/button")
	WebElement doneButton;
	
	@FindBy(xpath="//*[@id='building']")
	WebElement address;
	
	@FindBy(xpath="//*[@id='aahaar-wrapper']/app-set-location/div/div/div[2]/div/button")
	WebElement selectAndSaveButton;
	
	@FindBy(xpath="//*[@id='aahaar-wrapper']/app-set-location/div/div/div[2]/div/div/div/span[1]")
	WebElement dontServeLocationMessage;
	
	@FindBy(xpath="//*[@id='aahaar-wrapper']/app-set-location/div/div/div[1]/div[3]/div/div[3]/div")
	WebElement noLocationFound;
	
	@FindBy(xpath="//*[@id='aahaar-wrapper']/app-set-location/div/div/div[1]/div[3]/div/div[3]/div[1]/div/div[1]/div[2]")
	WebElement firstButton;
	
	
	public void enterLocationSearch(String loc)
	{
		locationSearch.sendKeys(loc);
		
	}
	public void clickDoneButton()
	{
		doneButton.click();
	}
	public void enterAddress(String add)
	{
		address.sendKeys(add);
	}
	public void clickSelectAndSaveButton()
	{
		selectAndSaveButton.click();
	}
	public void clickFirstButton()
	{
		firstButton.click();
	}
	public void checkNotServeMessage() 
	{
		Assert.assertEquals("We do not serve this location as of now.", dontServeLocationMessage.getText());
	}
	public void checkNoLocationFoundMessage() 
	{
		Assert.assertEquals("No results found, please enter nearby landmark & drop the pin on map", noLocationFound.getText());
	}
}
