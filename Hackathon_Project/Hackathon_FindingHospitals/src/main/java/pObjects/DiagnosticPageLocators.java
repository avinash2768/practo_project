package pObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DiagnosticPageLocators {
	public static WebElement element;
	public static WebDriver driver;
	
	public static WebElement searchCity(WebDriver driver)
	{
		element= driver.findElement(By.xpath("//input[@id='locationInput']"));
		return element;
	}
	public static WebElement diagnostics(WebDriver driver)
	{
		element= driver.findElement(By.xpath("//div[@class='product-tab__title'][text()='Diagnostics']"));
		return element;
	}
	public static List<WebElement> topCities(WebDriver driver)
	{
		System.out.println("hello");
		System.out.println("hi there");
		System.out.println("this is a test");
		System.out.println("this is a test");
		List<WebElement> cities= driver.findElements(By.xpath("//ul/li/div[2]"));
		return cities;
	}
        
}
