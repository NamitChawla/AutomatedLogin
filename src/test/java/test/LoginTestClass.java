package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import utilities.ReadXLSdata;

public class LoginTestClass extends BaseTest{

	@Test(dataProviderClass=ReadXLSdata.class, dataProvider="BVT Data")
	public static void loginTest(String username, String password) throws InterruptedException {
		driver.findElement(By.xpath(loc.getProperty("sign_in_click"))).click();
		driver.findElement(By.xpath(loc.getProperty("login_field_path"))).sendKeys(username);
		Thread.sleep(2000);
		driver.findElement(By.xpath(loc.getProperty("next_button"))).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(loc.getProperty("password_field_path"))).sendKeys(password);
		driver.findElement(By.xpath(loc.getProperty("login_button"))).click();
		Thread.sleep(10000);
		
	}
}
//If sheetname is same as of the class name then class reflection can be used


//a[@class='login']
//input[@id='login_id']
//button[@id='nextbtn']
//input[@id='password']    /html[1]/body[1]/div[4]/div[1]/div[3]/div[3]/form[1]/div[2]/div[2]/div[2]/input[1]
//button[@id='nextbtn']	   /html[1]/body[1]/div[4]/div[1]/div[3]/div[3]/form[1]/div[2]/div[2]/div[2]/input[1]