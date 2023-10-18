package WebTable;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.PublicKey;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.compress.harmony.unpack200.bytecode.CodeAttribute;
import org.apache.hc.core5.http.HttpConnection;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.github.dockerjava.transport.DockerHttpClient.Response;

public class Broken{
   static HttpURLConnection httpConn;
   static String url="";


	public static void main(String[]args) throws IOException, InterruptedException
{
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.flipkart.com/");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='✕']")).click();
//		driver.findElement(By.id("username")).sendKeys("admin");
//		driver.findElement(By.name("pwd")).sendKeys("manager",Keys.ENTER);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		List<WebElement> links=driver.findElements(By.xpath("//a"));
		System.out.println(links.size());
		Iterator<WebElement> link=links.iterator();		
		while(link.hasNext())
		{
			url=link.next().getAttribute("href");
			
			if(url==null)
			{
				System.out.println("link is not configured");
			}else {
				HttpURLConnection httpconn=(HttpURLConnection) (new URL(url).openConnection());
				httpconn.setRequestMethod("HEAD");
				httpconn.connect();
				int code=httpconn.getResponseCode();
				System.out.println("response code is----->"+ code);
				
				if(code>=400)
				{
					System.out.println("link is invalid"+url);
					
				}else {
					System.out.println(code+"----->link is valid----->"+url);
				}
			}
			
		}
		}
}
