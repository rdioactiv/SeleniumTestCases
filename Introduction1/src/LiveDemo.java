import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class LiveDemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

		// click on veg/fruit name to sort
		// capture all webelement into list
		// capture text of all WebElements into new list
		// sort the list
		driver.findElement(By.cssSelector("th[aria-label='Veg/fruit name: activate to sort column ascending']"))
				.click();
		List<WebElement> veggies1 = driver.findElements(By.xpath("//tr/td[1]"));
		List<String> originalList = veggies1.stream().map(s -> s.getText()).collect(Collectors.toList());
		List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());
		Assert.assertTrue(originalList.equals(sortedList));

		// scan the name column with getText -> rice-> print the price
		List<String> price;
		do {
		List<WebElement> veggies = driver.findElements(By.xpath("//tr/td[1]"));
		price = veggies.stream().filter(s -> s.getText().contains("Rice")).map(s -> getPriceVeggie(s))
				.collect(Collectors.toList());
		price.forEach(s -> System.out.println(s));
		if(price.size()<1) {
			driver.findElement(By.cssSelector("a[aria-label='Next']")).click();
		}

	}while(price.size()<1);
		
	}
	private static String getPriceVeggie(WebElement s) {
		// use only sibling locator because the first path is already available in
		// WebElement s
		String priceValue = s.findElement(By.xpath("following-sibling::td[1]")).getText();

		return priceValue;
	}
	
}
