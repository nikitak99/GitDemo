package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPswdObject {

	WebDriver driver;
	
	
	By Femail=By.id("user_email");
	By sendinstruction= By.cssSelector("input[type='submit']");
	
	
	public ForgotPswdObject(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	public WebElement Foremail() {
		return driver.findElement(Femail);
	}
	
	public WebElement sendInstructions() {
		return driver.findElement(sendinstruction);
	}
}
