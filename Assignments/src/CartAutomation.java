import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartAutomation {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(5));
		// List of vegetable you want
		String[] veggies = { "Cucumber", "Brocolli", "Beetroot", "Carrot", "Pista" };

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		addItems(driver, veggies);

		driver.findElement(By.cssSelector("img[alt='Cart']")).click();

		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[placeholder='Enter promo code']")));
		driver.findElement(By.cssSelector("input[placeholder='Enter promo code']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button[class='promoBtn']")).click();
		
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span[class='promoInfo']")));
		System.out.println(driver.findElement(By.cssSelector("span[class='promoInfo']")).getText());
		driver.findElement(By.xpath("//button[contains(text(),'Place Order')]")).click();
		
	}

	// Method to add specific items to cart
	public static void addItems(WebDriver driver, String[] veggies) {

		List<WebElement> products = driver.findElements(By.cssSelector("h4[class='product-name']"));

		for (int i = 0; i < products.size(); i++) {

			String[] vegetable = products.get(i).getText().split("-");
			String exactName = vegetable[0].trim();
			// format to eliminate " - 1 Kg"
			// Check if the extracted text contains veggies
			// convert array into array list
			List veggieList = Arrays.asList(veggies);
			int j = 0;
			if (veggieList.contains(exactName)) {
				j++;
				driver.findElements(By.xpath("//div[@class='product-action']")).get(i).click();
				if (j == veggies.length) {
					break;
				}
			}
		}
	}
}
