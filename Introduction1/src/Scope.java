import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Scope {

	public static void main(String[] args) throws InterruptedException {

		// <1> Give the number of links on the webpage
		// <2> Count of links in footer section
		// <3> Links in first column of footer section
		// <4> Check easch link if they are working

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		// tags usually contains tag 'a'
		System.out.println(driver.findElements(By.tagName("a")).size());

		// Only use footer as the scope of testing
		WebElement footer = driver.findElement(By.id("gf-BIG"));
		System.out.println(footer.findElements(By.tagName("a")).size());

		// Only use column as the scope of testing
		WebElement column = driver.findElement(By.xpath("//td[1]/ul"));
		System.out.println(column.findElements(By.tagName("a")).size());
		
		
	
		for (int i = 1; i < column.findElements(By.tagName("a")).size(); i++) {

			String controlClick = Keys.chord(Keys.CONTROL, Keys.ENTER);

			column.findElements(By.tagName("a")).get(i).sendKeys(controlClick);
			Thread.sleep(3000);
		}
		Set<String> pageTitle = driver.getWindowHandles();
		Iterator<String> Iterate = pageTitle.iterator();
			while (Iterate.hasNext()) {

				driver.switchTo().window(Iterate.next());
				System.out.println(driver.getTitle());
			}
		}

	}

