package testCases;

import org.junit.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountPage;
import pageObjects.HomePage;
import pageObjects.loginPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC03_LoginDataDrivenTesting extends BaseClass{
  @Test(dataProvider ="LoginData", dataProviderClass=DataProviders.class)//getting data provider from different package from util and dataprovider class 
  public void verify_loginDDT(String email, String pwd, String exp) {
	  try {
	  HomePage hmm = new HomePage(driver);
	  hmm.selectAccount();
	  hmm.selectLogin();
	  loginPage log = new loginPage(driver);
	  log.loginAccount(email);
	  log.loginPasswordAccount(pwd);
	  log.loginClick();
	  AccountPage acct = new AccountPage(driver);
	boolean validation=  acct.logoValidation();
	  Assert.assertTrue(validation);
	  
	  if(exp.equalsIgnoreCase("valid")) {
		  if(validation==true) {
			  hmm.selectAccount();
			  hmm.selectLogout();
			  Assert.assertTrue(true);
		
		  }else {
			  Assert.assertTrue(false);
		  }  
	  }
	  if(exp.equalsIgnoreCase("invalid")) {
		  if(validation==true) {
			  hmm.selectAccount();
			  hmm.selectLogout();
			  Assert.assertTrue(false);
		
		  }else {
			  Assert.assertTrue(true);
		  }  
	  }}
	  catch(Exception e) {
		 Assert.fail();
	  }
  }}
