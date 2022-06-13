package Projects.MavenRevision;

import java.io.IOException;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.Homeobjects;
import resources.base;

public class validatetitleTest extends base {

	public WebDriver driver;
	public static Logger log= LogManager.getLogger(base.class.getName());
	
	Homeobjects h;

	@BeforeTest

	public void initialize() throws IOException {

		driver = propertiesMethod();
		driver.get(prop.getProperty("url"));
	}

	@SuppressWarnings("deprecation")
	
	@Test
	public void validateTitle() throws IOException {

		h=new Homeobjects(driver);
		Assert.assertEquals(h.getTitle().getText(), "FEATURED CO11URSES");
		log.info("Success title retrieval");
	}

	
	@SuppressWarnings("deprecation")
	@Test
	
	public void validateInfo() throws IOException {
		
		h=new Homeobjects(driver);
		Assert.assertEquals(h.getInfo().getText(), "Learn Hot tools like Selenium, Appium, JMeter, SoapUI,Database Testing and more..");
		
	}
	
	
	@AfterTest
	
	public void close() {
		
		driver.close();
	}
}
