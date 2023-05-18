package seleniumFeaturesLatest;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;
import java.net.URI;

import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class basicAuthentication {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Pratibha\\Web Drivers\\chromedriver.exe");

		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.default_content_setting_values.notifications", 2);

		ChromeOptions options = new ChromeOptions();

		options.addArguments("--remote-allow-origins=*");
		options.setExperimentalOption("prefs", prefs);

		ChromeDriver driver = new ChromeDriver(options);
		
		Predicate<URI> uriPredicate=uri->uri.getHost().contains("httpbin.org");

		((HasAuthentication)driver).register(uriPredicate,UsernameAndPassword.of("foo","bar"));
		
		driver.get("http://httpbin.org/basic-auth/foo/bar");
		

	}

}
