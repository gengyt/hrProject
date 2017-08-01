package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.vchangyi.hr.tool.QiyeLogin;

public class TestHandleIFrame extends QiyeLogin {

	public WebDriver driver;

	public String url = "http://localhost:8090/testSelenHtml/frameset.html";

	@BeforeClass
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		driver.get(url);

	}

	@Test
	public void test_01() {
		// 转换操作区域，进入到左侧frame页面
		driver.switchTo().frame("leftframe");
		// 查找iframe的页面元素
		WebElement left = driver.findElement(By.tagName("iframe"));
		// 转换操作区域，进入到iframe的页面区域
		driver.switchTo().frame(left);
		// iframe页面的p元素定位
		WebElement iframeText = driver.findElement(By.xpath("//p"));
		Assert.assertEquals("这是iframe", iframeText.getText());
		// 转换操作区域，进入奥frameset页面
		driver.switchTo().defaultContent();
	}

	@AfterClass
	public void tearDown() throws Exception {
		driver.quit();
	}
}
