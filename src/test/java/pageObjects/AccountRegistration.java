package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistration extends BasePage {

	
	public AccountRegistration(WebDriver driver) {
		super(driver);
	}
	
	//Locators
	


	

	//input[@name='agree']
	//input[@value='Continue']
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement firstname;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement lastname;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement email;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement telephone;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement password;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement confirmpassword;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement agree;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement continueclick;
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement confirmationmsg;
	
	
	public void firstnameRegistor(String name) {
		firstname.sendKeys(name);		
	}
	public void lastnameRegistor(String name) {
		
		lastname.sendKeys(name);	
	}
	public void emailRegistor(String name) {
		
		email.sendKeys(name);	
	}
	public void telephoneRegistor(String name) {
	
		telephone.sendKeys(name);
	}
	public void passwordRegistor(String name) {
		
		password.sendKeys(name);
			}
	
public void confirmpasswordRegistor(String name) {
	
		confirmpassword.sendKeys(name);	
	}

	public void agreeclick() {
		agree.click();	
	}
	
	public void continueClick() {
	continueclick.click();		
	}
	
	public String getMsg() {
		
	try {
		return (confirmationmsg.getText());
	}
		catch (Exception e) {
	return (e.getMessage());
		
	}
	
	
	
	
	
	
}}
