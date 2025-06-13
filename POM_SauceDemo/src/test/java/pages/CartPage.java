package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import objectRepository.Locators;
import utils.Base;
import utils.Reporter;

public class CartPage {
	WebDriver driver;
	WebDriverWait wait;
	ExtentTest test;

	public CartPage(WebDriver driver,ExtentTest test) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		this.test=test;
	}

	public void validateProductInCart() {
		driver.findElement(Locators.cartIcon).click();
		Base.sleep(2000);
		// explicit wait to verify the text "Back to products"
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='title']")));
			Reporter.generateReport(driver, test, Status.PASS, "Cart page shown successfully");
			List<WebElement> item = driver.findElements(Locators.itemList);
			System.out.println("Item in cart: "+item.size());
			for(int i=0;i<item.size();i++) {
				WebElement name = item.get(i).findElement(By.xpath("(//div[@class='inventory_item_name'])["+i+1+"]"));
				System.out.println("Item list...");
				System.out.println("Item "+i+1+" "+name.getText());
			}
		} catch (TimeoutException te) {
			Reporter.generateReport(driver, test, Status.FAIL, "Cart page not Shown");
		}
	}
}
