package dryTestNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class testNG {
 
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("In before Method");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("In After Method");
  }


  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { 1, "a" },
      new Object[] { 2, "b" },
    };
  }
  @BeforeClass
  public void beforeClass() {
	  System.out.println("In before Class");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("In After class");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("In before Test");
  }

  @AfterTest
  public void afterTest() {  System.out.println("In After test");
  }

  @BeforeSuite
  public void beforeSuite() {  System.out.println("In before Suite");
  }

  @AfterSuite
  public void afterSuite() {  System.out.println("In after Suite");
  }

}
