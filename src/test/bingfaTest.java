package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class bingfaTest {
	public WebDriver driver;

	@Parameters("browser")
	@BeforeClass
	public void beforeTest(String browser) {

		if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("ie")) {
			DesiredCapabilities dc = DesiredCapabilities.internetExplorer();
			dc.setCapability(
					InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
					true);
			System.setProperty("webdriver.ie.driver",
					"D:\\driver\\IEDriverServer.exe");
			driver = new InternetExplorerDriver(dc);
		} else {
			System.setProperty("webdriver.chrome.driver",
					"D:\\driver\\chromedriver.exe");
			driver = new ChromeDriver();
		}
	}

	@Test
	public void test_baidu() throws Exception {
		driver.get("http://www.baidu.com/");
		driver.findElement(By.id("kw")).sendKeys("测试");
		driver.findElement(By.id("su")).click();
		Thread.sleep(3000);
	}

	@AfterClass
	public void afterTest() throws Exception {
		// 关闭浏览器
		driver.quit();
	}

}
