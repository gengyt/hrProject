package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestSohuMailLoginByObjectMap {

	WebDriver driver;
	String url = "http://mail.sohu.com";
	public ObjectMap objectmap;

	@BeforeClass
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		driver.get(url);

	}

	@AfterClass
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void testSohuMailLogin() throws Exception {
		// 声明一个ObjectMap对象实例，参数是objectMap.properties的绝对路径
		objectmap = new ObjectMap(
				"D:\\tools\\selenium\\workspace\\hrProject\\src\\objectMap.properties");

		//设置显性等待
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(objectmap
				.getLocator("SohuMai.HomePage.username")));

		WebElement username = driver.findElement(objectmap
				.getLocator("SohuMai.HomePage.username"));
		WebElement password = driver.findElement(objectmap
				.getLocator("SohuMai.HomePage.password"));
		WebElement submitBotton = driver.findElement(objectmap
				.getLocator("SohuMai.HomePage.submitBotton"));

		username.sendKeys("fosterwu");
		password.sendKeys("1111");
		submitBotton.click();

		Assert.assertTrue(driver.getPageSource().contains("收件箱"));
	}
}
