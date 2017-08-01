package com.vchangyi.hr.service.integral;

import static org.testng.Assert.fail;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.vchangyi.hr.page.JfExchangePage;
import com.vchangyi.hr.page.JfSelectPage;
import com.vchangyi.hr.page.JfSettingPage;
import com.vchangyi.hr.page.JfTotalPage;
import com.vchangyi.hr.tool.IntegralExchange;
import com.vchangyi.hr.tool.IntegralSelect;
import com.vchangyi.hr.tool.IntegralSettings;
import com.vchangyi.hr.tool.IntegralTotal;
import com.vchangyi.hr.tool.QiyeLogin;

public class Integral extends QiyeLogin {

	public WebDriver driver;

	public String url = "http://dhr-a.vchangyi.com/admincp/#/login";

	public String mobile = "13585672975";

	public String password = "123456";

	private StringBuffer verificationErrors = new StringBuffer();

	IntegralSettings integralSettings = new IntegralSettings();
	IntegralTotal integralTotal = new IntegralTotal();
	IntegralSelect integralSelect = new IntegralSelect();
	IntegralExchange integralExchange = new IntegralExchange();

	JfTotalPage jftotal = new JfTotalPage();
	JfSettingPage jfSetting = new JfSettingPage();
	JfSelectPage jfSelect = new JfSelectPage();
	JfExchangePage jfExchange = new JfExchangePage();

	@BeforeClass
	public void setUp() throws Exception {
		// 登录
		driver = login(url, mobile, password);
	}

	/**
	 * 积分 积分统计.<br>
	 * 员工查询.<br>
	 * 兑换管理.<br>
	 * 积分设置.<br>
	 * 
	 * 单机对应tab，页面可以切换。
	 * 
	 * @throws Exception
	 */
	@Test
	public void test_integralTeb() throws Exception {
		// 单机“积分设置”
		integralSettings.integralSettings(driver);
		String detail = jfSetting.checkjf(driver).getText();
		Assert.assertTrue(detail.contains("积分设置"));

		// 单机“积分统计”
		integralTotal.integralTotal(driver);
		String total = jftotal.checkjfTotal(driver).getText();
		Assert.assertTrue(total.contains("积分统计"));

		// 单机“员工查询”
		integralSelect.integralSelect(driver);
		String select = jfSelect.checkjfSelect(driver).getText();
		Assert.assertTrue(select.contains("员工查询"));
		
		// 单机“兑换管理”
		integralExchange.integralExchange(driver);
		String exchange = jfExchange.checkjfExchange(driver).getText();
		Assert.assertTrue(exchange.contains("兑换管理"));

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
