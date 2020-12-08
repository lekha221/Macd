package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CartPage 
{
	WebDriver driver;
	public CartPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id='menu-search']")
	WebElement searchItem;
	
	@FindBy(xpath="//*[@id='home-page-wrapper']/div[4]/app-search-items/div/div/div/div[3]/app-menu-items/div/app-menu-item[1]/div/div/div/app-price-section/div/div/button")
	WebElement addButton ;
	
	@FindBy(xpath="/html/body/ngb-modal-window/div/div/div[2]/div/div/div[2]/div[1]/div[1]/div[2]/div/label")
	WebElement addCoke;

	@FindBy(xpath="/html/body/ngb-modal-window/div/div/div[2]/div/div/div[2]/div[1]/div[1]/div[1]/div/p")
	WebElement removeCoke;
	
	@FindBy(xpath="/html/body/ngb-modal-window/div/div/div[3]/button[2]")
	WebElement addToCartButton;
	
	@FindBy(xpath="//*[@id='home-page-wrapper']/div[4]/app-search-items/div/div/div/div[4]/div")
	WebElement noResultFound;
	
	@FindBy(xpath="//*[@id='home-page-wrapper']/div[5]/app-cart-card/div/div[2]/button")
	WebElement viewCartButton;
	
	public void enterSearchItem(String item)
	{
		searchItem.sendKeys(item);
	}
	public void checkAddButton()
	{
		Assert.assertTrue(addButton.isDisplayed());
	}
	public void clickAddButton()
	{
		addButton.click();
	}
	public void clickAddCoke()
	{
		addCoke.click();
	}
	public void clickRemoveCoke()
	{
		removeCoke.click();
	}
	public void clickAddToCartButton()
	{
		addToCartButton.click();
	}
	public void checkViewCartButton()
	{
		Assert.assertTrue(viewCartButton.isDisplayed());
	}
	public void checkNoResultFound()
	{
		Assert.assertTrue(noResultFound.isDisplayed());
	}	
}
