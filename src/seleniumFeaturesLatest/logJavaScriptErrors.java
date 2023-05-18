package seleniumFeaturesLatest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

public class logJavaScriptErrors {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Pratibha\\Web Drivers\\chromedriver.exe");

		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.default_content_setting_values.notifications", 2);

		ChromeOptions options = new ChromeOptions();

		options.addArguments("--remote-allow-origins=*");
		options.setExperimentalOption("prefs", prefs);

		ChromeDriver driver = new ChromeDriver(options);
		
        driver.get("https://rahulshettyacademy.com/angularAppdemo/"); 		
		driver.findElement(By.linkText("Browse Products")).click();		
		driver.findElement(By.linkText("Selenium")).click();		
		driver.findElement(By.cssSelector(".add-to-cart")).click();	
		driver.findElement(By.linkText("Cart")).click();
		driver.findElement(By.id("exampleInputEmail1")).clear();
		driver.findElement(By.id("exampleInputEmail1")).sendKeys("2");
		
		LogEntries entry= driver.manage().logs().get(LogType.BROWSER);
		List<LogEntry> logs=entry.getAll();
		for(LogEntry e:logs)
		{System.out.println(e.getMessage());
		}
		
		

	}
 
}
