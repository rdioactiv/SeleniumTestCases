import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/");
		driver.findElement(By.xpath("//a[contains(text(),\"Multiple Windows\")]")).click();
		driver.findElement(By.xpath("//a[contains(text(),\"Click Here\")]")).click();

		Set<String> window = driver.getWindowHandles();
		Iterator<String> Iterate = window.iterator();
		String parentId = Iterate.next();
		String childId = Iterate.next();

		driver.switchTo().window(childId);
		System.out.println(driver.findElement(By.xpath("//div/h3")).getText());
		driver.switchTo().window(parentId);
		System.out.println(driver.findElement(By.xpath("//div/h3")).getText());

	}

}
