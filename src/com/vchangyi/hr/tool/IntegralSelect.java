package com.vchangyi.hr.tool;

import org.openqa.selenium.WebDriver;

import com.vchangyi.hr.page.JfSelectPage;

public class IntegralSelect {

	JfSelectPage jfSelect = new JfSelectPage();
	/**
	 * 员工查询
	 */
	public void integralSelect(WebDriver driver) throws Exception {
		// 单机“员工查询”
		jfSelect.select(driver).click();
	}
}
