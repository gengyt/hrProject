package test;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BrowserTest {
	WebDriver driver;

	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
	}

	/**
	 * 浏览器前进后退
	 * 
	 * @throws Exception
	 */
	@Test
	public void test_Baidu() throws Exception {
		driver.get("http://www.baidu.com/");
		Thread.sleep(1000);
		driver.get("http://news.baidu.com/");
		// 后退到百度页面
		driver.navigate().back();
		Thread.sleep(1000);
		// 前进到百度新闻页
		driver.navigate().forward();
	}

	/**
	 * 模拟浏览器刷新
	 * 
	 * @throws Exception
	 */
	@Test
	public void test_refresh() throws Exception {
		driver.get("http://news.baidu.com/");
		// 后退到百度页面
		driver.navigate().refresh();
		Thread.sleep(1000);
	}
	
	
	/**
	 * webElement常用方法
	 * 
	 * @throws Exception
	 */
	@Test
	public void test_webElement() throws Exception {
		driver.get("http://www.youdao.com/");
		
		driver.findElement(By.cssSelector("#translateContent")).sendKeys("测试submit");
		
		//submit和click功能一样，但click的应用范围更大
		driver.findElement(By.cssSelector("#form>button")).submit();
		
		driver.navigate().back();
		
		Thread.sleep(1000);
		
		//返回元素的属性值
		String type = driver.findElement(By.cssSelector("#translateContent")).getAttribute("type");
		
		System.out.println("属性值是:"+type);
	}
	
	/**
	 * webElement常用方法
	 * Action方法
	 * @throws Exception
	 */
	@Test
	public void test_webElement_Action() throws Exception {
		driver.get("http://www.baidu.com/");
		
		Actions action = new Actions(driver);
		
		Thread.sleep(1000);
		//鼠标右键点击指定元素操作
		action.contextClick(driver.findElement(By.cssSelector("#kw"))).perform();
		Thread.sleep(5000);
		//鼠标悬停
		action.clickAndHold(driver.findElement(By.linkText("设置"))).perform();
		
		Thread.sleep(5000);
	}
	
	
	/**
	 * 多窗口切换
	 * @throws Exception
	 */
	@Test
	public void test_windows() throws Exception {
		driver.get("http://www.baidu.com/");
		
		driver.manage().window().maximize();
		String search_Handle = driver.getWindowHandle();
		
		System.out.println("百度句柄为："+search_Handle);
		
		//打开百度注册窗口
		driver.findElement(By.linkText("登录")).click();
		
		Thread.sleep(2000);
		
		//立即登录
		driver.findElement(By.cssSelector(".pass-reglink")).click();
		
		Set<String> handles = driver.getWindowHandles();
		
		for(String handle : handles){
			if(!handle.equals(search_Handle)){
				//切换到注册页面
				driver.switchTo().window(handle);
				Thread.sleep(1000);
				driver.findElement(By.id("TANGRAM__PSP_3__userName")).sendKeys("username");
				driver.findElement(By.name("password")).sendKeys("password");
				Thread.sleep(1000);
				driver.close();
			}
		}
		
		for(String handle : handles){
			//判断是否为百度页面
			if(handle.equals(search_Handle)){
				//切换到注册页面
				driver.switchTo().window(handle);
				
				Thread.sleep(1000);
				//关闭注册页面
				driver.findElement(By.className("close-btn")).click();
				Thread.sleep(1000);
				driver.findElement(By.id("kw")).sendKeys("selenium");
				driver.findElement(By.id("su")).click();
				Thread.sleep(1000);
			}
		}
		
	}
	
	
	/**
	 * 文件上传
	 * sendkeys实现上传
	 * @throws Exception
	 */
//	public void test_upload() throws Exception {
//		PublicClass pc = new PublicClass();
//		pc.login();
//		driver.get("http://tb8.vchangyi.com/admincp/#/c/demo/upload-file");
//		
//	}

	@AfterClass(alwaysRun = true)
	public void tearDown() throws Exception {
		// 关闭浏览器
		driver.quit();
	}

}
