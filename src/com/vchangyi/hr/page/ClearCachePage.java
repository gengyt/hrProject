package com.vchangyi.hr.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ClearCachePage {
	
	private WebElement element;

	/**
	 * 清理缓存
	 * @param driver
	 * @return
	 */
	public WebElement clearCache_cache(WebDriver driver) {
		element = driver.findElement(By.linkText("清理缓存"));
		return element;
	}

	/**
	 * 点击“开始清理”button
	 * 
	 * @param driver
	 * @return
	 */
	public WebElement clearCache_btn(WebDriver driver) {
		element = driver.findElement(By
				.cssSelector(".btn.btn-theme-rounded.btn-lg.w-lg"));
		return element;
	}

	/**
	 * 缓存清理操作完毕的验证
	 * 
	 * @param driver
	 * @return
	 */
	public WebElement clearOver(WebDriver driver) {
		element = driver
				.findElement(By
						.cssSelector(".font-18.theme-text-gray3.m-t-10.m-b-30.font-yahei"));
		return element;
	}

}
