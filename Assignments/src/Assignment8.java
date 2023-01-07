import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class Assignment8 {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.cssSelector("input[id='autocomplete']")).sendKeys("can");
		Thread.sleep(3000);
		Actions a = new Actions(driver);
		WebElement option = driver.findElement(By.xpath("//div[1][contains(text(),'Canada')]"));
		a.moveToElement(option).click().build().perform();
		Thread.sleep(3000);

		String country = driver.findElement(By.cssSelector("input[id='autocomplete']")).getAttribute("value");
		Assert.assertEquals(country, "Canada");
		System.out.println(country);

	}

}
