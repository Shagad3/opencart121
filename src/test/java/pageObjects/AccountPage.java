package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends BasePage {

	
	
	public AccountPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

//loctors
	@FindBy(xpath="//h2[normalize-space()='My Account']")
	WebElement logo;
	

	public  boolean logoValidation () {
		try {
		
			return (logo.isDisplayed());
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			Assert.fail();
			return false;
		}
	
	}
	
	
}
