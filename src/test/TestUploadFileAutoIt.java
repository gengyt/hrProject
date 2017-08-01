package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.vchangyi.hr.tool.QiyeLogin;

public class TestUploadFileAutoIt extends QiyeLogin {

	public WebDriver driver;

	public String url = "http://localhost:8090/testSelenHtml/upload.html";

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
	public void testUploadFile() throws Exception {
		// 查找页面上ID名称为“file”的文件上传框
		WebElement element = driver.findElement(By.id("file"));
		// 单机文件上传对象，会弹出文件选择框体
		element.click();
		// 调用存储在D盘的AutoIt的可执行文件test.exe
		Runtime.getRuntime().exec("D:/tools/selenium/test.exe");
		// 由于AutoIt的可执行文件test.exe执行有可能速度角码，所以等待10秒，确保脚本执行完毕
		Thread.sleep(10000);

		WebDriverWait wait = new WebDriverWait(driver, 10);
		// 判断页面是否关闭了文件选择框，重新显示上传文件元素
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("file")));
		driver.findElement(By.id("filesubmit")).click();
		wait.until(ExpectedConditions.titleContains("上传成功！"));
	}
}
