package browserLaunchCode;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Dropdown {
	public static void main(String[]args) throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://chercher.tech/practice/practice-dropdowns-selenium-webdriver");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
//		driver.manage().window().minimize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement w = driver.findElement(By.xpath("//select[@id='first']"));
		Select s = new Select(w);
		s.selectByIndex(3);
//		select by visible text
		WebElement w1 = driver.findElement(By.xpath("(//select[contains(@class,'col-lg-3')])[2]"));
		Select s1 = new Select(w1);
		s1.selectByVisibleText("Baby Cat");
//		WebElement w3 = driver.findElement(By.xpath("(//select[contains(@class,'col-lg-3')])[3]"));
//		Select s3 = new Select(w3);
//		s3.selectByValue("Burger");
		WebElement w3 = driver.findElement(By.xpath(""));
	}

}
