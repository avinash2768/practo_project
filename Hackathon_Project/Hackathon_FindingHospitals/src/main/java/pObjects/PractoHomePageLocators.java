package pObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PractoHomePageLocators {
	public static WebElement element;
	public static List<WebElement> elements;

	public static WebElement searchCity(WebDriver driver) {

		element = driver.findElement(By.xpath("//input[ @data-qa-id = 'omni-searchbox-locality' ]"));
		return element;
	}

	public static WebElement cityElement(WebDriver driver) {

		// element = driver.findElement(By.xpath("//div[ @data-qa-id = 'omni-suggestion-entire-city' ]"));   WHEN CURRENT CITY IS SAME AS LOCATION
		element = driver.findElement(By.xpath("//div[ @data-qa-id = 'omni-suggestion-main' ]"));
		return element;
	}

	public static WebElement searchBox(WebDriver driver) {
		element = driver.findElement(By.xpath("//input[ @data-qa-id = 'omni-searchbox-keyword' ]"));
		return element;
	}

	public static List<WebElement> searchElement(WebDriver driver) {
		elements = driver.findElements(By.xpath("//div[ @data-qa-id = 'omni-suggestion-main' ]"));
		return elements;
	}

	public static WebElement forProviders(WebDriver driver) {
		element = driver.findElement(By.xpath("//span[@class='u-d-item up-triangle'][text()='For Providers']"));
		return element;
	}

	public static WebElement corporateWellness(WebDriver driver) {
		element = driver.findElement(By.xpath("//a[@class='nav-interact'][text()='Corporate wellness']"));
		return element;
	}

	public static WebElement diagnostics(WebDriver driver) {
		element = driver.findElement(By.xpath("//div[@class='product-tab__title'][text()='Diagnostics']"));
		return element;
	}

}