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

public class CheckOutPage {
	WebDriver driver;
	WebDriverWait wait;
	ExtentTest test;
	
	public CheckOutPage(WebDriver driver,ExtentTest test) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		this.test=test;
	}

	public void validateCheckOutformatio() {
		driver.findElement(Locators.continueBtn).click();
		Base.sleep(2000);
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Checkout: Overview']")));
			String pay = driver.findElement(Locators.payInfo).getText();
			String ship = driver.findElement(Locators.shipInfo).getText();
			String total = driver.findElement(Locators.total).getText();
			Reporter.generateReport(driver, test, Status.PASS, "Check-Out page show successfully");
			System.out.println("Payment Info: "+pay);
			System.out.println("Shipping Info: "+ship);
			System.out.println(total);
		} catch (TimeoutException te) {
			Reporter.generateReport(driver, test, Status.FAIL, "Check-Out page not shown");
		}
	}
}
