package com.vchangyi.hr.tool;

import org.openqa.selenium.WebDriver;

import com.vchangyi.hr.page.JfExchangePage;

public class IntegralExchange {

	JfExchangePage jfExchangelPage = new JfExchangePage();
	/**
	 * 兑换管理
	 */
	public void integralExchange(WebDriver driver) throws Exception {
		// 单机“兑换管理”
		jfExchangelPage.exchange(driver).click();
	}
}
