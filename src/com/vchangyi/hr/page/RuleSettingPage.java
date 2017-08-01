package com.vchangyi.hr.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RuleSettingPage {
	private WebElement element;

	/**
	 * 验证关键字“积分规则设置”
	 * 
	 * @param driver
	 * @return
	 */
	public WebElement checkjfrule(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By
				.cssSelector(".title-detail")));
		// 验证关键字“积分规则设置”
		element = driver.findElement(By.cssSelector(".title-detail"));
		return element;
	}

}
