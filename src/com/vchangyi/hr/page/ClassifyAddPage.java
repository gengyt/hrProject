package com.vchangyi.hr.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ClassifyAddPage {
	
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
						.cssSelector(".form-control.ng-pristine.ng-untouched.ng-valid.ng-empty"));
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
						.cssSelector(".form-control.required.ng-pristine.ng-untouched.ng-valid.ng-empty"));
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

	/**
	 * 标题不能为空
	 * 
	 * @param driver
	 * @return
	 */
	public WebElement assert_Title(WebDriver driver) {
		element = driver.findElement(By.cssSelector(".occupied_color"));
		return element;
	}

	/**
	 * dialog部门
	 * 
	 * @param driver
	 * @return
	 */
	public WebElement dialog_tabSwitch(WebDriver driver) {
		element = driver.findElement(By
				.cssSelector("[data-ng-click='tabSwitch(1)']"));
		return element;
	}

	/**
	 * dialog部门-淘金子
	 * 
	 * @param driver
	 * @return
	 */
	public WebElement dialog_dpName(WebDriver driver) {
		element = driver.findElement(By
				.cssSelector("[data-ng-checked='departItem.isChecked']"));
		return element;
	}

	/**
	 * dialog确认
	 * 
	 * @param driver
	 * @return
	 */
	public WebElement dialog_btnPrimary(WebDriver driver) {
		element = driver.findElement(By.cssSelector(".btn.btn-primary"));
		return element;
	}
}
