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

public class SelectProductPage {
	WebDriver driver;
	WebDriverWait wait;
	ExtentTest test;

	public SelectProductPage(WebDriver driver,ExtentTest test) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		this.test=test;
	}

	public void validateProductDisplay() {
		driver.findElement(Locators.prodName).click();
		Base.sleep(2000);
		
		// explicit wait to verify the text "Back to products"
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("back-to-products")));
			Reporter.generateReport(driver, test, Status.PASS, "Product Description Shown Successfully");
			/*
			 * just for learning purpose
			 */
			System.out.println("Selected product details...");
			System.out.println("Product Name: "+driver.findElement(Locators.productFetchedName).getText());
			System.out.println("Product Description: "+driver.findElement(Locators.description).getText());
			System.out.println("Product Price: "+driver.findElement(Locators.price).getText());
		} catch (TimeoutException te) {
			Reporter.generateReport(driver, test, Status.FAIL, "Product Description Not Shown");
		}
	}
}
