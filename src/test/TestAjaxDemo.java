package test;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.vchangyi.hr.tool.QiyeLogin;

public class TestAjaxDemo extends QiyeLogin {
	public WebDriver driver;
	public String url = "http://www.sogou.com";

	@BeforeClass
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		driver.get(url);
	}

	@Test
	public void test_01() throws InterruptedException {
		WebElement element = driver.findElement(By.id("query"));
		element.click();
		Thread.sleep(1000);
		// 定位所有浮动框中的选项
		List<WebElement> elements = driver.findElements(By
				.xpath("//*[@id='vl']/div/ul/li"));
		try {
			if (elements.size() > 0) {
				// 单机第三个浮动框中的信息
				elements.get(2).click();
				Thread.sleep(1500);
			}
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
	}

	@AfterClass
	public void tearDown() throws Exception {
		driver.quit();
	}
}
