package test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestRobot {

	public WebDriver driver;

	public String url = "http://www.baidu.com";

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
	public void testRobot() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("kw")));

		setAndctrlVclipboardData("自动化测试");
		/**
		 * 执行到这一步是，光标落到哪里就在哪里粘贴， 所以当浏览器访问到网页并且加载完毕后，需要手动将光标移至输入框
		 */
		pressTabKey();
		Thread.sleep(3000);
		pressEnterKey();
		Thread.sleep(3000);
	}

	/**
	 * 封装粘贴函数，可以将函数的str参数值放入到剪贴板中，然后在使用
	 * Robot对象的keyPress和keyRelease函数模拟Ctrl+V组合键完成粘贴操作
	 * 
	 * @param str
	 */
	public void setAndctrlVclipboardData(String str) {
		// 声明StringSelection对象
		StringSelection ss = new StringSelection(str);
		// 使用Toolkit对象的setContents方法将字符创放到剪切板中
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		Robot robot = null;
		try {
			robot = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 调用keyPress方法来实现按下Ctrl键
		robot.keyPress(KeyEvent.VK_CONTROL);
		// 调用keyPress方法来实现按下v键
		robot.keyPress(KeyEvent.VK_V);
		// 调用keyPress方法来释放v键
		robot.keyRelease(KeyEvent.VK_V);
		// 调用keyPress方法来释放Ctrl键
		robot.keyRelease(KeyEvent.VK_CONTROL);
	}

	public void pressTabKey() {
		Robot robot = null;

		try {
			robot = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
	}

	public void pressEnterKey() {
		Robot robot = null;

		try {
			robot = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}
}
