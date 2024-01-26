package seleniumPractice;

import java.util.List;
import java.lang.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestive {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"D:\\Eclipse Again\\VWOLogin\\src\\test\\resources\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get(
				"https://www.amazon.in/?tag=googmantxtmob170-21&ascsubtag=_k_Cj0KCQiAtaOtBhCwARIsAN_x-3JtVzGf8Mt5RsWy5nHHE7fmk3MH7LkJifuq21t1IVYf917dFZuxRVUaAkp3EALw_wcB_k_");
		Thread.sleep(2000);
		driver.manage().window().maximize();

		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("phone");
		Thread.sleep(2000);

		List<WebElement> auto = driver.findElements(By.xpath("//div[@class='left-pane-results-container']/div"));

		for (int i = 0; i < auto.size(); i++) {

			String text = auto.get(i).getText();

			System.out.println(text);

			if (text.contains("stand")) {

				auto.get(i).click();
				break;
			}
		}

	}

}
