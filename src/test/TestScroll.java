package test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestScroll {

	public WebDriver driver;

	public String url = "http://v.sogou.com";

	@BeforeClass
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		driver.get(url);

	}

	@AfterClass
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test(priority = 1)// priority=1表示测试用例第一优先级运行
	public void scrollingToBottomofApage() throws InterruptedException {
		// 将页面的滚动条滑动到最下方
		((JavascriptExecutor) driver)
				.executeScript("window.scrollTo(0,document.body.scrollHeight)");

		Thread.sleep(3000);
	}

	@Test(priority = 2)
	// priority=2表示测试用例第二优先级运行
	public void scrollingToElementofApage() throws InterruptedException {
		// 进入搜索视频页面中的ID值为main_frame的frame页面
		driver.switchTo().frame("main_frame");
		WebElement element = driver.findElement(By.xpath("//h2[text()='电视剧分类']"));

		((JavascriptExecutor) driver).executeScript(
				"arguments[0].scrollIntoView();", element);

		Thread.sleep(3000);
	}
	
	@Test(priority = 3)// priority=3表示测试用例第三优先级运行
	public void scrollingByCoordinatesfoAPage() throws InterruptedException {
		((JavascriptExecutor) driver).executeScript(
				"window.scrollBy(0-800}");
		Thread.sleep(3000);
	}

}  
