package com.vchangyi.hr.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JfTotalPage {
	private WebElement element = null;

	/**
	 * 点击“积分统计”
	 * 
	 * @param driver
	 * @return
	 * @throws InterruptedException
	 */
	public WebElement total(WebDriver driver) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By
				.cssSelector("i.md.md-data-usage")));
		// 积分统计
		element = driver.findElement(By.cssSelector("i.md.md-data-usage"));
		return element;
	}

	/**
	 * 验证关键字“积分统计”
	 * 
	 * @param driver
	 * @return
	 */
	public WebElement checkjfTotal(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By
				.cssSelector(".font-18.theme-text-gray3")));
		// 验证关键字“积分统计”
		element = driver.findElement(By
				.cssSelector(".font-18.theme-text-gray3"));
		return element;
	}

}
