package com.vchangyi.hr.service.systemsettings;

import static org.testng.Assert.fail;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.vchangyi.hr.page.ClearCachePage;
import com.vchangyi.hr.tool.QiyeLogin;
import com.vchangyi.hr.tool.SystemSettings;

public class ClearCache extends QiyeLogin {

	public WebDriver driver;

	public String url = "http://thr.vchangyi.com/admincp/#/login";

	public String mobile = "13585672975";

	public String password = "123456";

	// 系统设置
	SystemSettings ss = new SystemSettings();

	ClearCachePage clearCache = new ClearCachePage();

	StringBuffer verificationErrors = new StringBuffer();

	@BeforeClass
	public void setUp() throws Exception {
		 driver = new FirefoxDriver();
	}

	/**
	 * 系统设置-清理缓存.<br>
	 * 
	 * @throws Exception
	 */
	@Test
	public void test_ClearCache() throws Exception {
		System.out.println("test_ClearCache()：执行清理缓存操作");
		// 登录
		driver = login(url, mobile, password);
		ss.systemSettings(driver);
		clearCache.clearCache_cache(driver).click();
		clearCache.clearCache_btn(driver).click();
		Thread.sleep(3000);
		String str = clearCache.clearOver(driver).getText();
		Assert.assertTrue(str.contains("缓存清理操作完毕"));
	}

	@AfterClass
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}
}
