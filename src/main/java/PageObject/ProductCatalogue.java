package PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.Abstract;

public class ProductCatalogue extends Abstract {
	
	WebDriver driver;
	public ProductCatalogue(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(css = "mb-3")
	List<WebElement> products;
	
	@FindBy(css = ".ng-animating")
	WebElement spinner;
	
	By ProductsBy = By.cssSelector(".mb-3");
	By addToCart = By.cssSelector(".card-body button:last-of-type");
	By successMsg = By.cssSelector("#toast-container");

	
	public List<WebElement> getProductList() {
		
		
		waitForelementtoAppear(ProductsBy);
		return products;
	}
	
	public WebElement getProductByName(String productName) 
	{
		WebElement prod = getProductList().stream().filter(product-> product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		return prod;
	}
	
	
	public void addProducttoCart(String productName) throws InterruptedException
	{
		Thread.sleep(2000);
		WebElement e = getProductByName(productName);
		Thread.sleep(2000);
		e.findElement(addToCart).click();
		waitForelementtoAppear(successMsg);
		waitForelementtoDisappear(spinner);
	}


}

