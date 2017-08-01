package com.vchangyi.hr.tool;

import org.openqa.selenium.WebDriver;

import com.vchangyi.hr.page.JfTotalPage;

public class IntegralTotal {

	JfTotalPage jfTotal = new JfTotalPage();
	/**
	 * 积分统计
	 */
	public void integralTotal(WebDriver driver) throws Exception {
		// 单机“积分统计”
		jfTotal.total(driver).click();
	}
}
