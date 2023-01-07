import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SecondAssignment {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.findElement(By.name("name")).sendKeys("Automation Tester");
		driver.findElement(By.name("email")).sendKeys("Automation@Tester.com");
		driver.findElement(By.id("exampleInputPassword1")).sendKeys("Password");
		driver.findElement(By.id("exampleCheck1")).click();

		WebElement staticDropdown = driver.findElement(By.id("exampleFormControlSelect1"));
		Select option = new Select(staticDropdown);

		option.selectByIndex(0);

		driver.findElement(By.id("inlineRadio1")).click();
		driver.findElement(By.name("bday")).sendKeys("1992-01-01");
		driver.findElement(By.cssSelector("input[value='Submit']")).click();

		System.out.println(
				driver.findElement(By.cssSelector("div[class='alert alert-success alert-dismissible']")).getText());

	}

}
