package test;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.vchangyi.hr.tool.QiyeLogin;

public class AlertTest extends QiyeLogin {

	public WebDriver driver;

	public String url = "http://localhost:8090/testSelenHtml/alert.html";

	@BeforeClass
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		driver.get(url);

	}

	@Test
	public void test_01() throws Exception {
		WebElement element = driver.findElement(By.xpath("//input"));
		element.click();
		try {
			// 使用driver.switchto().alert()方法获取Alert对象
			Alert alert = driver.switchTo().alert();
			Assert.assertEquals(alert.getText(), "这是一个alert弹出框");
			Thread.sleep(3000);
			// 单机Alert框上的“确定”按钮，关闭Alert弹框
			alert.accept();
		} catch (NoAlertPresentException e) {
			Assert.fail("尝试操作的alert框未被找到");
			e.printStackTrace();
		}

	}

	@AfterClass
	public void tearDown() throws Exception {
		driver.quit();
	}
}
