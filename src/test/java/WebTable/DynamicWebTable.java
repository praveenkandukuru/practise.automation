package WebTable;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicWebTable {
	public static void main(String[] args)
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://demo.actitime.com/login.do");
		driver.findElement(By.id("APjFqb")).sendKeys("mission");
		 List<WebElement> suggs=driver.findElements(By.xpath("//div[@class='mkHrUc']//li"));
		// List<WebElement> sugg=suggs.findElements(By.xpath("//li"));
		System.out.println(suggs.size());
		for(WebElement sugg: suggs)
		{
			System.out.println(sugg.getText());
			System.out.println();
		}
	}
	

}
