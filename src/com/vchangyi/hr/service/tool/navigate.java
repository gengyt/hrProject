package com.vchangyi.hr.service.tool;

import static org.testng.Assert.fail;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.vchangyi.hr.page.TitlePage;
import com.vchangyi.hr.tool.QiyeLogin;

public class navigate extends QiyeLogin {

	public WebDriver driver;

	public String url = "http://dhr-a.vchangyi.com/admincp/#/login";

	public String mobile = "13585672975";

	public String password = "123456";

	private StringBuffer verificationErrors = new StringBuffer();

	TitlePage titlePage = new TitlePage();

	@BeforeClass
	public void setUp() throws Exception {
		// 登录
		driver = login(url, mobile, password);
	}

	/**
	 * 判断导航栏和页面title是否一致.<br>
	 * 
	 * @throws Exception
	 */
	@Test
	public void test_01() throws Exception {
		// 单机“我的应用”
		titlePage.clickMyApp(driver).click();
		// 取得页面Title
//		String title1 = driver.getTitle();
		//由于我的应用的title随着企业安装的应用顺序变化而变化，所以暂不做判断
//		Assert.assertEquals(title1, "我的应用");
		
		titlePage.clickMemberList(driver).click();
		// 取得页面Title
		String title3 = driver.getTitle();
		Assert.assertEquals(title3, "员工管理");
		
		titlePage.clickAppCenter(driver).click();
		// 取得页面Title
		String title4 = driver.getTitle();
		Assert.assertEquals(title4, "应用中心");
		
		titlePage.clickSystemSettings(driver).click();
		// 取得页面Title
		String title5 = driver.getTitle();
		Assert.assertEquals(title5, "账户信息");
		
		titlePage.clickHomePage(driver).click();
		// 取得页面Title
		String title2 = driver.getTitle();
		Assert.assertEquals(title2, "首页");
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
