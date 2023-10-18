package WebTable;

import java.time.Duration;

import org.apache.commons.lang3.text.translate.JavaUnicodeEscaper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScriptJava {
	public static void main(String[]args) throws InterruptedException
	{
		String message="this is a bug";
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.actitime.com/login.do");
		Thread.sleep(2000);
		WebElement un=driver.findElement(By.id("username"));
		un.sendKeys("admin",Keys.TAB);
		WebElement pwd=driver.findElement(By.name("pwd"));
		pwd.sendKeys("manager",Keys.TAB);
		WebElement ib=driver.findElement(By.id("loginButton"));
		ib.sendKeys(Keys.ENTER);
		JavascriptExecutor jse=((JavascriptExecutor)driver);
//		jse.executeScript("arguments[0].style.border='3px solid blue'", un);
//		//jse.executeScript("arguments[0].click()", un);
//		jse.executeScript("arguments[0].click()",ib);
	//jse.executeScript("alert('"+message+"');");
	String title=jse.executeScript("return document.title;").toString();
System.out.println(title);
	}

}
