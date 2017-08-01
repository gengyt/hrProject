package com.vchangyi.hr.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ClassifyEditPage {
	private WebElement element;

	/**
	 * 标题
	 * 
	 * @param driver
	 * @return
	 */
	public WebElement addTitle(WebDriver driver) {
		element = driver
				.findElement(By
						.cssSelector(".form-control.ng-pristine.ng-untouched.ng-valid.ng-not-empty"));
		return element;
	}

	/**
	 * 排序号
	 * 
	 * @param driver
	 * @return
	 */
	public WebElement author(WebDriver driver) {
		element = driver
				.findElement(By
						.cssSelector(".form-control.required.ng-pristine.ng-untouched.ng-valid.ng-not-empty"));
		return element;
	}

	/**
	 * 启用分类=是
	 * 
	 * @param driver
	 * @return
	 */
	public WebElement isOpen(WebDriver driver) {
		element = driver
				.findElement(By
						.cssSelector("[data-ng-checked='ctrl.classifyDetail.is_open == 1']"));
		return element;
	}

	/**
	 * 启用分类=否
	 * 
	 * @param driver
	 * @return
	 */
	public WebElement NoOpen(WebDriver driver) {
		element = driver
				.findElement(By
						.cssSelector("[data-ng-checked='ctrl.classifyDetail.is_open == 0']"));
		return element;
	}

	/**
	 * 内容分类 = 全公司
	 * 
	 * @param driver
	 * @return
	 */
	public WebElement all(WebDriver driver) {
		element = driver.findElements(
				By.cssSelector(".btn-theme-rounded.btn.w-md.classify-choose"))
				.get(0);
		return element;
	}

	/**
	 * 内容分类 = 指定对象
	 * 
	 * @param driver
	 * @return
	 */
	public WebElement chooseCheck(WebDriver driver) {
		element = driver
				.findElements(
						By.cssSelector(".btn-theme-rounded-new.btn.w-md.classify-choose"))
				.get(0);
		return element;
	}

	/**
	 * 发布
	 * 
	 * @param driver
	 * @return
	 */
	public WebElement releaseBtn(WebDriver driver) {
		element = driver
				.findElement(By
						.cssSelector(".btn.btn-primary.waves-effect.waves-light.w-md.m-r-10"));
		return element;
	}

	/**
	 * 返回
	 * 
	 * @param driver
	 * @return
	 */
	public WebElement returnBtn(WebDriver driver) {
		element = driver
				.findElement(By
						.cssSelector(".btn.btn-default.w-md.waves-effect.waves-light.theme-bg-white.w-md"));
		return element;
	}
}
