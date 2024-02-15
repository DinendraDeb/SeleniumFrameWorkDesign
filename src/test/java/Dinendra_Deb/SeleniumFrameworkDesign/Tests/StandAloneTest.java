package Dinendra_Deb.SeleniumFrameworkDesign.Tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest {

	public static void main(String[] args) {
		//System.setProperty("webdriver.gecko.driver","C:\\\\Users\\\\debdi\\\\OneDrive\\\\Desktop\\\\Selenium\\\\Selenium_2023\\\\geckodriver-v0.33.0-win32\\\\geckodriver.exe");
		String productName = "ZARA COAT 3";
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/client");
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userEmail")));
		//LandingPage LP = new LandingPage(driver);
		driver.findElement(By.id("userEmail")).sendKeys("dinendra.deb@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Dinendra@1");
		driver.findElement(By.id("login")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
		WebElement prod = products.stream().filter(product-> product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		List<WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));
		Boolean match = cartProducts.stream().anyMatch(cartProduct-> cartProduct.getText().equalsIgnoreCase(productName));
		System.out.println(match);
		driver.findElement(By.xpath("//button[contains(text(),'Checkout')]")).click();
		Actions a = new Actions(driver);
		a.sendKeys(driver.findElement(By.xpath("//input[@placeholder= 'Select Country']")), "Ind").build().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		driver.findElement(By.xpath("(//span[contains(text(),'India')])[2]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Place Order')]")).click();
		String confirmMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
		System.out.println(confirmMessage);
		driver.close();
		
	
	}

}
