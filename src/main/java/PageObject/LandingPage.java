package PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import AbstractComponents.Abstract;

public class LandingPage extends Abstract {
	
	WebDriver driver;
	public LandingPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id = "userEmail")
	WebElement userEmail;
	
	@FindBy(id = "userPassword")
	WebElement passwordEle;
	
	@FindBy(id = "login")
	WebElement loginApp;
	
	By Mail = By.id("userEmail");
	
	public void loginApplication(String email, String password)
	{
		waitForelementtoAppear(Mail);
		userEmail.sendKeys(email);
	    passwordEle.sendKeys(password);
	    loginApp.click();
	}
	public void GoTo() 
	{
		driver.get("https://rahulshettyacademy.com/client");
	}



}

