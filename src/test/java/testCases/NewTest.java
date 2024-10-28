package testCases;

import org.testng.annotations.Test;

import pageObjects.HomePage;
import testBase.BaseClass;

public class NewTest extends  BaseClass{
  @Test
  public void f() {
	  HomePage hmm = new HomePage(driver);
	  hmm.selectAccount();
	  System.out.print("hello");
  }
}
