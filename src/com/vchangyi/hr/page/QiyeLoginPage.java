package com.vchangyi.hr.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class QiyeLoginPage {
	private WebElement element;
	private List<WebElement> elements;

	public WebElement login_mobile(WebDriver driver) {
		element = driver.findElement(By.name("mobile"));
		return element;
	}

	public WebElement login_password(WebDriver driver) {
		element = driver.findElement(By.name("password"));
		return element;
	}

	public WebElement login_button(WebDriver driver) {
		element = driver.findElement(By.tagName("button"));
		return element;
	}

	public List<WebElement> login_span(WebDriver driver) {
		elements = driver.findElements(By.tagName("span"));
		return elements;
	}
}
