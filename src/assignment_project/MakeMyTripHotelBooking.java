
	package assignment_project;

	import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

	public class MakeMyTripHotelBooking {

	    public static void main(String[] args) throws InterruptedException {
	        
	        ChromeOptions options = new ChromeOptions();
	        options.addArguments("--incognito");
	        WebDriver driver = new ChromeDriver(options);
	        
	        // WebDriverWait setup
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

	        // Open MakeMyTrip website
	        driver.get("https://www.makemytrip.com/");
	        driver.manage().window().maximize();
	        Thread.sleep(3000);
	      WebElement closeBtn = driver.findElement(By.xpath("//span[@class='commonModal__close']"));
          closeBtn.click();
	        // Close the initial pop-up if it appears
	       WebElement clickOnLoginLink = driver.findElement(By.xpath("//p[text()='Login or Create Account']"));
           clickOnLoginLink.click();
           Thread.sleep(2000);
	       WebElement enterMobileNumber = driver.findElement(By.xpath("//input[@class='font14 fullWidth']"));
	       enterMobileNumber.sendKeys("9140336215");
	       Thread.sleep(2000);
	       
	       driver.switchTo().frame(0);
	       WebElement clickOnGoogleLogo = driver.findElement(By.xpath("//div[@class='nsm7Bb-HzV7m-LgbsSe-Bz112c']"));
	       clickOnGoogleLogo.click();

	       Set<String> all_ids = driver.getWindowHandles();
	       ArrayList <String> al = new ArrayList<>(all_ids);
	       String parent_window = al.get(0);//parent window
	       String child_window = al.get(1);
	       driver.switchTo().window(child_window);
           driver.findElement(By.xpath("(//input[@class='whsOnd zHQkBf'])[1]")).sendKeys("tautomation768@gmail.com");
           driver.findElement(By.xpath("(//span[@class='VfPpkd-vQzf8d'])[2]")).click();
           Thread.sleep(2000);
          
           //explicitWait
           WebElement password = driver.findElement(By.xpath("//input[@name='Passwd']"));
           WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(5));
           w.until(ExpectedConditions.visibilityOf(password));
           password.sendKeys("Automation@Tester123");
           Thread.sleep(2000);
           driver.findElement(By.xpath("(//span[@class='VfPpkd-vQzf8d'])[2]")).click();
           Thread.sleep(2000);
           

           driver.switchTo().window(parent_window);
           Thread.sleep(2000);
          // driver.findElement(By.xpath("//div[contains(@class,'modal displayBlock modalResetPass')]")).click();
//           driver.findElement(By.xpath("//span[text()='Not now']")).click();
////         explicitWait
//           WebElement close_btn = driver.findElement(By.xpath("//span[contains(@class,'mybizLoginClose')]"));
//           WebDriverWait w1 = new WebDriverWait(driver,Duration.ofSeconds(5));
//           w1.until(ExpectedConditions.visibilityOf(close_btn));
//           close_btn.click();
           
           
           
           //fluentWait
           FluentWait<WebDriver> w2 = new FluentWait<>(driver);
           w2.withTimeout(Duration.ofSeconds(30));
           w2.pollingEvery(Duration.ofSeconds(5));
           w2.ignoring(Exception.class);
           WebElement close_btn = driver.findElement(By.xpath("//div[contains(@class,'modal displayBlock modalResetPass')]"));
           close_btn.click();
           
	        // Enter login details (replace with your own credentials)
	        try {
	            WebElement emailInput = wait.until(ExpectedConditions.elementToBeClickable(By.id("username")));
	            emailInput.sendKeys("navaleg299@gmail.com");

	            WebElement continueButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-cy='continueBtn']")));
	            continueButton.click();

	            WebElement passwordInput = wait.until(ExpectedConditions.elementToBeClickable(By.id("password")));
	            passwordInput.sendKeys("Sangamner123@");

	            WebElement loginSubmit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-cy='loginBtn']")));
	            loginSubmit.click();
	        } catch (Exception e) {
	            System.out.println("Issue during login: " + e.getMessage());
	        }

	        // Wait for the login process to complete
	        wait.until(ExpectedConditions.urlContains("makemytrip.com"));

	        // Click on the Hotels tab
	        try {
	            WebElement hotelTab = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@data-cy='menu_Hotels']")));
	            hotelTab.click();
	        } catch (Exception e) {
	            System.out.println("Hotels tab click failed: " + e.getMessage());
	        }

	        // Enter destination
	        try {
	            WebElement destinationInput = wait.until(ExpectedConditions.elementToBeClickable(By.id("city")));
	            destinationInput.click();
	            destinationInput.sendKeys("Mumbai");

	            // Select a suggested location
	            WebElement firstSuggestion = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[contains(text(),'Mumbai, Maharashtra')]")));
	            firstSuggestion.click();
	        } catch (Exception e) {
	            System.out.println("Error selecting destination: " + e.getMessage());
	        }

	        // Select check-in and check-out dates (update date values as needed)
	        try {
	            WebElement checkInDate = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@aria-label='Sat Sep 23 2024']")));
	            checkInDate.click();

	            WebElement checkOutDate = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@aria-label='Tue Sep 26 2024']")));
	            checkOutDate.click();
	        } catch (Exception e) {
	            System.out.println("Date selection error: " + e.getMessage());
	        }

	        // Click the 'Search' button
	        try {
	            WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-cy='searchHotelBtn']")));
	            searchButton.click();
	        } catch (Exception e) {
	            System.out.println("Search button click failed: " + e.getMessage());
	        }

	        // Wait for the search results to load
	        try {
	            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("hotelListingContainer")));

	            // Select the first hotel in the list
	            WebElement firstHotel = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='hotelListingContainer']//div[1]")));
	            firstHotel.click();

	            // Switch to the hotel details window
	            for (String winHandle : driver.getWindowHandles()) {
	                driver.switchTo().window(winHandle);
	            }

	            // Click on the 'Book Now' button
	            WebElement bookNowButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'BOOK THIS NOW')]")));
	            bookNowButton.click();
	        } catch (Exception e) {
	            System.out.println("Error selecting hotel or booking: " + e.getMessage());
	        }

	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        // Close the browser session after completion
//	        driver.quit();
	    }
	}
	
