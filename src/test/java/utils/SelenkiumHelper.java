package utils;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SelenkiumHelper {

	
	public void selectDropdown(WebDriver driver,  WebElement dropdown, String xpath, String toBeSelected) throws InterruptedException {
		
		
		dropdown.click();
		Thread.sleep(2000);
		
		List<WebElement> trafficDropdownValue = driver
				.findElements(By.xpath(xpath));

		
		for (WebElement country : trafficDropdownValue) {

			System.out.println(country.getText());  
			
			if(country.getText().trim().contains(toBeSelected)) {
				
				country.click();
				break;
			}

		}
		
		
	}
	
	public int generateRandomNumber() {
		
		int number;
		
		Random random= new Random();
		
		number=random.nextInt(1000);
		return number;
		
		
	}
}
