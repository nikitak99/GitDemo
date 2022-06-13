package resources;

import java.io.File;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class base {

	public static WebDriver driver;
	public Properties prop;

	@SuppressWarnings("deprecation")
	public WebDriver propertiesMethod() throws IOException {

		 prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+
				"\\src\\main\\java\\resources\\data.properties");

		prop.load(fis);
		//String browname=System.getProperty("browser");
		String browname = prop.getProperty("browser");

		if (browname.equals("chrome")) {
			
			
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\admin\\Downloads\\Driver paths\\chromedriver_win32 (1)\\chromedriver.exe");
			driver = new ChromeDriver();
		//	ChromeOptions options=new ChromeOptions();
			//if(browname.contains("headless"))
			//options.addArguments("headless");

			
			//driver = new ChromeDriver(options);

		}

		else if (browname.equals("firefox")) {

			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\admin\\Downloads\\Driver paths\\geckodriver-v0.31.0-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
		}

		else if (browname.equals("edge")) {

			System.setProperty("webdriver.edge.driver",
					"C:\\Users\\admin\\Downloads\\Driver paths\\edgedriver_win32\\msedgedriver.exe");
			driver = new EdgeDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		return driver;
	}
	
	public String screenshotMethod(String failedtcname,WebDriver driver) throws IOException {
		
		TakesScreenshot ss=(TakesScreenshot)driver;
		File source =ss.getScreenshotAs(OutputType.FILE);
		String destinationfile=System.getProperty("user.dir")+"\\reports\\"+failedtcname+".png";
		FileUtils.copyFile(source,new File(destinationfile));
		return destinationfile;
	}
}
