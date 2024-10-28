package testCases;

import org.junit.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistration;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC01_AccountRegistration extends  BaseClass{
  //crossbrowser testing is performed forlder save in test output
	
	@Test (groups = {"Sanity"})
  public void registorDeatils() {
	  HomePage hom =new HomePage(driver);
	  hom.selectAccount();
	  hom.selectRegistor();
	  AccountRegistration acct =new AccountRegistration(driver);
	  
	  acct.firstnameRegistor(randomeString().toUpperCase());
	  acct.lastnameRegistor(randomeString().toUpperCase());
	  acct.emailRegistor(randomeString()+"@gmail.com");
	  acct.telephoneRegistor(randomenumber());
	  String password = randomeStringpassword();
	  System.out.println(password);
	  acct.passwordRegistor(password);
	  acct.confirmpasswordRegistor(password);
	  acct.agreeclick();
	  acct.continueClick();
	  String  msg = acct.getMsg();
	  Assert.assertEquals(msg, "Your Account Has Been Created!");
	  
  }
}
