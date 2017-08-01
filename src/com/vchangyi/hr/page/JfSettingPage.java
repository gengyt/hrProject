package com.vchangyi.hr.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JfSettingPage {
	private WebElement element;

	/**
	 * 点击“积分设置”
	 * 
	 * @param driver
	 * @return
	 * @throws InterruptedException
	 */
	public WebElement settings(WebDriver driver) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By
				.linkText("积分设置")));
		// 积分设置
		element = driver.findElement(By.linkText("积分设置"));
		return element;
	}

	/**
	 * 验证关键字“积分设置”
	 * 
	 * @param driver
	 * @return
	 */
	public WebElement checkjf(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By
				.linkText("积分设置")));
		// 验证关键字“积分设置”
		element = driver.findElement(By.linkText("积分设置"));
		return element;
	}

	/**
	 * 点击“积分策略设置---设置”
	 * 
	 * @param driver
	 * @return
	 */
	public WebElement strategySetting(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("设置")));
		List<WebElement> elements = driver.findElements(By.linkText("设置"));
		if (!"".equals(elements)) {
			element = elements.get(0);
		}
		return element;
	}
	
	/**
	 * 点击“积分规则说明---设置”
	 * 
	 * @param driver
	 * @return
	 */
	public WebElement ruleSetting(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("设置")));
		List<WebElement> elements = driver.findElements(By.linkText("设置"));
		if (!"".equals(elements)) {
			element = elements.get(1);
		}
		return element;
	}
	
	/**
	 * 点击“奖品兑换设置---设置”
	 * 
	 * @param driver
	 * @return
	 */
	public WebElement prizeSetting(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".btn.btn-theme-inverse.waves-effect.waves-ripple.m-t-10.btn-set")));
		List<WebElement> elements = driver.findElements(By.cssSelector(".btn.btn-theme-inverse.waves-effect.waves-ripple.m-t-10.btn-set"));
		if (!"".equals(elements)) {
			element = elements.get(2);
		}
		return element;
	}
}
