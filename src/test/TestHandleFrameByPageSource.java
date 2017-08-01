package test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.vchangyi.hr.tool.QiyeLogin;

public class TestHandleFrameByPageSource extends QiyeLogin {

	public WebDriver driver;

	public String url = "http://localhost:8090/testSelenHtml/frameset.html";

	@BeforeClass
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		driver.get(url);

	}

	@Test
	public void test_01() {
		List<WebElement> frames = driver.findElements(By.tagName("frame"));

		// 遍历frames中所有的frame页面，查找包含“中间frame”的frame页面
		for (WebElement frame : frames) {
			// jinru frame页面
			driver.switchTo().frame(frame);
			// 判断每个frame的HTML源码中是否包含“中间frame”关键字
			if (driver.getPageSource().contains("中间frame")) {
				// 查找页面上的P标签页面对象
				WebElement middleFrametext = driver
						.findElement(By.xpath("//p"));
				Assert.assertEquals("这是中间frame", middleFrametext.getText());

				// 找到指定的frame退回for循环
				break;
			} else {
				// 返回到frameset页面
				driver.switchTo().defaultContent();
			}
		}
		// 返回到frameset页面
		driver.switchTo().defaultContent();
	}

	@AfterClass
	public void tearDown() throws Exception {
		driver.quit();
	}
}
