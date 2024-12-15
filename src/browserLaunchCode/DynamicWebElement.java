package browserLaunchCode;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicWebElement {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://practice.expandtesting.com/dynamic-loading");;
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.navigate().to("");

		Thread.sleep(2000);
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("Scroll(386, 558)");
		WebElement ele = driver.findElement(By.xpath("//a[contains(@href,'/dynamic-loading/2')]"));
		WebDriverWait w = new WebDriverWait(driver ,Duration.ofSeconds(10));
		w.until(ExpectedConditions.visibilityOf(ele));
		ele.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[contains(@class,'btn btn-primary')]")).click();
	}

}
