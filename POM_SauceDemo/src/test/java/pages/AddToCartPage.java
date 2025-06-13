package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import objectRepository.Locators;
import utils.Base;
import utils.Reporter;

public class AddToCartPage {
	WebDriver driver;
	WebDriverWait wait;
	ExtentTest test;

	public AddToCartPage(WebDriver driver,ExtentTest test) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		this.test=test;
	}

	public void validateProductAdded() {
		driver.findElement(Locators.addCart).click();
		Base.sleep(2000);
		String str =driver.findElement(Locators.itemCount).getText();
		int count = Integer.parseInt(str);
		// explicit wait to verify the text "Back to products"
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".shopping_cart_badge")));
			
			Reporter.generateReport(driver, test, Status.PASS, "Item added to cart successfully");
			System.out.println("Item present in cart: "+count);
		} catch (TimeoutException te) {
			Reporter.generateReport(driver, test, Status.FAIL, "Item not added in cart");
		}
	}
}
