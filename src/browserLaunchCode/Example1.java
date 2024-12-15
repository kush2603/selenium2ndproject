package browserLaunchCode;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Example1 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver.findElement(By.xpath("(//a[@class='gb_I'])[1]")).click();		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//textarea[@class='gLFyf']")).sendKeys("amazon" +Keys.ENTER);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Shop online at Amazon India']")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone"+Keys.ENTER);
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[text()='Apple iPhone 15 (128 GB) - Black'])[1]")).click();
		//switch control from parent to child window
		Set<String> all_ids = driver.getWindowHandles();
		ArrayList<String> al = new ArrayList<String>(all_ids);
		driver.switchTo().window(al.get(1));
		System.out.println(driver.getTitle());
		driver.switchTo().window(al.get(0));
		Thread.sleep(2000);
        //parent window
		driver.findElement(By.id("twotabsearchtextbox")).clear();
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus"+Keys.ENTER);
		driver.findElement(By.xpath("//span[text()='OnePlus Nord CE 3 Lite 5G (Pastel Lime, 8GB RAM, 128GB Storage)']")).click();
		
//		driver.navigate().ba
//		driver.switchTo().fr
		
		
		
		

	}

}
