package browserLaunchCode;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TagNames {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.icicibank.com");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		List<WebElement> li = driver.findElements(By.tagName("span"));
		System.out.println(li.size());
		
		for(int i = 0; i < li.size(); i++)
		{
			System.out.println(li.get(i).getText());
		}
		
		driver.close();
		
	}

}
