package com.vchangyi.hr.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class KnowledgeManagePage {
	
	private WebElement element;

	/**
	 * 培训元素定位
	 * @param driver
	 * @return
	 */
	public WebElement subdropActive(WebDriver driver) {
		element = driver.findElement(By.linkText("培训"));
		return element;
	}
}
