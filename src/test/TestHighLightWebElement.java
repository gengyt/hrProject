package test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.vchangyi.hr.tool.QiyeLogin;

public class TestHighLightWebElement extends QiyeLogin {

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
		WebElement query = driver.findElement(By.id("query"));
		WebElement stb = driver.findElement(By.id("stb"));

		highLightElement(query);
		query.sendKeys("自动化测试");
		Thread.sleep(3000);
		
		stb.click();
	}

	/**
	 * 将传入参数的页面元素对象的背景颜色和边框颜色分别设置为黄色和红色
	 * 
	 * @param element
	 */
	public void highLightElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].setAttribute('style',arguments[1]);",
				element, "background: yellow; border: 2px solid red;");
	}
}
