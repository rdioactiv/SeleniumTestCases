import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Miscellaneous {

	public static void main(String[] args) throws IOException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		// to delete cookies
		driver.manage().deleteAllCookies();

		// to delete one cookie called 'sessionKey'
		// driver.manage().deleteCookieNamed("sessionKey");

		driver.get("https://www.google.com/");

		// to take screenshots
		// don't save in C drive, if no other drive is avaialble the use 'Users'
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src,new File("C:\\Users\\kevin\\screenshot.png"));

	}

}
