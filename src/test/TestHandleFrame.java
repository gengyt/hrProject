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

public class TestHandleFrame extends QiyeLogin {

	public WebDriver driver;

	public String url = "http://localhost:8090/testSelenHtml/frameset.html";

	@BeforeClass
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		driver.get(url);

	}

	@Test
	public void test_01() {
		// 进入到左侧frame页面
		driver.switchTo().frame("leftframe");
		WebElement left = driver.findElement(By.xpath("//p"));
		Assert.assertEquals("这是左侧frame", left.getText());

		/**
		 * 从左侧frame中返回到frameset页面，如果不调用此行代码，<br>
		 * 则无法从左侧frame页面中直接进入其他frame页面
		 */
		driver.switchTo().defaultContent();

		driver.switchTo().frame("middleframe");
		WebElement middle = driver.findElement(By.xpath("//p"));
		Assert.assertEquals("这是中间frame", middle.getText());

		driver.switchTo().defaultContent();

		driver.switchTo().frame("rightframe");

		WebElement right = driver.findElement(By.xpath("//p"));
		Assert.assertEquals("这是右侧frame", right.getText());
	}

	@AfterClass
	public void tearDown() throws Exception {
		driver.quit();
	}
}
