import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/locatorspractice/");

		// Find UsernameBox and type something
		// <input type="text" placeholder="Username" id="inputUsername" value="">
		driver.findElement(By.id("inputUsername")).sendKeys("kevin");

		// Find Passwordbox and type something
		// <input type="password" placeholder="Password" name="inputPassword" value="">
		driver.findElement(By.name("inputPassword")).sendKeys("notPassword");

		// to find and click button (if space it means it has two classes)
		// <button class="submit signInBtn" type="submit">Sign In</button>
		driver.findElement(By.className("signInBtn")).click();

		// Special Locators -> Xpath and CSS Selector
		// CSS Selector -> (tagname.classname)(tagname#id)(Button.classname)
		// Universal format *(tagname[attribute='value'])*
		// Check your locators are unique
		// Xpath Selector -> (//Tagname[@attribute='value']

		// Find error message and show on console
		// Use CSS Selector -> tagname[attribute='value']<p class="error">* Incorrect
		// username or password </p>
		// *it wont show on console because of timeout issue*
		// to add wait time use
		// driver.manage().timeouts().implicitWait(Duration.ofSeconds());
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.cssSelector("p.error")).getText();
		System.out.println(driver.findElement(By.cssSelector("p.error")).getText());

		// Find 'Forgot your password' and click
		// a stands for anchor i.e link (HTML rules)
		// use LinkText locator
		// <a href="#" xpath="1">Forgot your password?</a>
		driver.findElement(By.linkText("Forgot your password?")).click();

		// Find name box with Xpath Locator
		// <input type="text" placeholder="Name" xpath="1">
		// Use Xpath -> //Tagname[@attribute='value'] -> //input[@Placeholder='Name']
		driver.findElement(By.xpath("//input[@Placeholder='Name']")).sendKeys("Kevin");

		// Find email box with CSS Selector
		// <input type="text" placeholder="Email" css="1">
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("Joseph");
		driver.findElement(By.cssSelector("input[placeholder='Email']")).clear();

		// if multiple elements are matching then use index value with :nth-child()
		// input[type="text"]:nth-child(3) **Check the index value on console**
		driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("Joseph123");

		// if multiple elements are matching then use index value after syntax (only
		// Xpath)
		// //input[@type='text'][2];
		// driver.findElement(By.cssSelector("//input[@type='text'][2])")).sendKeys("Joseph123");

		// travel with parent and child tagnames (forXpath)
		// //form/h2

		// find phone number with parent-child tagname
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("45436347547");

		// Find Reset login button and click
		// <button class="reset-pwd-btn" xpath="1">Reset Login</button>
		// element click intercepted error if timeout is not given
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@class='reset-pwd-btn']")).click();

		// Find error message and print output
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		System.out.println(driver.findElement(By.cssSelector("form p")).getText());

		driver.findElement(By.cssSelector("button[class='go-to-login-btn']")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input[id='inputUsername']")).sendKeys("Kev");

		// By regular expression CSS Selector
		driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");

		driver.findElement(By.xpath("//input[@id='chkboxOne']")).click();

		// By regular expression Xpath
		driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
		// <button class="logout-btn">Log Out</button>
		// //button[@class='logout-btn']
		// Thread.sleep(1000);
		// driver.findElement(By.xpath("//button[@class='logout-btn']")).click();

	}

}
