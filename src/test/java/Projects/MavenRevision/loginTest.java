package Projects.MavenRevision;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.ForgotPswdObject;
import pageObjects.Homeobjects;
import pageObjects.Loginobjects;
import resources.base;

public class loginTest extends base {

	public WebDriver driver;
	public static Logger log= LogManager.getLogger(base.class.getName());

	@BeforeMethod

	public void initialize() throws IOException {

		driver = propertiesMethod();
		driver.get(prop.getProperty("url"));
	}

	@Test(dataProvider = "getData")

	public void propMethod(String Username, String Password, String text) throws IOException {
	
		Homeobjects home = new Homeobjects(driver);
		home.pop().click();
		Loginobjects l=home.login();
		log.info(text);

		l.email().sendKeys(Username);
		l.password().sendKeys(Password);
		//login.submit().click();
		
		ForgotPswdObject fp=l.forgot();
		log.info(text);
		fp.Foremail().sendKeys("nk@gmail.com");
		fp.sendInstructions().click();

	}

	@AfterMethod

	public void close() {

		driver.close();
	}
	

	@DataProvider
	public Object[][] getData() {

		Object[][] data = new Object[2][3];

		data[0][0] = "user1@gmail.com";
		data[0][1] = "user@333";
		data[0][2] = "first user";

		data[1][0] = "user2@gmail.com";
		data[1][1] = "user@22";
		data[1][2] = "second user";

		return data;

	}
	


}
