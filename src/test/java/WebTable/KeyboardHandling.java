package WebTable;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.locators.RelativeLocator;

public class KeyboardHandling {
	public static void main(String[]args) throws InterruptedException, AWTException
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.actitime.com/login.do");
		Thread.sleep(2000);
//		driver.findElement(By.id("username")).sendKeys("admin");
//		driver.findElement(By.cssSelector("[name='pwd']")).sendKeys("admin");
		
//		driver.findElement(RelativeLocator.with(By.name("pwd")).below(By.id("username"))).sendKeys("manager");
//		
//		driver.findElement(RelativeLocator.with(By.id("username")).above(By.name("pwd"))).sendKeys("admin");
//		WebElement table=driver.findElement(By.id("whiteBoxWithLogo"));
//		WebElement box=	table.findElement(By.id("keepLoggedInCheckBoxContainer"));
//		box.click();
//		driver.findElement(By.id("loginButton")).click();
//		
		driver.findElement(By.id("username")).sendKeys("admin",Keys.TAB);
		Robot r=new Robot();
		driver.findElement(By.name("pwd")).sendKeys("manager");
//		r.keyPress(KeyEvent.VK_TAB);
//		r.keyRelease(KeyEvent.VK_TAB);
		Actions act=new Actions(driver);
		act.keyDown(Keys.TAB).perform();
		act.keyUp(Keys.TAB).perform();
		act.keyDown(Keys.ENTER).perform();
		act.keyUp(Keys.ENTER).perform();
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
