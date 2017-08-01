package com.vchangyi.hr.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TitlePage {

	private WebElement element;

	/**
	 * 单机“首页”
	 * 
	 * @param driver
	 * @return
	 */
	public WebElement clickHomePage(WebDriver driver) {
		element = driver.findElement(By.linkText("首页"));
		return element;
	}

	/**
	 * 单机“我的应用”
	 * 
	 * @param driver
	 * @return
	 */
	public WebElement clickMyApp(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By
				.cssSelector(".waves-effect.m-r-20>span")));
		// 单机“我的应用”
		List<WebElement> elements = driver.findElements(By
				.cssSelector(".waves-effect.m-r-20>span"));
		if (elements != null) {
			element = elements.get(1);
		}
		return element;
	}

	/**
	 * 单机“人事管理”
	 * 
	 * @param driver
	 * @return
	 */
	public WebElement clickMemberList(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By
				.cssSelector(".waves-effect.m-r-20>span")));
		// 单机“人事管理”
		List<WebElement> elements = driver.findElements(By
				.cssSelector(".waves-effect.m-r-20>span"));
		if (elements != null) {
			element = elements.get(2);
		}
		return element;
	}

	/**
	 * 单机“应用中心”
	 * 
	 * @param driver
	 * @return
	 */
	public WebElement clickAppCenter(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By
				.cssSelector(".waves-effect.m-r-20>span")));
		// 单机“应用中心”
		List<WebElement> elements = driver.findElements(By
				.cssSelector(".waves-effect.m-r-20>span"));
		if (elements != null) {
			element = elements.get(3);
		}
		return element;
	}

	/**
	 * 单机“系统设置”
	 * 
	 * @param driver
	 * @return
	 */
	public WebElement clickSystemSettings(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By
				.cssSelector(".waves-effect.m-r-20>span")));
		// 单机“系统设置”
		List<WebElement> elements = driver.findElements(By
				.cssSelector(".waves-effect.m-r-20>span"));
		if (elements != null) {
			element = elements.get(4);
		}
		return element;
	}
}
