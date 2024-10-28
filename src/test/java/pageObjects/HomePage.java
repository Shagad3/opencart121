package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	
	
	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

//loctors
	@FindBy(xpath="//span[@class='caret']")
	WebElement account;
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Register']")
	WebElement registor;
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']")
	WebElement login;
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Logout']")
	WebElement logout;
	

	public void selectAccount () {
		account.click();
	}
	
	public void selectRegistor () {
		registor.click();
		
	}
	public void selectLogin () {
		login.click();
		
	}
	
	public void selectLogout () {
		logout.click();
		
	}
}
