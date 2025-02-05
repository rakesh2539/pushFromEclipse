package testpackage;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DropdwonTest {
	
	
	public static void main(String[] args) {
		
		
		 WebDriver driver = new ChromeDriver();

	        try {
	            // Navigate to the test page
	            driver.get("https://testautomationpractice.blogspot.com/");

	            // Wait for the dropdown to be clickable
	            WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	            WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='comboBox']")));
	            
	            // Click to expand the dropdown
	            dropdown.click();

	            // Locate the dropdown options
	            List<WebElement> listOfOptions = driver.findElements(By.xpath("//*[@id='dropdown']//div")); // Adjust the XPath to match your DOM structure

	            // Extract text from each option
	            List<String> optionTexts = new ArrayList<>();
	            for (WebElement option : listOfOptions) {
	                optionTexts.add(option.getText().trim());
	            }

	            // Create a sorted copy of the option texts
	            List<String> sortedOptionTexts = new ArrayList<>(optionTexts);
	            Collections.sort(sortedOptionTexts);

	            // Compare the original list with the sorted list
	            if (optionTexts.equals(sortedOptionTexts)) {
	                System.out.println("The dropdown options are in ascending order.");
	            } else {
	                System.out.println("The dropdown options are NOT in ascending order.");
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            // Quit the driver
	            driver.quit();
	        }
	    }
}