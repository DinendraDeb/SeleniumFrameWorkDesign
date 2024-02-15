package Dinendra_Deb.SeleniumFrameworkDesign.TestComponents;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import PageObject.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public  WebDriver driver;

	public  WebDriver initializeDriver() throws IOException {
		
		//properties class
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\debdi\\OneDrive\\Desktop\\Selenium\\Selenium_2023\\Eclipse_Workspace_2023\\SeleniumFrameworkDesign\\src\\main\\java\\Dinendra_Deb\\SeleniumFrameworkDesign\\resources\\GlobalData.properties");
		prop.load(fis);
		String browserName = System.getProperty("browser")!= null? System.getProperty("browser"): prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("firefox"))
		{
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("chrome"))
		{
		//chrome	
		}
		else
		{
			//edge
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		return driver;
	}
	
	@BeforeMethod(alwaysRun =true)
	public  LandingPage LaunchApplication() throws IOException
	{
		driver = initializeDriver();
		LandingPage Lp = new LandingPage(driver);
		Lp.GoTo();
		Lp.loginApplication("dinendra.deb@gmail.com", "Dinendra@1");
		return Lp;
		
	}
	
	@AfterMethod
	public void tearDown() 
	{
		driver.close();
	}

}
