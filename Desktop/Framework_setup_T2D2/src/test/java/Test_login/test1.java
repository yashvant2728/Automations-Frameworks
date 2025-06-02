package Test_login;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import Pom.login;
import Utility.Base_class;
import net.bytebuddy.utility.RandomString;
public class test1 extends Base_class {
	public login lgpage;
	public TakesScreenshot ts;

	@Test
	public void verify_log_in() throws Exception {
		lgpage= PageFactory.initElements(driver, login.class);
		lgpage.getEmail().sendKeys("ravi.gajera@inheritx.com");
		lgpage.getPassword().sendKeys("Ravi@1234");
		lgpage.getLoginbtn().click();
		driver.findElement(By.xpath("//a[@id='hs-eu-decline-button']")).click();
		Thread.sleep(3000);
		//driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/button")).click();
		driver.getTitle();
		System.out.println(driver.getTitle());
		Thread.sleep(3000);
		ts= (TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		String screenshotname= RandomString.make(3);
		File dest=new File("/Users/yashvantandure/eclipse-workspace/Framework_setup_T2D2/Test_output"+screenshotname+".Png");
		FileUtils.copyFile(src, dest);	
	}
	@Test
	public void verify_log_in_invalid() throws Exception {
		lgpage= PageFactory.initElements(driver, login.class);
		lgpage.getEmail().sendKeys("ravi1.gajera@inheritx.com");
		lgpage.getPassword().sendKeys("Ravi@12345");
		lgpage.getLoginbtn().click();
		//Thread.sleep(000);
		driver.findElement(By.xpath("//a[@id='hs-eu-decline-button']")).click();
		Thread.sleep(1000);
		//driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/button")).click();
		driver.getTitle();
		Thread.sleep(2000);
		TakesScreenshot ts1= (TakesScreenshot)driver;
		File src1=ts1.getScreenshotAs(OutputType.FILE);
		String screenshotname1= RandomString.make(3);
		File dest1=new File("/Users/yashvantandure/eclipse-workspace/Framework_setup_T2D2/Test_output"+screenshotname1+".Png");
		FileUtils.copyFile(src1, dest1);

	}

}
