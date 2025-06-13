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

public class LogoutPage {
	WebDriver driver;
	WebDriverWait wait;
	ExtentTest test;
	
	public LogoutPage(WebDriver driver,ExtentTest test) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		this.test=test;
	}

	public void validateLogOut() {
		driver.findElement(Locators.navBtn).click();
		driver.findElement(Locators.logoutBtn).click();
		Base.sleep(2000);
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-button")));
			Reporter.generateReport(driver, test, Status.PASS, "Logout successfully");
		} catch (TimeoutException te) {
			Reporter.generateReport(driver, test, Status.FAIL, "Logout not successfully");
		}
	}
}
