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

public class OrderSuccessPage {
	WebDriver driver;
	WebDriverWait wait;
	ExtentTest test;
	
	public OrderSuccessPage(WebDriver driver,ExtentTest test) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		this.test=test;
	}

	public void validateOrder() {
		driver.findElement(Locators.finishBtn).click();
		Base.sleep(2000);
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Checkout: Complete!']")));
			Reporter.generateReport(driver, test, Status.PASS, "Order placed successfully");
			System.out.println("Thank you for shopping");
		} catch (TimeoutException te) {
			Reporter.generateReport(driver, test, Status.FAIL, "Order not placed");
		}
	}
}
