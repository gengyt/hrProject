package com.vchangyi.hr.tool;

import org.openqa.selenium.WebDriver;

import com.vchangyi.hr.page.JfSettingPage;
import com.vchangyi.hr.page.MyAppPage;

public class IntegralSettings {

	MyAppPage myappPage = new MyAppPage();

	JfSettingPage jfSetting = new JfSettingPage();

	/**
	 * 积分设置
	 */
	public void integralSettings(WebDriver driver) throws Exception {
		//我的应用
		myappPage.myapp(driver).click();
		
		//积分
		myappPage.mdjf(driver).click();
		
		// 单机“积分设置”
		jfSetting.settings(driver).click();
	}
}
