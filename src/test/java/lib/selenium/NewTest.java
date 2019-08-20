package lib.selenium;

import org.testng.annotations.Test;

import lib.listeners.WebDriverListener;
import testcase.Mercury_TwoWay.BookTwoWay;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class NewTest extends WebDriverListener{
 
	
  @BeforeMethod
  @Parameters ("URL")	
  public void beforeMethod(String URL) {
	  System.setProperty("webdriver.chrome.driver", "./src/drivers/chromedriver.exe");
		webdriver = new ChromeDriver();

		driver = new EventFiringWebDriver(webdriver);
		//registering this clss by obj
		/*BookTwoWay handler1=new BookTwoWay();
		driver.register(handler1);*/

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.navigate().to(URL);
		
		driver.findElement(By.name("userName")).sendKeys("mercury");
		driver.findElement(By.name("password")).sendKeys("mercury");
		driver.findElement(By.name("login")).click();
	  
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("entering after method");
	  driver.close();
  }


  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { 1, "a" },
      new Object[] { 2, "b" },
    };
  }
  @BeforeClass
  public void beforeClass() {  System.out.println("entering before class");
  }

  @AfterClass
  public void afterClass() {  System.out.println("entering after class");
  }

  @BeforeTest
  public void beforeTest() {  System.out.println("entering befor test");
  }

  @AfterTest
  public void afterTest() {  System.out.println("entering after test");
  }

  @BeforeSuite
  public void beforeSuite() {  System.out.println("entering Before Suite");
  }

  @AfterSuite
  public void afterSuite() {  System.out.println("entering after Suite");
  }

}
