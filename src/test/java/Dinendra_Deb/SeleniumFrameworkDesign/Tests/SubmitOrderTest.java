package Dinendra_Deb.SeleniumFrameworkDesign.Tests;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.Assert;
import Dinendra_Deb.SeleniumFrameworkDesign.TestComponents.BaseTest;
import PageObject.Cart;
import PageObject.Order;
import PageObject.ProductCatalogue;


public class SubmitOrderTest extends BaseTest {

	
	@Test
	public void SubmitOrder() throws IOException, InterruptedException  
	{
		String productName = "ZARA COAT 3";
		LaunchApplication();
		ProductCatalogue PC = new ProductCatalogue(driver);
		List<WebElement> products = PC.getProductList();
		PC.getProductByName(productName);
		PC.addProducttoCart(productName);
		Cart c = new Cart(driver);
		c.clickIcon();
		List<WebElement> cartProducts = c.getCartProducts();
		c.MatchProductByName(productName);
		Order Or = new Order(driver);
		Or.placeOrder();
	}
	
	

}
