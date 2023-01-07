import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Locators2 {

	public static void main(String[] args) throws InterruptedException {

		String name = "kevin";
		WebDriver driver = new ChromeDriver();
		String password = getPassword(driver);
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys(name);
		driver.findElement(By.name("inputPassword")).sendKeys(password);
		driver.findElement(By.className("signInBtn")).click();

		// <p style="color: rgb(27, 179, 102); font-size: 18px; text-align: center;">You
		// are successfully logged in.</p>
		Thread.sleep(1000);
		System.out.println(driver.findElement(By.tagName("p")).getText());
		Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");

		System.out.println(driver.findElement(By.xpath("//h2")).getText());
		Assert.assertEquals(driver.findElement(By.xpath("//h2")).getText(), "Hello " + name + ",");
		driver.findElement(By.xpath("//*[text()='Log Out']")).click();

	}

	public static String getPassword(WebDriver driver) throws InterruptedException {
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@class='reset-pwd-btn']")).click();

		// Store the extracted text in a String -> "Please use temporary password
		// 'rahulshettyacademy' to Login."
		String passwordText = driver.findElement(By.cssSelector("form p")).getText();

		// Extract the text -> Please use temporary password 'rahulshettyacademy' to
		// Login.
		// Only extract the actual password from the text
		// Split the text into two [before (') and after (')]
		// 0th index -> Please use temporary password
		// 1st index -> rahulshettyacademy' to Login.
		String[] passwordArray = passwordText.split("'");

		// Select only the password
		String[] passwordArrayRight = passwordArray[1].split("'");
		String password = passwordArrayRight[0];
		// Extract it
		return password;

	}
}
