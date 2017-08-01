package com.vchangyi.hr.tool;

import org.openqa.selenium.WebDriver;

import com.vchangyi.hr.page.MyAppPage;

public class MyApp {
	
	MyAppPage myapp = new MyAppPage();
	
	/**
	 * 我的应用
	 */
	public void application(WebDriver driver) throws Exception {
		myapp.mdjf(driver).click();
	}
}
