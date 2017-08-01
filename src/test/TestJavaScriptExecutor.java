package test;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.vchangyi.hr.tool.QiyeLogin;

public class TestJavaScriptExecutor extends QiyeLogin {

	public WebDriver driver;

	public String url = "http://www.sogou.com";

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
	public void test_01() throws Exception {
		driver.findElement(By.id("query")).sendKeys("使用JavaScript语句进行页面元素的单击");
		WebElement searchButton = driver.findElement(By.id("stb"));
		// 调用封装好的javaScriptClick方法来单击搜狗首页的搜索按钮
		javaScriptClick(searchButton);
	}

	public void javaScriptClick(WebElement element) {
		try {
			// 判断传入的element元素是否处于可单击状态，以及是否显示在页面上
			if (element.isEnabled() && element.isDisplayed()) {
				// 执行JavaScript语句arguments[0].click()
				((JavascriptExecutor) driver).executeScript(
						"arguments[0].click();", element);
				Thread.sleep(1000);
			} else {
				System.out.println("页面上的元素无法进行单机操作");
			}
		} catch (StaleElementReferenceException e) {
			System.out.println("页面元素没有附加在网页中" + e.getStackTrace());
		} catch (NoSuchElementException e) {
			System.out.println("在页面中没有找到要操作的元素" + e.getStackTrace());
		} catch (Exception e) {
			System.out.println("无法完成单机操作" + e.getStackTrace());
		}

	}
}
