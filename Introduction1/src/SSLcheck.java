import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SSLcheck {

	public static void main(String[] args) {

		// Use "https://chromedriver.chromium.org/capabilities" for more help with 'options' syntax
		ChromeOptions options = new ChromeOptions();
		options.setAcceptInsecureCerts(true);

		// To set proxy
		// Proxy proxy = new Proxy();
		// proxy.setHttpProxy("ipaddress: 4444");

		// To block all popup windows
		// options.setExperimentalOption("excludeSwitches",
		// Arrays.asList("disable-popup-blocking"));

		// To set download directory
		// Map<String, Object> prefs = new HashMap<String, Object>();
		// prefs.put("download.default_directory", "/directory/path");
		// options.setExperimentalOption("prefs", prefs);

		WebDriver driver = new ChromeDriver(options);
		driver.get("https://expired.badssl.com/");
		System.out.println(driver.getTitle());

	}

}
