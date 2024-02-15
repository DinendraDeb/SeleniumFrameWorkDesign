package PageObject;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import AbstractComponents.Abstract;

public class Cart extends Abstract {
	
	WebDriver driver;
	public Cart(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(css = "[routerlink*='cart']")
	WebElement CartIcon;
	
	@FindBy(css = ".cartSection h3")
	List<WebElement> cartProducts;
	
	@FindBy(xpath = "//button[contains(text(),'Checkout')]")
	WebElement Checkoutclick;
	
	public void clickIcon()
	{
		CartIcon.click();
	   
	}
	public List<WebElement> getCartProducts() {
		
		
		return cartProducts;
	}
	
	public void MatchProductByName(String productName)
	{
		Boolean match = getCartProducts().stream().anyMatch(cartProduct-> cartProduct.getText().equalsIgnoreCase(productName));
		System.out.println(match);
		Checkoutclick.click();
	}
	
	


	

}
