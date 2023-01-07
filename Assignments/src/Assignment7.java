import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scroll(0,500)");

		// Print no.of rows
		int rows = driver.findElements(By.xpath("//body/div[3]/div[1]/fieldset/table/tbody/tr")).size();
		System.out.println(rows);

		// Print no. of columns
		int columns = driver.findElements(By.xpath("//body/div[3]/div[1]/fieldset/table/tbody/tr/th")).size();
		System.out.println(columns);

		// Print 2nd row contents
		String text = driver.findElement(By.xpath("//body/div[3]/div[1]/fieldset/table/tbody/tr[3]")).getText();
		System.out.println(text);

	}

}
