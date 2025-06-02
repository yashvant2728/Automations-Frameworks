package Test_login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Pom.login;
import Utility.Base_class;
import Utility.Config_data;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Test2  {
	public static Config_data config=new Config_data();
	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://develop-v2.t2d2.ai/auth/login");
		driver.manage().window().maximize();
		login lgpage= PageFactory.initElements(driver, login.class);
		lgpage.getEmail().sendKeys("1212");
		lgpage.getPassword().sendKeys("11");
		driver.findElement(By.xpath("//a[@id='hs-eu-decline-button']")).click();
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		WebElement msg=driver.findElement(By.xpath("//span[@class='text-label-small light-error']"));
		msg.getText();
		String Actual_msg=msg.getText();
		String Expected_msg="Please enter valid email.";
		Assert.assertEquals(Actual_msg, Expected_msg, Expected_msg);
		System.out.println("Test1_Pass"); //1
		WebElement psw_msg=driver.findElement(By.xpath("(//span[@class='text-label-small light-error'])[2]"));
		String Actual_psw=psw_msg.getText();
		String Expected_psw="Please enter password.";
		Assert.assertNotSame(Actual_psw, Expected_psw);
		//Assert.assertEquals(Actual_psw, Expected_psw);
		System.out.println("Test2_fail");
		System.out.println(psw_msg.getText());
		Thread.sleep(3000);
		driver.quit();
	}
}
