package PageObject;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.Abstract;

public class Order extends Abstract {
	
	WebDriver driver;
	public Order(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "//input[@placeholder= 'Select Country']")
	WebElement AutoSuggest;
	
	@FindBy(xpath = "(//span[contains(text(),'India')])[2]")
	WebElement CountryClick;
	
	@FindBy(xpath = "//a[contains(text(),'Place Order')]")
	WebElement PlaceOrder;
	
	@FindBy(css = ".hero-primary")
	WebElement SuccessMsg;
	
	
	By autoSuggest_Output = By.cssSelector(".ta-results");
	
	
	public void placeOrder()
	{
		actionSendKeys(AutoSuggest,"Ind");	
		waitForelementtoAppear(autoSuggest_Output);
		CountryClick.click();
		PlaceOrder.click();
		String confirmMessage = SuccessMsg.getText();
		System.out.println(confirmMessage);
	}

	}
	

