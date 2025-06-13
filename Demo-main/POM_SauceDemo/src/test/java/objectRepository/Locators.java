package objectRepository;

import org.openqa.selenium.By;

public class Locators {
	//locators for login page
	public static By userName = By.id("user-name");
	public static By password = By.id("password");
	public static By loginButton = By.id("login-button");
	//locators for select product 
	public static By prodName = By.xpath("//div[text()='Sauce Labs Backpack']");
	public static By productFetchedName = By.xpath("(//div[@class=\"inventory_details_desc_container\"]/child::div)[1]");
	public static By description = By.xpath("(//div[@class=\"inventory_details_desc_container\"]/child::div)[2]");
	public static By price = By.xpath("(//div[@class=\"inventory_details_desc_container\"]/child::div)[3]");
	//locators for adding product into cart
	public static By addCart = By.id("add-to-cart");
	public static By itemCount = By.cssSelector(".shopping_cart_badge");
	//locator for cart page
	public static By cartIcon = By.cssSelector(".shopping_cart_link");
	public static By itemList = By.xpath("//div[@class='cart_list']/descendant::div[@class='inventory_item_name']");
	//locator for customer Information
	public static By checkOutButton = By.id("checkout");
	public static By firstName = By.id("first-name");
	public static By lastName = By.id("last-name");
	public static By zipCode = By.id("postal-code");
	//locator for checkout process
	public static By continueBtn = By.id("continue");
	public static By payInfo = By.xpath("(//div[@class='summary_value_label'])[1]");
	public static By shipInfo = By.xpath("(//div[@class='summary_value_label'])[2]");
	public static By total = By.cssSelector(".summary_total_label");
	//order page locators
	public static By finishBtn = By.id("finish");
	//logout page
	public static By navBtn = By.id("react-burger-menu-btn");
	public static By logoutBtn = By.id("logout_sidebar_link");
}
