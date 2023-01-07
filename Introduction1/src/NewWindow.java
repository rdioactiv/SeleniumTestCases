import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewWindow {

	public static void main(String[] args) throws IOException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		//Switching window
		driver.switchTo().newWindow(WindowType.TAB);
		Set <String> handles = driver.getWindowHandles();
		Iterator <String> iT = handles.iterator();
		String parentWindowId = iT.next();
		String childWindowId = iT.next();
		driver.switchTo().window(childWindowId);
		driver.get("https://rahulshettyacademy.com/");
		String courseName = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']")).get(1).getText();
		driver.switchTo().window(parentWindowId);
		//driver.findElement(By.name("name")).sendKeys(courseNAme);
		
		WebElement name = driver.findElement(By.name("name"));
		name.sendKeys(courseName);
		// Take WebElement Screenshot
		File file = name.getScreenshotAs(OutputType.FILE);
	
		FileUtils.copyFile(file, new File("logo.png"));
		
		//Get Height and Width
		System.out.println(name.getRect().getDimension().getHeight());
		System.out.println(name.getRect().getDimension().getWidth());
		
	}

}
