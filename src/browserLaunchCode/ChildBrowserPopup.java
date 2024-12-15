package browserLaunchCode;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ChildBrowserPopup {
	
	public static void main(String[]args)
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.naukri.com/");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//div[text()='Services']")).click();
		Set<String> all_ids = driver.getWindowHandles();
		ArrayList<String> al = new ArrayList<String>(all_ids);
		driver.switchTo().window(al.get(1));
		
//		actions method move to element
		WebElement w = driver.findElement(By.xpath("(//span[@class='gnbLabel'])[1]"));
		Actions a = new Actions(driver);
		a.moveToElement(w).perform();
		driver.findElement(By.xpath("(//div[@class='mainHead'])[3]")).click();
		
	}

}
