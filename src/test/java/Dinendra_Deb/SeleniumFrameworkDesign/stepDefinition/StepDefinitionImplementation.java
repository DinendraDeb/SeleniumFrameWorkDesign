package Dinendra_Deb.SeleniumFrameworkDesign.stepDefinition;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;

import Dinendra_Deb.SeleniumFrameworkDesign.TestComponents.BaseTest;
import PageObject.LandingPage;
import PageObject.ProductCatalogue;
import io.cucumber.java.en.Given;

public class StepDefinitionImplementation extends BaseTest {
	
	public LandingPage landingpage;
	@Given("I landed on Ecommerce page")
	public void I_landed_on_Ecommerce_page() throws IOException
	{
	landingpage = LaunchApplication();
	}
	
	@Given ("^Logged in with username (.+) and password (.+)$")
	public void Logged_in_with_username_and_password(String username , String password) 
	{
		
	}
	@Given ("^I add product (.+) to Cart$")
	public void I_add_product_to_the_cart(String username , String password) 
	{
		ProductCatalogue PC = new ProductCatalogue(driver);
		List<WebElement> products = PC.getProductList();
		PC.getProductByName(productName);
		PC.addProducttoCart(productName);
	}
	

}
