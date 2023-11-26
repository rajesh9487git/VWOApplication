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
	WebDriverWait wait;

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

		int number = seleniumhelper.generateRandomNumber();

		driver.findElement(By.id("page-v1-step1-email")).sendKeys("ra98" + number + "@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.xpath(
				"//form[@id='page-free-trial-signup-form-step1']//button[@class='button W(100%) btn-modal-form-submit']"))
				.click();

		wait = new WebDriverWait(driver, Duration.ofSeconds(600));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("page-v1-fname")));

		driver.findElement(By.id("page-v1-fname")).sendKeys("Rajesh");
		driver.findElement(By.id("page-v1-lname")).sendKeys("Rao");

		WebElement element = driver.findElement(
				By.xpath("//form[@id='page-free-trial-signup-form-step2']//div[@class='iti__selected-flag']"));

		String xpath = "//ul[@id='iti-0__country-listbox']/li";

		seleniumhelper.selectDropdown(driver, element, xpath, "India (भारत)+91");

		Thread.sleep(1000);
		driver.findElement(By.id("page-v1-pnumber")).sendKeys("9980411156");

		driver.findElement(By.id("page-v1-pwd")).sendKeys("Money4money@");

		driver.findElement(By.xpath(
				"//form[@id='page-free-trial-signup-form-step2']//button[@class='button btn-modal-form-submit W(100%)']"))
				.click();

		// Verify the account set up landing page
//		WebElement accountSetUpPage = driver.findElement(By.xpath("//*[contains(text(), 'Basic Account Setup')]"));

		wait = new WebDriverWait(driver, Duration.ofSeconds(600));
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[@id='main-container']//div[@class='setup-header D(f) Ai(c)']")));

//		Assert.assertTrue(accountSetUpPage.isDisplayed());

		WebElement text = driver
				.findElement(By.xpath("//div[@id='main-container']//div[@class='setup-header D(f) Ai(c)']"));
		String actualText = text.getText();

		System.out.println("Actual text is ===================" + actualText);

//		Assert.assertEquals(actualText, "Basic Account Setup");

		driver.findElement(By.id("account-setup-url")).sendKeys("google.com");

		WebElement trafficDropdown = driver
				.findElement(By.xpath("//*[@id=\"select-box-activator-0\"]/vwo-transclude/div/div"));

		String xpath1 = "//*[@class='Fx(equal-size-child) Miw(0) Ovy(a) dropdown-list-0']/ul/li";

		seleniumhelper.selectDropdown(driver, trafficDropdown, xpath1, "up to 50k visitors/month");
		Thread.sleep(1000);
		
		WebElement industry = driver.findElement(By.xpath("//activator[@id='select-box-activator-1']/vwo-transclude/div"));
		
		String xpath2= "//*[@id=\"atomic\"]/body/vwo-transclude[2]/menu-content/div[2]/div/div[2]/div/ul/li";
		
		seleniumhelper.selectDropdown(driver, industry, xpath2, "Entertainment");
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//*[@class='grid-container-item section-main Mb(40px) Pos(r)']//*[contains(text(),'Next')]")).click();
		
	}

	@Then("he completes email verification")
	public void he_completes_email_verification() {

	}

}
