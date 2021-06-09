package pObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CorporateWellnessLocators {
public static WebElement element;
	
	public static WebElement name(WebDriver driver)
	{
		element= driver.findElement(By.id("name"));
		return element;
	}

	public static WebElement organizationName(WebDriver driver)
	{
		element= driver.findElement(By.xpath("//input[@placeholder='Organization Name']"));
		return element;
	}

	public static WebElement officialEmailId(WebDriver driver)
	{
		element= driver.findElement(By.xpath("//input[@placeholder='Official Email ID']"));
		return element;
	}

	public static WebElement contactNumber(WebDriver driver)
	{
		element= driver.findElement(By.xpath("//input[@placeholder='Contact Number']"));
		return element;
	}
	
	public static WebElement orgSize (WebDriver driver)
	{
		element = driver.findElement(By.id("organization_size"));
		return element;
	}

	public static WebElement scheduleDemo(WebDriver driver)
	{
		element= driver.findElement(By.id("button-style"));
		return element;
	}
	

	public static WebElement successMsg(WebDriver driver)
	{
		System.out.println("this is a test");
		element = driver.findElement(By.xpath("//div[ @id = 'thankyou-section' ]"));
		return element;
	}
	
}