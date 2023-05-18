package autoITTests;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class fileConversion {

	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\Pratibha\\Web Drivers\\chromedriver.exe");

		String downloadPath=System.getProperty("user.dir");
		
		
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.default_content_setting_values.notifications", 2);
		
		prefs.put("profile.default_content_settings.popups", 0);
		prefs.put("download.default_directory", downloadPath);
 
		ChromeOptions options = new ChromeOptions();
		
		options.addArguments("--remote-allow-origins=*");
		options.setExperimentalOption("prefs", prefs);

		ChromeDriver driver = new ChromeDriver(options);
		
		driver.get("https://altoconvertpdftojpg.com/");
		
		driver.findElement(By.id("browse")).click();
		
		Thread.sleep(3000);
		
		Runtime.getRuntime().exec(new String[]{"C:\\Pratibha\\Selenium\\autoitpdf.exe"});           
		
		Thread.sleep(2000);
		
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(30));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class*='col-md-6']")));
		
		driver.findElement(By.id("submit_btn")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[class*='btn']")));
		
		driver.findElement(By.cssSelector("a[class*='btn']")).click();
		
		Thread.sleep(5000);
		
		File f=new File(downloadPath+"/Converted.zip");
		
		if(f.exists())
		   {System.out.println("File found");
		   }		
		
	}

}
