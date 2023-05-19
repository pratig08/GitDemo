package seleniumFeaturesLatest;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;

public class setGeoLocation {

	public static void main(String[] args) throws InterruptedException {
	
		System.setProperty("webdriver.chrome.driver", "C:\\Pratibha\\Web Drivers\\chromedriver.exe");

		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.default_content_setting_values.notifications", 2);

		ChromeOptions options = new ChromeOptions();

		options.addArguments("--remote-allow-origins=*");
		options.setExperimentalOption("prefs", prefs);

		ChromeDriver driver = new ChromeDriver(options);
		
		DevTools devTools=driver.getDevTools();
		devTools.createSession();
		
		Map<String,Object> coordinates =new HashMap<String,Object>();
		
		coordinates.put("latitude", 38.9072);
		coordinates.put("longitude", -77.0369);
		coordinates.put("accuracy", 100);
		
		//coordinates.put("latitude", 40.416775);
		//coordinates.put("longitude", 3.703790);
		//coordinates.put("accuracy", 100);
		
		driver.executeCdpCommand("Emulation.setGeolocationOverride", coordinates);
		
		//driver.get("https://www.google.com/");
		driver.get("https://locations.kfc.com/search");
		
		Thread.sleep(2000);
		
		WebElement elem = driver.findElement(By.cssSelector(".Locator-button.js-locator-geolocateTrigger"));

		elem.click();
		/*
		driver.findElement(By.name("q")).sendKeys("netflix",Keys.ENTER);
		Thread.sleep(3000);
		
		driver.findElements(By.cssSelector("h3[class='LC20lb MBeuO DKV0Md']")).get(0).click();
		
		String title=driver.findElement(By.cssSelector("h1[class*='default-ltr-cache-qsjwmk']")).getText();
		
		 System.out.println(title);
		
        */
		
		System.out.println("Locations found");
	}

}
