package com.vchangyi.hr.tool;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.vchangyi.hr.page.QiyeLoginPage;

public class QiyeLogin {

	QiyeLoginPage login = new QiyeLoginPage();
	
	/**
	 * 登录企业号后台
	 * 
	 * @throws Exception
	 */
	public WebDriver login(String url,String mobile,String password) throws Exception {
//		WebDriver driver = new ChromeDriver();
//		WebDriver driver = new InternetExplorerDriver();
		WebDriver driver = new FirefoxDriver();
		// 设置地址
		driver.get(url);

		// 设置浏览器最大化
		driver.manage().window().maximize();

		List<WebElement> list = login.login_span(driver);

		list.get(1).click();
		driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);
		// 输入用户名
		login.login_mobile(driver).sendKeys(mobile);	
		// 输入密码
		login.login_password(driver).sendKeys(password);
		// 登录
		login.login_button(driver).click();

		// 去掉alert弹框
		// Alert alert = driver.switchTo().alert();
		// alert.dismiss();
		 Thread.sleep(1000);

		return driver;
	}
}
