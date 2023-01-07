import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment3 {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(2));
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		String username = "rahulshettyacademy";
		String password = "learning";
		driver.findElement(By.cssSelector("input[name='username']")).sendKeys(username);
		driver.findElement(By.cssSelector("input[name='password']")).sendKeys(password);
		driver.findElement(By.xpath("//label[2]/span[2]")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[id='okayBtn']")));
		driver.findElement(By.cssSelector("button[id='okayBtn']")).click();

		WebElement staticDropdown = driver.findElement(By.cssSelector("select[class='form-control']"));
		Select person = new Select(staticDropdown);
		person.selectByValue("consult");

		driver.findElement(By.cssSelector("input[id='terms']")).click();
		driver.findElement(By.xpath("//input[@id='signInBtn']")).click();

		//String[] phones = { "iphone X", "Samsung Note 8", "Nokia Edge", "Blackberry" };

		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[class='nav-link btn btn-primary']")));
		List<WebElement> phoneName = driver.findElements(By.cssSelector("button[class='btn btn-info']"));

		for (int i = 0; i < phoneName.size(); i++) {
			phoneName.get(i).click();
		}
		driver.findElement(By.cssSelector("a[class='nav-link btn btn-primary']")).click();

	}

}
