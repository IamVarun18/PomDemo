package tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import pages.AddToCartPage;
import pages.CartPage;
import pages.CheckOutPage;
import pages.CoustomerInformationPage;
import pages.LoginPage;
import pages.LogoutPage;
import pages.OrderSuccessPage;
import pages.SelectProductPage;
import utils.Base;

public class PlaceOrderTest extends Base {
	ExtentSparkReporter spark;
	ExtentReports extReports;
	ExtentTest test;

	@BeforeClass
	public void setUpReports() {
		spark = new ExtentSparkReporter("reports\\ExtentReport.html");
		extReports = new ExtentReports();
		extReports.attachReporter(spark);
	}

	@AfterClass
	public void writeReports() {
		extReports.flush();
	}

	@Test
	public void testPlaceOrder() {
		// create step 1 in extent report
		test = extReports.createTest("Place order");
		// 1. perform login operation and validate
		LoginPage loginPage = new LoginPage(driver,test);
		loginPage.validateLogin("standard_user", "secret_sauce");
		// 2. click on the product and validate
		SelectProductPage selectProduct = new SelectProductPage(driver, test);
		selectProduct.validateProductDisplay();
		// 3. click add to cart button and validate
		AddToCartPage addProduct = new AddToCartPage(driver,test);
		addProduct.validateProductAdded();
		//4. click on cart icon and vaildate
		CartPage cart = new CartPage(driver,test);
		cart.validateProductInCart();
		//5. user information page validation
		CoustomerInformationPage cip = new CoustomerInformationPage(driver, test);
		cip.validateUserInformatio();
		//6. checkout page validation
		CheckOutPage cop = new CheckOutPage(driver, test);
		cop.validateCheckOutformatio();
		//7. order confirm page validation
		OrderSuccessPage osp = new OrderSuccessPage(driver, test);
		osp.validateOrder();
		//8. logout
		LogoutPage logOut = new LogoutPage(driver, test);
		logOut.validateLogOut();
	}

	@BeforeMethod
	public void beforeMethod() {
		// to launch browser
		System.out.println("Test Started");
		launchBrowser();
		
	}

	@AfterMethod
	public void afterMethod() {
		sleep(2000);
		driver.quit();
	}

	@DataProvider
	public Object[][] dp() {
		return new Object[][] { new Object[] { 1, "a" }, new Object[] { 2, "b" }, };
	}

}
