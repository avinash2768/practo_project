package test;

import java.awt.List;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Properties;

import org.testng.TestNG;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.collect.Lists;

import base.Base;
import base.ReportsGeneration;
import pages.CorporateWellness;
import pages.SearchHospitals;
import pages.TopCities;

public class SearchTest extends Base {	
	public static ArrayList<String> names2 = new ArrayList<String>();
	
	@BeforeSuite
	public void data() throws Exception {
		excelRead(names2);
	}
	
	@BeforeTest
	public void openBrowser() throws Exception{
		SearchHospitals.createDriver(names2.get(0));
	}
		
	@Test
	public void Search() throws InterruptedException {
		SearchHospitals.homepage(names2.get(1));
		SearchHospitals.search(names2.get(2), names2.get(3), names2.get(4));
	}
	
	@Test(priority=1)
	public void TopCity() throws Exception {
		TopCities.homepage(names2.get(1));
		TopCities.getCityNames();
	}
	
	@Test(priority=2)
	public void CorporatePage() throws Exception{
		CorporateWellness.homepage(names2.get(1));
		CorporateWellness.corporateWellnessPage();
		CorporateWellness.setCorporateWellnessForm(names2.get(5), names2.get(6), names2.get(7), names2.get(8), names2.get(9), names2.get(10));
	}
	
	@AfterTest
	public void closeBrowser() {
		SearchHospitals.closeDriver();
	}
}
