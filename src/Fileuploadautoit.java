import java.io.File;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Fileuploadautoit {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		String downloadpath=System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\Downloads\\chromedriver_win32\\chromedriver.exe");
		
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory", downloadpath);
		
		ChromeOptions options=new ChromeOptions();
		options.setExperimentalOption("prefs", chromePrefs);
		
		
		WebDriver driver=new ChromeDriver(options);
		
		driver.get("https://www.ilovepdf.com/word_to_pdf");
		driver.findElement(By.linkText("Select WORD files")).click();
		Thread.sleep(2000);
		Runtime.getRuntime().exec("D:\\FileUpload.exe");
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(20));
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("processTaskTextBtn")));
		driver.findElement(By.id("processTaskTextBtn")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[class='downloader__btn active']")));
		driver.findElement(By.cssSelector("a[class='downloader__btn active']")).click();
		
		Thread.sleep(4000);
		File f=new File(downloadpath+"/Nikita_Doc.pdf");
		
		if(f.exists()) {
			System.out.println("File found");
		}
		else
		{
			
			System.out.println("File not found");
		}
	    
	
	}

}
