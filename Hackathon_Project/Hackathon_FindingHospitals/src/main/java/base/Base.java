package base;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class Base {

	public static WebDriver driver;
	public static String exepath;
	public static String url = "https://www.practo.com/";
	
	public static String browsertype;
	
	public static XSSFWorkbook wb;
	public static String fileName= System.getProperty("user.dir")+"\\DataTable\\Search.xlsx";
	public static String fileName1= System.getProperty("user.dir")+"\\DataTable\\City.xlsx";
	public static String fileName2= System.getProperty("user.dir")+"\\DataTable\\UserInput.xlsx";
	public static List<String> names = new ArrayList<String>();
	public static List<String> names1 = new ArrayList<String>();
	
	
	public static WebDriver driverInstantiate(String browser) 
	{
		browsertype = browser;
		//INVOKING CHROME BROWSER
		if (browsertype.equalsIgnoreCase("chrome")) {
		exepath = System.getProperty("user.dir") + "\\chromedriver.exe";
		ChromeOptions options = new ChromeOptions();
		options.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
		System.setProperty("webdriver.chrome.driver", exepath);
		driver = new ChromeDriver(options);
	} 
	
	//INVOKING FIREFOX BROWSER
	else if (browsertype.equalsIgnoreCase("firefox")) 
		{
			exepath = System.getProperty("user.dir") + "\\geckodriver.exe";
			FirefoxOptions options = new FirefoxOptions();
			options.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
			System.setProperty("webdriver.gecko.driver", exepath);
			driver = new FirefoxDriver(options);
		}

		driver.manage().window().maximize();       //MAXIMIZING THE BROWSER WINDOW
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);     //WAIT UNTIL THE WEBPAGE IS GETTING LOADED
		driver.get(url);
		driver.manage().deleteAllCookies();    
	
		return driver;
	}
	
	//TAKE SCREENSHOT
	public static void ScreenshotTC(WebDriver driver, String filename) {
		String path;
		File file;
		int count = 1;
		do {
			path = System.getProperty("user.dir") + "\\ScreenShots\\" + Base.browsertype + " " + filename + " " + count + ".png";
			count++;
			file = new File(path);
		} while (file.exists());
		Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1500))
				.takeScreenshot(driver);
		try {
			ImageIO.write(screenshot.getImage(), "PNG", new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//WRITING THE DATA INTO THE EXCEL FILE
	public static void ExcelWrite(String sheetName) throws IOException {		
		try {
			FileOutputStream writeFile;
			int x;
			if(sheetName == "SearchH") {
				wb = new XSSFWorkbook();
				XSSFSheet sheet1 = wb.createSheet(sheetName);
				int row = 0;
				for (x = 0; x < names.size(); x++) {
					try {
						sheet1.createRow(row).createCell(0).setCellValue(names.get(x));
						row++;
					} catch (Exception e) {
						e.printStackTrace();
					}
					writeFile = new FileOutputStream(new File(fileName));
					wb.write(writeFile);
					writeFile.close();
			}
			}
			else if(sheetName == "SearchC") {
				wb = new XSSFWorkbook();
				XSSFSheet sheet2 = wb.createSheet(sheetName);
				int row = 0;
				for (x = 0; x < names1.size(); x++) {
					try {
						sheet2.createRow(row).createCell(0).setCellValue(names1.get(x));
						row++;
					} catch (Exception e) {
						e.printStackTrace();
					}
					writeFile = new FileOutputStream(new File(fileName1));
					wb.write(writeFile);
					writeFile.close();
			}	
			}
			wb.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//READING INPUTS FROM THE EXCEL FILE
	public static void excelRead(ArrayList<String> data) throws Exception
	{
		FileInputStream fin=new FileInputStream(fileName2);	
		XSSFWorkbook wb=new XSSFWorkbook(fin);			
		XSSFSheet ws=wb.getSheet("Sheet1");			
		
		Row row;
		for(int r=0 ; r<=ws.getLastRowNum() ; r++) //for all rows in the sheet
		{
			row=ws.getRow(r);
			for(int c=0;c<row.getLastCellNum();c++)//for all cells in the row
			{
				//System.out.println(row.getCell(c).getStringCellValue());
				data.add(row.getCell(c).getStringCellValue());
			}
		}
		wb.close();
	}
}


