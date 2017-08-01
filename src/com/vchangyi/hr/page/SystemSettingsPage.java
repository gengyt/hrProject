package com.vchangyi.hr.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SystemSettingsPage {
	public WebElement element;

	/**
	 * 系统设置
	 * 
	 * @param driver
	 * @return
	 */
	public WebElement systemSettings(WebDriver driver) {
		element = driver.findElement(By.linkText("系统设置"));
		return element;
	}
}
