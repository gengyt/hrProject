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

public class TestUploadFile extends QiyeLogin {

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
		WebElement element = driver.findElement(By.id("file"));
		element.sendKeys("D:\\useTest\\1.jpg");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("filesubmit")));
		driver.findElement(By.id("filesubmit")).click();
		wait.until(ExpectedConditions.titleContains("上传成功！")); 
	}
}
