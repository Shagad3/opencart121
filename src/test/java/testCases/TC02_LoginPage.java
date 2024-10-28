package testCases;



import org.junit.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountPage;
import pageObjects.HomePage;
import pageObjects.loginPage;
import testBase.BaseClass;

public class TC02_LoginPage extends BaseClass{
  @Test (groups={"Regression"})
  public void loginAppliation() throws Throwable {
	  

	  
	  HomePage hmm = new HomePage(driver);
	  hmm.selectAccount();
	  hmm.selectLogin();
	  loginPage log = new loginPage(driver);
	  log.loginAccount(p.getProperty("email"));
	  log.loginPasswordAccount(p.getProperty("password"));
	  log.loginClick();
	  AccountPage acct = new AccountPage(driver);
	  boolean validation= acct.logoValidation();
	  Assert.assertTrue(validation);
	  hmm.selectAccount();
	  hmm.selectLogout();

  }
}
