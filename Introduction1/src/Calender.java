import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Calender {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
	
		driver.get("https://www.path2usa.com/travel-companion/");
		//driver.manage().window().maximize();
		
		//month and date
		//Scrolling required
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,800)");
		Thread.sleep(9000);
		
		driver.findElement(By.xpath("/html[1]/body[1]/div[2]/section[2]/div[1]/div[1]/div[1]/section[1]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[3]/input[1]")).click();
		
		while(!driver.findElement(By.cssSelector("span[class='cur-month']")).getText().contains("March")) {
			driver.findElement(By.cssSelector("span[class='flatpickr-next-month']")).click();
			Thread.sleep(1000);
		}
	
		
		List<WebElement> dates = driver.findElements(By.className("flatpickr-day"));
		
		for(int i = 0; i<driver.findElements(By.className("flatpickr-day")).size(); i++) {
			String text = driver.findElements(By.className("flatpickr-day")).get(i).getText();
			if(text.equalsIgnoreCase("23")) {
				driver.findElements(By.className("flatpickr-day")).get(i).click();
				break;
	
			}
		}

	}

	
	}




