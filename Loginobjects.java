package pageObjects;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Loginobjects {

	public WebDriver driver;

	By email = By.xpath("//input[@type='email']");
	By pswd = By.id("user_password");
	By submit=By.cssSelector(".login-button");
	By forgotpswd=By.linkText("Forgot Password?");


	public Loginobjects(WebDriver driver) {
		// TODO Auto-generated constructor stub

		this.driver = driver;
	}

	
	
	public WebElement email() {

		return driver.findElement(email);
	}

	public WebElement password() {

		return driver.findElement(pswd);

	}
	
	public WebElement submit() {

		return driver.findElement(submit);

	}
	
	public ForgotPswdObject forgot() {

		 driver.findElement(forgotpswd).click();
		 return new ForgotPswdObject(driver);
	}
	
}
