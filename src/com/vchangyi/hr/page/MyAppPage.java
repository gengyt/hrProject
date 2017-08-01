package com.vchangyi.hr.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyAppPage {
	private WebElement element;

	/**
	 * 单机"我的应用"
	 * 
	 * @param driver
	 * @return
	 * @throws InterruptedException
	 */
	public WebElement myapp(WebDriver driver) throws InterruptedException {
		// 设置页面元素等待
		WebDriverWait wait = new WebDriverWait(driver, 10);
		// 页面元素是否在页面上可用和可被单击
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("我的应用")));
		element = driver.findElement(By.linkText("我的应用"));

		return element;
	}

	/**
	 * 单机"积分"
	 * 
	 * @param driver
	 * @return 返回积分元素定位
	 * @throws InterruptedException
	 */
	public WebElement mdjf(WebDriver driver) throws InterruptedException {

		List<WebElement> elements = driver.findElements(By
				.cssSelector(".side-menu-text"));
		if (elements.size() > 2) {// 安装了“积分”之外的应用
			// 由于安装多个应用，单机“我的应用”时加载时长不定，故用此方法让程序等待10s
			Thread.sleep(10000);
		}
		// 设置页面元素等待
		WebDriverWait wait = new WebDriverWait(driver, 10);
		// 页面元素是否在页面上可用和可被单击
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("积分")));

		// element = driver.findElement(By.cssSelector("[title='积分']"));
		element = driver.findElement(By.linkText("积分"));
		return element;
	}
}
