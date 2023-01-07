import java.util.Iterator;
import java.util.Set;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.findElement(By.cssSelector("a[class='blinkingText']")).click();
		Set <String> windows = driver.getWindowHandles();
		Iterator <String> Iterate = windows.iterator();
		String parentId = Iterate.next();
		String childId = Iterate.next();
		driver.switchTo().window(childId);
		System.out.println(driver.findElement(By.cssSelector("p[class='im-para red']")).getText());
		String emailId = driver.findElement(By.cssSelector("p[class='im-para red']")).getText().split("at ")[1].trim().split(" ")[0];
		driver.switchTo().window(parentId);
		driver.findElement(By.cssSelector("input[name='username']")).sendKeys(emailId);
		
		
	}

}
