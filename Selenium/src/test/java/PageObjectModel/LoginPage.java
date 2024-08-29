package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
//		this.driver = driver; // Assign the driver
	}

	// Locators
	By txt_username_loc = By.xpath("//input[@placeholder='Username']");
	By txt_Password_loc = By.xpath("//input[@placeholder='Password']");
	By txt_Sbt_loc = By.xpath("//button[normalize-space()='Login']");

	// Actions
	public void SetUserName(String User) {
		driver.findElement(txt_username_loc).sendKeys(User);
	}

	public void SetPassword(String pwd) {
		driver.findElement(txt_Password_loc).sendKeys(pwd);
	}

	public void ClickLogin() {
		driver.findElement(txt_Sbt_loc).click();
	}

}
