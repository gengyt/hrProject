package com.vchangyi.hr.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JfExchangePage {
	private WebElement element;

	/**
	 * 点击“兑换管理”
	 * 
	 * @param driver
	 * @return
	 * @throws InterruptedException
	 */
	public WebElement exchange(WebDriver driver) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By
				.linkText("兑换管理")));
		// 积分统计
		element = driver.findElement(By.linkText("兑换管理"));
		return element;
	}

	/**
	 * 验证关键字“兑换管理”
	 * 
	 * @param driver
	 * @return
	 */
	public WebElement checkjfExchange(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By
				.cssSelector(".font-18.theme-text-gray3")));
		// 验证关键字“兑换管理”
		element = driver.findElement(By
				.cssSelector(".font-18.theme-text-gray3"));
		return element;
	}

}
