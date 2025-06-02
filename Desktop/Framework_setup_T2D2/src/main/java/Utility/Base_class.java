package Utility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import io.github.bonigarcia.wdm.WebDriverManager;
public class Base_class {
	Config_data config=new Config_data();
	public WebDriver driver;
	@Parameters({"Browser_name"})
	@BeforeMethod

	public void bowser_open(String Browser_name) {
		if(Browser_name.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(Browser_name.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		//driver.get(config.get_baseurl());
		driver.get("https://develop-v2.t2d2.ai/auth/login");
		driver.manage().window().maximize();
	}
	@AfterMethod
	public void tear_down_browser() {
		driver.quit();
	}
}

