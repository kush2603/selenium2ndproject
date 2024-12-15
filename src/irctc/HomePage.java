package irctc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class HomePage {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://practicesoftwaretesting.com/");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		WebElement dropDown = driver.findElement(By.xpath("//a[contains(@class,'nav-link dropdown-toggle')]"));
		dropDown.click();
		WebElement options = driver.findElement(By.xpath("(//a[contains(@class,'dropdown-item')])[2]"));
		options.click();
	   
		driver.findElement(By.xpath("(//div[@class='card-body'])[4]")).click();
		driver.findElement(By.xpath("//button[contains(@class,'btn-success btn')]")).click();
        Thread.sleep(2000);		
		
		  String actual_result = "https://practicesoftwaretesting.com/category/power-tools"; 
		  String expected_result = driver.getTitle();
		  
		
///	      
		  

		
	}

}
