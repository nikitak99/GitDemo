package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentRepo {

	static ExtentReports ex;

	public static ExtentReports getReportObject() {

		String path = System.getProperty("user.dir") + "\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Automation Report");
		reporter.config().setDocumentTitle("Test Results");

		ex = new ExtentReports();
		ex.attachReporter(reporter);
		ex.setSystemInfo("Tester", "Nikita");
		return ex;
	}

/*	@Test
	public void InitialDemo() {
		
		
	
	System.setProperty("webdriver.chrome.driver","C:\\Users\\admin\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	
	driver.get("https://www.rahulshettyacademy.com");
	System.out.println(driver.getTitle());
	//test.fail("Result failed");

	}*/
}

