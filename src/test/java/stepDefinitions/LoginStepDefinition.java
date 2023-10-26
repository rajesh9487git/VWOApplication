package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.SelenkiumHelper;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginStepDefinition {

	WebDriver driver;

	@Given("User is launching the browser and opening the url")
	public void user_is_launching_the_browser_and_opening_the_url() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"D:\\Eclipse Again\\VWOLogin\\src\\test\\resources\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.navigate().to("https://app.vwo.com/#/login");

		driver.manage().window().maximize();
		Thread.sleep(1000);

		driver.findElement(By.linkText("Start a free trial")).click();

	}

	@When("he enters all the form details and provides email id")
	public void he_enters_all_the_form_details_and_provides_email_id() throws InterruptedException {
		
		SelenkiumHelper seleniumhelper = new SelenkiumHelper();
		
		int number=seleniumhelper.generateRandomNumber();

		driver.findElement(By.id("page-v1-step1-email")).sendKeys("ra98"+number+"@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.xpath(
				"//form[@id='page-free-trial-signup-form-step1']//button[@class='button W(100%) btn-modal-form-submit']"))
				.click();
		Thread.sleep(2000);
		driver.findElement(By.id("page-v1-fname")).sendKeys("Rajesh");
		driver.findElement(By.id("page-v1-lname")).sendKeys("Rao");

		WebElement element = driver.findElement(
				By.xpath("//form[@id='page-free-trial-signup-form-step2']//div[@class='iti__selected-flag']"));

		List<WebElement> countries = driver.findElements(By.xpath("//ul[@id='iti-0__country-listbox']/li"));

		

		seleniumhelper.selectDropdown(driver, element, countries, "India (भारत)+91");

		Thread.sleep(1000);
		driver.findElement(By.id("page-v1-pnumber")).sendKeys("9980411156");

		driver.findElement(By.id("page-v1-pwd")).sendKeys("Money4money@");

		driver.findElement(By.xpath(
				"//form[@id='page-free-trial-signup-form-step2']//button[@class='button btn-modal-form-submit W(100%)']"))
				.click();

		// Verify the account set up landing page
//		WebElement accountSetUpPage = driver.findElement(By.xpath("//*[contains(text(), 'Basic Account Setup')]"));

		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(180));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='main-container']//div[@class='setup-header D(f) Ai(c)']")));
		
//		Assert.assertTrue(accountSetUpPage.isDisplayed());
		
		WebElement text= driver.findElement(By.xpath("//div[@id='main-container']//div[@class='setup-header D(f) Ai(c)']"));
		String actualText= text.getText();
		
		System.out.println("Actual text is ==================="+ actualText);
		
//		Assert.assertEquals(actualText, "Basic Account Setup");
		
		driver.findElement(By.id("account-setup-url")).sendKeys("google.com");
		
		WebElement trafficDropdown=  driver.findElement(By.xpath("//*[@id=\"select-box-activator-0\"]/vwo-transclude/div/div"));
//		trafficDropdown.click();
		trafficDropdown.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		trafficDropdown.sendKeys(Keys.ARROW_DOWN);
		trafficDropdown.sendKeys(Keys.ARROW_DOWN);
		trafficDropdown.sendKeys(Keys.ENTER);
		
		
//	List<WebElement> trafficDropdownValue= driver.findElements(By.xpath("//*[@class='Fx(equal-size-child) Miw(0) Ovy(a) dropdown-list-0']/ul"));
		
//		driver.findElement(By.xpath("//*[@id=\"select-box-next-option-3-2\"]/div/vwo-transclude/option-slot")).click();
//		
//		Actions action = new Actions(driver);
//		
//		action.moveToElement(trafficDropdown).click().perform();
//		Thread.sleep(2000);
//		
		
		
//		for(WebElement values:trafficDropdownValue) {
//			
//			System.out.println(values.getText());
//			
//			System.out.println("after printing the values===========");
////			
//			if(values.getText().equalsIgnoreCase("up to 200k visitors/month")){
//				
//				System.out.println("Before clicking ===============");
//				
//				values.click();
//				
//				System.out.println("After clicking ===============");
//				break;
//			}else {
//				
//				System.out.println("It is not going to the if statement========");
//				
//			}
//		}
////		
		
//		seleniumhelper.selectDropdown(driver, trafficDropdown, trafficDropdownValue, "up to 10k visitors/month");
		
//		for(int i=0;i<trafficDropdownValue.size();i++) {
//			
//			
//			if(trafficDropdownValue.get(i).getText().equals("up to 50k visitors/month")) {
//				
//				trafficDropdownValue.get(i).click();
//				break;
//				
//			}
//		}
		

	}

	@Then("he completes email verification")
	public void he_completes_email_verification() {

	}

}
