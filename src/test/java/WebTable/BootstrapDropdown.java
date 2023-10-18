package WebTable;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BootstrapDropdown {
	
public static void main(String[]args)
{
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://getbootstrap.com/docs/5.3/components/dropdowns/");
	JavascriptExecutor jse=((JavascriptExecutor)driver);
	WebElement dropdown=driver.findElement(By.xpath("(//button[@class='btn btn-primary dropdown-toggle'])[1]"));
	jse.executeScript("arguments[0].scrollIntoView(true)", dropdown);
	String color=dropdown.getCssValue("color");
	//System.out.println(dropdown.getAttribute("backgroundcolor"));
	System.out.println("the color is---->"+ color);
	dropdown.click();
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

}
