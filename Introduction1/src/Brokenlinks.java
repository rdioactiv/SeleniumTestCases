import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class Brokenlinks {

	public static void main(String[] args) throws MalformedURLException, IOException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/#");

		// <1> get all URL'S
		// <2> get the status code by Java Methods
		// <3> if status code is > 400, then link is briken

		// Working Link - will show output < 400
		String url1 = driver.findElement(By.cssSelector("a[href='https://www.soapui.org/']")).getAttribute("href");
		HttpURLConnection conn1 = (HttpURLConnection) new URL(url1).openConnection();
		conn1.setRequestMethod("HEAD");
		conn1.connect();
		int responseCode1 = conn1.getResponseCode();
		System.out.println(responseCode1);

		// Broken Link - will show output > 400 String url2 =
		String url2 = driver.findElement(By.cssSelector("a[href='https://rahulshettyacademy.com/brokenlink']"))
				.getAttribute("href");
		HttpURLConnection conn2 = (HttpURLConnection) new URL(url2).openConnection();
		conn2.setRequestMethod("HEAD");
		conn2.connect();
		int responseCode2 = conn2.getResponseCode();
		System.out.println(responseCode2);

		// Check all links
		List<WebElement> links = driver.findElements(By.cssSelector("li[class='gf-li'] a"));
		SoftAssert sA = new SoftAssert();
		for (WebElement link : links) {

			String url = link.getAttribute("href");
			HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int responseCode = conn.getResponseCode();
			System.out.println(responseCode);
			sA.assertTrue(responseCode < 400,
					"The link with text '" + link.getText() + "' is broken with code" + responseCode);

			
			// Another method to write the above code
			// if (responseCode > 400) {
			// System.out.println("The link with text '" + link.getText() + "' is broken
			// with code" + responseCode);
			// if link fails the remaining links wont execute is using hard Assert
			// Assert.assertTrue(false);
			// }
		}
		//to report the failure
		sA.assertAll();
	}
}
