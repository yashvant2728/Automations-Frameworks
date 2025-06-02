package Pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class login {
	@FindBy(how=How.XPATH,using="//input[@id='email']")
	private WebElement email;
	@FindBy (how=How.XPATH,using="//input[@id='password']")
	private WebElement password;
	@FindBy(how=How.XPATH,using="//button[@type='submit']")
	private WebElement loginbtn;
	@FindBy(how=How.XPATH,using="//button[@data-test-id='initial-message-close-button']")
	private WebElement helpbtn;
	public WebElement getEmail() {
		return email;
	}
	public WebElement getHelpbtn() {
		return helpbtn;
	}
	public void setHelpbtn(WebElement helpbtn) {
		this.helpbtn = helpbtn;
	}
	public WebElement getPassword() {
		return password;
	}
	public WebElement getLoginbtn() {
		return loginbtn;
	}
}
