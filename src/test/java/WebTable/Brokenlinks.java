package WebTable;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.bytebuddy.description.annotation.AnnotationList.Empty;

public class Brokenlinks {
	
static int respCode;
	//static String url="";
	public static void main(String[]args) throws InterruptedException, IOException
	{
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.actitime.com/login.do");
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.name("pwd")).sendKeys("manager",Keys.ENTER);
		Thread.sleep(3000);
//		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
//		wait.until(ExpectedConditions.titleContains("actiTIME -  Enter Time-Track"));
		List<WebElement> links=driver.findElements(By.xpath("//a"));
		System.out.println(links.size());
//		
		Iterator<WebElement> link=links.iterator();
		while(link.hasNext())
	
			 {
			Thread.sleep(5000);
			String 	url=link.next().getAttribute("href");
				 System.out.println(url);
				if(url!=null &&!(url.isEmpty()))
				{
					continue;
				}
				
			 HttpURLConnection httpcon=(HttpURLConnection)(new URL(url).openConnection());

			 httpcon.setRequestMethod("HEAD");

			 httpcon.connect();

			 int respCode =httpcon.getResponseCode();
				 
			 if(respCode >= 400){
			 System.out.println(url +"-------> is a broken link");
			 }
			 else{
			 System.out.println(url+"-------> is a valid link");
			 }
				}
			 }
		}

	
		
		
	


