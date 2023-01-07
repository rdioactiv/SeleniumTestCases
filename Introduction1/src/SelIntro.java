import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelIntro {

	public static void main(String[] args) {
		// Invoking browser
		// Chrome -> ChromeDriver -> Methods
		// ChromeDriver driver = new ChromeDriver();
		// Firefox -> FirefoxDriver -> Methods
		// FirefoxDriver driverF = new FirefoxDriver();

		// WebDriver just mentions the name, while methods in driver
		// classes(ChromeDriver, FirefoxDriver) contains the code to execute
		// Individual driver classes has their own unique methods which are not
		// available on WebDriver
		// ChromeDriver = WebDriver + class methods

		// chromedriver.exe -> Chrome browser (middleman proxy)
		// webdriver.chrome.driver -> value of path
		// don't copy zip folder path and add exe file name
		// System.setProperty("webdriver.chrome.driver",
		// "C:\\Users\\kevin\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
		// no need to set path in newer version of Selenium Software (optional step if
		// ypu have new version of Selenium)

		WebDriver driver = new ChromeDriver();

		// to open a website
		driver.get("https://www.youtube.com/");

		// to get the title of the page and show on console
		driver.getTitle();
		System.out.println(driver.getTitle());

		// to get the current url and show on console
		driver.getCurrentUrl();
		System.out.println(driver.getCurrentUrl());

		// to close the page that was initially opened (current window)
		driver.close();
		// to close all the tabs use
		// driver.quit();

	}

}
