package test;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.vchangyi.hr.tool.QiyeLogin;

public class TestFailCaptureScreen extends QiyeLogin {

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
		stb.click();
		try {
			Assert.assertTrue(driver.getPageSource().contains("事在人为"));
			System.out.println("断言执行了");
		} catch (AssertionError e) {
			System.out.println("catch中的代码执行了");
			takeScreenShot(driver);
		}
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

	public void takeScreenShot(WebDriver driver) {
		Date date = new Date();
		// 文件夹名字
		String picDir = "d:\\" + String.valueOf(DateUtil.getYear(date)) + "-"
				+ String.valueOf(DateUtil.getMonth(date)) + "-"
				+ String.valueOf(DateUtil.getDay(date));
		// 判断文件是否存在
		if (!new File(picDir).exists()) {
			FileUtil.creatDir(picDir);
		}
		// 生成文件名称
		String filePath = picDir + "\\"
				+ String.valueOf(DateUtil.getHour(new Date())) + "-"
				+ String.valueOf(DateUtil.getMin(new Date())) + "-"
				+ String.valueOf(DateUtil.getSecond(new Date())) + ".jpg";

		// 进行截图，并将文件内容保存再srcFile对象中
		File srcFile = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcFile, new File(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
