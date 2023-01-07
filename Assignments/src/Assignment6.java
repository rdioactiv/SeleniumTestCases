import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Assignment6 {

	public static void main(String[] args) {
		// Select any one checkbox and print its corresponding text
		//
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		driver.findElement(By.id("checkBoxOption2")).click();
		String checkBox = driver.findElement(By.cssSelector("label[for='benz']")).getText();
		System.out.println(checkBox);
		WebElement staticDropdown = driver.findElement(By.id("dropdown-class-example"));
		Select dropDown = new Select(staticDropdown);
		dropDown.selectByVisibleText(checkBox);
		driver.findElement(By.cssSelector("input[placeholder='Enter Your Name']")).sendKeys(checkBox);
		driver.findElement(By.id("alertbtn")).click();
		String alert = driver.switchTo().alert().getText();
		String[] alertArray = alert.split(" ");
		String[] alertArray1 = alertArray[1].split(",");
		String requiredText = alertArray1[0];
		Assert.assertEquals(checkBox, requiredText);
		System.out.println(requiredText);
		driver.switchTo().alert().accept();

	}

}
