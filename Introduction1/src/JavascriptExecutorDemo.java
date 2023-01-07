import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class JavascriptExecutorDemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		//Window scroll
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scroll(0,500)");
		
		//Scroll inside the table
		Thread.sleep(3000);
		jse.executeScript("document.querySelector(\".tableFixHead\").scrollTop=5000");
		////div[3]/div[2]/fieldset[2]/div/table/tbody/tr
		int sum = 0;
		List<WebElement> values = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		for(int i = 0; i < values.size(); i++) {
			
			sum = sum + Integer.parseInt(values.get(i).getText());
			
		}
		System.out.println(sum);
		
		int total = Integer.parseInt(driver.findElement(By.cssSelector("div[class='totalAmount']")).getText().split(": ")[1]);
		Assert.assertEquals(total, sum);
	}

}
