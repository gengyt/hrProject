package com.vchangyi.hr.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PrizeSettingPage {
	private WebElement element;

	/**
	 * 验证关键字“奖品兑换设置”
	 * 
	 * @param driver
	 * @return
	 */
	public WebElement checkjfPrize(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By
				.cssSelector(".font-18.theme-text-gray3")));
		// 验证关键字“奖品兑换设置”
		element = driver.findElement(By
				.cssSelector(".font-18.theme-text-gray3"));
		return element;
	}

}
