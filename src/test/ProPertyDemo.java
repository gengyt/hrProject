package test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ProPertyDemo {

	public WebDriver driver;
	public String url = "http://localhost:8090/testSelenHtml/testFile.html";
	public JavascriptExecutor js;

	@BeforeTest
	public void setUp() {

		driver = new FirefoxDriver();
		driver.get(url);
	}

	@AfterTest
	public void teardown() {
		driver.quit();
	}

	@Test
	public void test01() throws InterruptedException {

		WebElement element = driver.findElement(By.id("text"));
		setAttribute(driver, element, "value", "文本框的文字和长度属性已经被修改了！");
		Thread.sleep(3000);
	}

	/**
	 * 增加页面元素属性和修改页面元素的属性
	 * 
	 * @param driver
	 * @param element
	 * @param attribute
	 * @param value
	 */
	public void setAttribute(WebDriver driver, WebElement element,
			String attribute, String value) {

		js = (JavascriptExecutor) driver;

		js.executeScript(
				"arguments[0].setAttribute(arguments[1],arguments[2])",
				element, attribute, value);
	}

	/**
	 * 删除页面元素的属性
	 * 
	 * @param driver
	 * @param element
	 * @param attribute
	 */
	public void removeAttribute(WebDriver driver, WebElement element,
			String attribute) {

		js = (JavascriptExecutor) driver;

		js.executeScript(
				"arguments[0].removeAttribute(arguments[1],arguments[2])",
				element, attribute);
	}
}
