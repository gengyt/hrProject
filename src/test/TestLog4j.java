package test;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestLog4j {

	public WebDriver driver;
	public String baseUrl = "http://www.sogou.com/";

	@BeforeMethod
	public void beforeMethod() {
		driver = new FirefoxDriver();
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

	@BeforeClass
	public void beforeClass() {
		DOMConfigurator.configure("log4j.xml");
	}

	@Test
	public void testLog4j() {
		Log.startTestCase("搜索");
		driver.get(baseUrl);
		Log.info("打开sogou首页");
		driver.findElement(By.id("query")).sendKeys("自动化测试");
		Log.info("输入搜索关键字：自动化测试");
		driver.findElement(By.id("stb")).click();
		Log.info("单击搜索按钮");
		Log.endTestCase("搜索");
	}
}
