package seleniumFeaturesLatest;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v110.network.Network;
import org.openqa.selenium.devtools.v110.network.model.Request;
import org.openqa.selenium.devtools.v110.network.model.Response;

public class NetworkLogActivity {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Pratibha\\Web Drivers\\chromedriver.exe");

		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.default_content_setting_values.notifications", 2);

		ChromeOptions options = new ChromeOptions();

		options.addArguments("--remote-allow-origins=*");
		options.setExperimentalOption("prefs", prefs);

		ChromeDriver driver = new ChromeDriver(options);

		DevTools devTools = driver.getDevTools();

		devTools.createSession();
		
		devTools.send(Network.enable(Optional .empty(), Optional.empty(), Optional.empty()));
		
		
		devTools.addListener(Network.requestWillBeSent(), request->
		{Request req = request.getRequest();
		 //System.out.println(req.getUrl());
			
		});
		
		
		
		devTools.addListener(Network.responseReceived(), response->
		{ 
			Response res=response.getResponse();
			//System.out.println(res.getUrl());
			//System.out.println(res.getStatus());
			if(res.getStatus().toString().startsWith("4"))
			{
				System.out.println(res.getUrl()+" is failing with status code "+res.getStatus());
			}
		});
		
		//driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		//driver.findElement(By.cssSelector("button[class*='btn btn-primary']")).click();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.cssSelector("a[href='https://rahulshettyacademy.com/brokenlink']")).click();
	
		
   
	} 

}
