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

public class CoustomerInformationPage {
	WebDriver driver;
	WebDriverWait wait;
	ExtentTest test;
	String fname = "User";
	String lname = "Xyz";
	String pinCode = "123456";
	public CoustomerInformationPage(WebDriver driver,ExtentTest test) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		this.test=test;
	}

	public void validateUserInformatio() {
		driver.findElement(Locators.checkOutButton).click();
		Base.sleep(2000);
		// explicit wait to verify the text "Back to products"
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Checkout: Your Information']")));
			driver.findElement(Locators.firstName).sendKeys(fname);
			driver.findElement(Locators.lastName).sendKeys(lname);
			driver.findElement(Locators.zipCode).sendKeys(pinCode);
			Reporter.generateReport(driver, test, Status.PASS, "Coustomer Information added successfully");
			System.out.println("Frist name: "+fname);
			System.out.println("Last name: "+lname);
			System.out.println("Pin-Code: "+pinCode);
		} catch (TimeoutException te) {
			Reporter.generateReport(driver, test, Status.FAIL, "Coustomer information not added Shown");
		}
	}
}
