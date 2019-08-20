package testcase.Mercury_TwoWay;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import lib.listeners.WebDriverListener;
import lib.selenium.NewTest;

public class BookTwoWay extends NewTest {
	
	@Test
	public void twoWay() {

		
		driver.findElement(By.xpath("//input[@value='roundtrip']")).click();
		
		Select sl=new Select(driver.findElement(By.name("passCount")));
		sl.selectByValue("3");
		Select fromPort= new Select(driver.findElement(By.name("fromPort")));
		Select toPort= new Select(driver.findElement(By.name("toPort")));
		Select toMonth= new Select(driver.findElement(By.name("toMonth")));
		Select toDay= new Select(driver.findElement(By.name("toDay")));
		
		fromPort.selectByVisibleText("London");
		
		toMonth.selectByIndex(6);
		toDay.selectByVisibleText("1");
		
		driver.findElement(By.xpath("(//*[@name='servClass']//following::input)[1]")).click();
		driver.findElement(By.name("findFlights")).click();
		
		//*webTable ((//tbody)[9]//td//font[text()='DEPART'])[2]
		List<WebElement> rows=driver.findElements(By.xpath("(//tbody)[9]//tr"));
		System.out.println(rows.size());
		String arr[]=new String[rows.size()/3];
		int j=0;
		for(int i=3;i<=rows.size()-3;i=i+2) {
			String text = driver.findElement(By.xpath("(//tbody)[9]//tr["+i+"]/td[3]//font")).getText();
			arr[j]=	text.replaceAll(":","");
			
			//System.out.println(arr[j]);
			j++;
		
		}
		
		Arrays.sort(arr, new Comparator<String>()
	    {
	      public int compare(String s1, String s2)
	      {
	        return Integer.
	        		valueOf(s1).compareTo(Integer.valueOf(s2));
	      }
	    });
			System.out.println(rows.size());
				for(int x =3;x<=rows.size()-3;x=x+2) {
				String rowValue=driver.findElement(By.xpath("(//tbody)[9]//tr["+x+"]/td[3]//font")).getText();
				System.out.println(rowValue.replaceAll(":", ""));
				 if(rowValue.replaceAll(":", "").equals(arr[arr.length-1])) {
					 System.out.println("d");
					 driver.findElement(By.xpath("(//tbody)[9]//tr["+x+"]/td[1]//input[@type='radio']")).click();
					 
				 }	}
				
				driver.findElement(By.name("reserveFlights")).click();
				driver.findElement(By.name("buyFlights")).click();	
			
		
		
	}

}
