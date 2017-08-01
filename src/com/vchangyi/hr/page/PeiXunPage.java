package com.vchangyi.hr.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PeiXunPage {
	private WebElement element;

	/**
	 * 培训
	 * 
	 * @param driver
	 * @return
	 */
	public WebElement activeClick(WebDriver driver) {
		element = driver.findElement(By
				.cssSelector(".waves-effect.waves-light.subdrop.active"));
		return element;
	}

	/**
	 * 分配设置
	 * 
	 * @param driver
	 * @return
	 */
	public WebElement mdSettingsClick(WebDriver driver) {
		element = driver.findElement(By.linkText("分类设置"));
		return element;
	}

	/**
	 * 新建一级分类
	 * 
	 * @param driver
	 * @return
	 */
	public WebElement addOneClassify(WebDriver driver) {
		element = driver
				.findElement(By
						.cssSelector(".btn.btn-theme-main.waves-effect.waves-light.w-md.m-r-10"));
		return element;
	}

	/**
	 * 添加内容
	 * 
	 * @param driver
	 * @return
	 */
	public WebElement addButton(WebDriver driver) {
		element = driver
				.findElement(By
						.cssSelector(".btn.btn-theme-main.waves-effect.waves-light.w-md.theme-text-white.m-b-5.m-r-10"));
		return element;
	}

	/**
	 * 批量删除
	 * 
	 * @param driver
	 * @return
	 */
	public WebElement delButton(WebDriver driver) {
		element = driver
				.findElement(By
						.cssSelector(".btn.btn-theme-inverse.waves-effect.waves-light.w-md.theme-text-gray8.m-b-5"));
		return element;
	}

	/**
	 * 知识管理
	 * 
	 * @param driver
	 * @return
	 */
	public WebElement zhiShiGuanLi(WebDriver driver) {
		element = driver
				.findElement(By
						.cssSelector(".float-right.btn.btn-default.waves-effect.m-r-10.waves-light.w-md.button-is-checked>span"));
		return element;
	}

	/**
	 * 全部列表
	 * 
	 * @param driver
	 * @return
	 */
	public WebElement pageListBtn(WebDriver driver) {
		element = driver
				.findElement(By
						.cssSelector(".btn.btn-theme-inverse.waves-effect.waves-light.theme-bg-white.w-md"));
		return element;
	}

	/**
	 * 查询
	 * 
	 * @param driver
	 * @return
	 */
	public WebElement query(WebDriver driver) {
		element = driver.findElement(By
				.cssSelector("[data-ng-click='ctrl.query()']"));
		return element;
	}

	/**
	 * 标题
	 * 
	 * @param driver
	 * @return
	 */
	public WebElement title(WebDriver driver) {
		element = driver.findElement(By
				.cssSelector("[data-ng-model='ctrl.title']"));
		return element;
	}

	/**
	 * 创建人
	 * 
	 * @param driver
	 * @return
	 */
	public WebElement author(WebDriver driver) {
		element = driver.findElement(By
				.cssSelector("[data-ng-model='ctrl.author']"));
		return element;
	}

	/**
	 * 更新时间
	 * 
	 * @param driver
	 * @return
	 */
	public WebElement rangeDate(WebDriver driver) {
		element = driver.findElement(By
				.cssSelector("[ng-model='ctrl.rangeDate']"));
		return element;
	}

	/**
	 * 全部知识
	 * 
	 * @param driver
	 * @return
	 */
	public WebElement all(WebDriver driver) {
		element = driver.findElements(
				By.cssSelector(".font-16.theme-text-gray8")).get(0);
		return element;
	}

	/**
	 * 已发布
	 * 
	 * @param driver
	 * @return
	 */
	public WebElement published(WebDriver driver) {
		element = driver.findElements(
				By.cssSelector(".font-16.theme-text-gray8")).get(1);
		return element;
	}

	/**
	 * 草稿
	 * 
	 * @param driver
	 * @return
	 */
	public WebElement draft(WebDriver driver) {
		element = driver.findElements(
				By.cssSelector(".font-16.theme-text-gray8")).get(2);
		return element;
	}
}
