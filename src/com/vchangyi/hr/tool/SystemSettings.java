package com.vchangyi.hr.tool;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import com.vchangyi.hr.page.SystemSettingsPage;

public class SystemSettings {
	SystemSettingsPage system = new SystemSettingsPage();
	/**
	 * 系统设置
	 */
	public void systemSettings(WebDriver driver) throws Exception {
		Thread.sleep(5000);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		system.systemSettings(driver).click();
	}
}
