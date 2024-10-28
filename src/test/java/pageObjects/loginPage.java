package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginPage extends BasePage{

	
	public loginPage(WebDriver driver) {
		super(driver);
		
	}


	

//loctors
	@FindBy(xpath="//input[@id='input-email']")
	WebElement loginEmail;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement loginPassword;
	@FindBy(xpath="//input[@value='Login']")
	WebElement loginbtn;
	

	public void loginAccount (String name) {
		loginEmail.sendKeys(name);
	}
	public void loginPasswordAccount (String name) {
		loginPassword.sendKeys(name);
	}
	public void loginClick () {
		loginbtn.click();
	}
}
