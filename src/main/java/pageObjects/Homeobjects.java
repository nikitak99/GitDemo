package pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Homeobjects {

	
	public WebDriver driver;

	private By pop=By.cssSelector("div[style='position: absolute; inset: 0px; box-shadow: rgba(0, 0, 0, 0) 0px 0px 0px inset;']");
	private By login = By.cssSelector("a[href*='sign_in']");
	private By info=By.xpath("//div[contains(@class,'video')]/p");
	private By title=By.xpath("//body[1]/section[1]/div[1]/div[1]/h2[1]");
	
	

	public Homeobjects(WebDriver driver) {
		// TODO Auto-generated constructor stub

		this.driver = driver;
	}
	
	public WebElement pop() {

		return driver.findElement(pop);
		 
	}
	
	public WebElement getInfo() {

		return driver.findElement(info);
	}
	
	
	public WebElement getTitle() {

		return driver.findElement(title);
	}

	public  Loginobjects login() {

		System.out.println("Checking login feature");
		 driver.findElement(login).click();
		 return new Loginobjects(driver);
	}
	
	
	public void develop1() {

		System.out.println("Develop branch1");
	}
	
	public void develop2() {

		System.out.println("Develop branch2");
	}
	
	
	public void develop3() {

		System.out.println("Develop branch1");
	}
	
	public void develop4() {

		System.out.println("Develop branch3");
	}

}
