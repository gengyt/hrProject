package com.vchangyi.hr.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JfSelectPage {
	private WebElement element = null;

	/**
	 * 点击“员工查询”
	 * 
	 * @param driver
	 * @return
	 * @throws InterruptedException
	 */
	public WebElement select(WebDriver driver) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By
				.cssSelector("i.md.md-search")));
		// 员工查询
		element = driver.findElement(By.cssSelector("i.md.md-search"));
		return element;
	}

	/**
	 * 验证关键字“员工查询”
	 * 
	 * @param driver
	 * @return
	 */
	public WebElement checkjfSelect(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By
				.linkText("员工查询")));
		// 验证关键字“员工查询”
		element = driver.findElement(By.linkText("员工查询"));
		return element;
	}

}
