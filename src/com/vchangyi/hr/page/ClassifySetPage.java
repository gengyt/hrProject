package com.vchangyi.hr.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ClassifySetPage {
	private WebElement element;

	private List<WebElement> elements;

	/**
	 * 添加分类
	 * 
	 * @param driver
	 * @return
	 */
	public WebElement classifyTitle(WebDriver driver) {
		element = driver.findElement(By.cssSelector(".left-head"));
		return element;
	}

	/**
	 * 添加操作
	 * 
	 * @param driver
	 * @return
	 */
	public WebElement addBox(WebDriver driver) {
		element = driver.findElement(By.cssSelector(".md.md-add-box.font-18"));
		return element;
	}

	/**
	 * 编辑操作
	 * 
	 * @param driver
	 * @return
	 */
	public WebElement editBox(WebDriver driver) {
		element = driver.findElement(By.cssSelector(".md.md-create.font-18"));
		return element;
	}

	/**
	 * 删除操作
	 * 
	 * @param driver
	 * @return
	 */
	public List<WebElement> delBox(WebDriver driver) {
		elements = driver.findElements(By.cssSelector(".md.md-delete.font-18"));
		return elements;
	}

	/**
	 * 已有分类
	 * 
	 * @param driver
	 * @return
	 */
	public WebElement Content(WebDriver driver) {
		element = driver.findElements(By.cssSelector(".first-content")).get(0);
		return element;
	}

	/**
	 * 分类种类
	 * 
	 * @param driver
	 * @return
	 */
	public List<WebElement> classifyList(WebDriver driver) {
		elements = driver
				.findElements(By
						.cssSelector("[data-ng-repeat='classify in ctrl.classifyList']"));
		return elements;
	}

	/**
	 * 弹框-确认
	 * 
	 * @param driver
	 * @return
	 */
	public WebElement popConfirm(WebDriver driver) {
		element = driver
				.findElement(By
						.cssSelector(".confirm.btn.btn-theme-main.btn-lg.waves-effect.waves-light.w-md.m-b-5"));
		return element;
	}

	/**
	 * 验证删除成功
	 * 
	 * @param driver
	 * @return
	 */
	public WebElement assert_del(WebDriver driver) {
		element = driver.findElement(By
				.cssSelector(".notifyjs-metro-base.notifyjs-metro-success"));
		return element;
	}
}
