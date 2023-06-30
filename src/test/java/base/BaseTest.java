package base;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseTest {

	public static WebDriver driver;
	public static Properties prop = new Properties();
	public static Properties loc = new Properties();
	public static FileReader freader;
	public static FileReader fr1;


	@BeforeMethod
	public void setUp() throws IOException {
		if(driver==null) {
			// We can get rid of partial filepath hardcoding by using System.getProperty("user.dir")
			// System.getProperty("user.dir") returns filepath till the project name.
			// The hardcoded line can be replaced with the line below
			freader =  new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\configfiles\\config.properties");
			fr1 = new FileReader(System.getProperty("user.dir")+"\\\\src\\\\test\\\\resources\\\\configfiles\\\\locators.properties");
			//freader = new FileReader("D:\\SeleniumFramework\\ZohoAutomated\\src\\test\\resources\\configfiles\\config.properties");
			//fr1 = new FileReader("D:\\SeleniumFramework\\ZohoAutomated\\src\\test\\resources\\configfiles\\locators.properties");
			prop.load(freader);
			loc.load(fr1);
		}
		if(prop.getProperty("browser").equalsIgnoreCase("chrome")){
				 WebDriverManager.chromedriver().setup();
				 driver=new ChromeDriver();
				 driver.get(prop.getProperty("url"));
				 driver.manage().window().maximize();
				 System.out.println(driver.getTitle());
				 System.out.println(driver.getCurrentUrl());
		}
		else if(prop.getProperty("browser").equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.get(prop.getProperty("url"));

			driver.manage().window().maximize();
			System.out.println(driver.getTitle());
			System.out.println(driver.getCurrentUrl());
		}
		
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
		System.out.println("Ran Successfully!");
	}
}
