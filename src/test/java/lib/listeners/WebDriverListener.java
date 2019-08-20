package lib.listeners;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.testng.annotations.BeforeMethod;

public class WebDriverListener implements WebDriverEventListener {
	public  WebDriver webdriver;
	public  EventFiringWebDriver driver;
	public int i = 1;


	public void beforeAlertAccept(WebDriver driver) {
		System.out.println("Before Alert ");
		//takeSnap();
		
	}

	public void afterAlertAccept(WebDriver driver) {
		System.out.println("Alert is accepted ");//takeSnap();
	}

	public void afterAlertDismiss(WebDriver driver) {
		System.out.println("Alert is dismissed ");
		//takeSnap();
		
	}

	public void beforeAlertDismiss(WebDriver driver) {
		System.out.println("Alert is yet to dismiss ");//takeSnap();
		
	}

	public void beforeNavigateTo(String url, WebDriver driver) {
		System.out.println("before navigate to "+driver.getCurrentUrl());
		//takeSnap();
		
	}

	public void afterNavigateTo(String url, WebDriver driver) {
		System.out.println("Page is navigated to "+driver.getCurrentUrl());
		//takeSnap();
		
	}

	public void beforeNavigateBack(WebDriver driver) {
		System.out.println("Page is yet to navigate back from history to "+driver.getCurrentUrl());
		//takeSnap();
	}

	public void afterNavigateBack(WebDriver driver) {
		System.out.println("Page is navigated back from history to "+driver.getCurrentUrl());
		//takeSnap();
	}

	public void beforeNavigateForward(WebDriver driver) {
		System.out.println("Page is navigated forward to "+driver.getTitle());
		takeSnap();
		
	}

	public void afterNavigateForward(WebDriver driver) {
		System.out.println("Page is navigated forwar to "+driver.getTitle());
		takeSnap();
	}

	public void beforeNavigateRefresh(WebDriver driver) {
		System.out.println("Page is yet to refresh");
		//takeSnap();
		
	}

	public void afterNavigateRefresh(WebDriver driver) {
		System.out.println("Page is refreshed");
		//takeSnap();
		
	}

	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println(element+ " element is yet to find");
		//takeSnap();
		
	}

	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println(element+ " element found");
		//takeSnap();
	}

	public void beforeClickOn(WebElement element, WebDriver driver) {
		System.out.println(element+ " is yet to click");
		//takeSnap();
		
	}

	public void afterClickOn(WebElement element, WebDriver driver) {
		System.out.println(element+ " is clicked successfully");
		//takeSnap();
	}

	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		// TODO Auto-generated method stub
		
	}

	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		// TODO Auto-generated method stub
		
	}

	public void beforeScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void beforeSwitchToWindow(String windowName, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterSwitchToWindow(String windowName, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void onException(Throwable throwable, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}
	public long takeSnap() {

		long number = (long) Math.floor(Math.random() * 900000000L) + 10000000L;
		try {
			FileUtils.copyFile(driver.getScreenshotAs(OutputType.FILE) , new File("./output/images/"+number+".png"));
		} catch (WebDriverException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return number;
	}

}
