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
import com.vchangyi.hr.page.PrizeSettingPage;
import com.vchangyi.hr.page.RuleSettingPage;
import com.vchangyi.hr.page.StrategySettingPage;
import com.vchangyi.hr.tool.IntegralExchange;
import com.vchangyi.hr.tool.IntegralSelect;
import com.vchangyi.hr.tool.IntegralSettings;
import com.vchangyi.hr.tool.IntegralTotal;
import com.vchangyi.hr.tool.QiyeLogin;

public class IntegralSettingService extends QiyeLogin {

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
	RuleSettingPage rulePage = new RuleSettingPage();
	PrizeSettingPage prizePage = new PrizeSettingPage();
	StrategySettingPage strategyPage = new StrategySettingPage();

	@BeforeClass
	public void setUp() throws Exception {
		// 登录
		driver = login(url, mobile, password);
	}

	/**
	 * 积分设置.<br>
	 * 积分策略设置
	 * 
	 * @throws Exception
	 */
	@Test
	public void test_01() throws Exception {

		// 单机“积分设置”
		integralSettings.integralSettings(driver);
		// 单机“积分策略设置”
		jfSetting.strategySetting(driver).click();
		String exchange = strategyPage.checkjfStrategy(driver).getText();
		Assert.assertTrue(exchange.contains("积分策略设置"));

	}

	/**
	 * 积分设置.<br>
	 * 积分规则说明
	 * 
	 * @throws Exception
	 */
	@Test
	public void test_02() throws Exception {

		// 单机“积分设置”
		integralSettings.integralSettings(driver);
		// 单机“积分规则说明”
		jfSetting.ruleSetting(driver).click();
		String exchange = rulePage.checkjfrule(driver).getText();
		Assert.assertTrue(exchange.contains("积分规则说明"));

	}

	/**
	 * 积分设置.<br>
	 * 奖品兑换设置
	 * 
	 * @throws Exception
	 */
	@Test
	public void test_03() throws Exception {

		// 单机“积分设置”
		integralSettings.integralSettings(driver);
		// 单机“奖品兑换设置”
		jfSetting.prizeSetting(driver).click();
		String exchange = prizePage.checkjfPrize(driver).getText();
		Assert.assertTrue(exchange.contains("奖品兑换设置"));

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
