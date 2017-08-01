package com.vchangyi.hr.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ChangePasswordPage {

	private WebElement element;

	/**
	 * 修改密码
	 * 
	 * @param driver
	 * @return
	 */
	public WebElement click(WebDriver driver) {
		element = driver.findElement(By.linkText("修改密码"));
		return element;
	}

	/**
	 * 设置“登录密码”的值
	 * 
	 * @param driver
	 * @return
	 */
	public WebElement password(WebDriver driver) {
		element = driver.findElement(By.cssSelector("[placeholder='请输入新密码']"));
		return element;
	}

	/**
	 * 设置"再次输入密码"的值
	 * 
	 * @param driver
	 * @return
	 */
	public WebElement repassword(WebDriver driver) {
		element = driver
				.findElement(By.cssSelector("[placeholder='请再次输入新密码']"));
		return element;
	}

	/**
	 * 点击“修改”button
	 * 
	 * @param driver
	 * @return
	 */
	public WebElement change_btn(WebDriver driver) {
		element = driver.findElement(By
				.cssSelector(".btn.btn-lg.btn-theme-main"));
		return element;
	}

	/**
	 * "请输入登录密码"的验证
	 * 
	 * @param driver
	 * @return
	 */
	public WebElement assert_passwordEmpty(WebDriver driver) {
		element = driver.findElement(By
				.cssSelector("[ng-show='ctrl.passwordEmpty']"));
		return element;
	}

	/**
	 * "请再次输入密码"的验证
	 * 
	 * @param driver
	 * @return
	 */
	public WebElement assert_rePasswordEmpty(WebDriver driver) {
		element = driver.findElement(By
				.cssSelector("[ng-show='ctrl.rePasswordEmpty']"));
		return element;
	}

	/**
	 * "请再次输入密码"的验证
	 * 
	 * @param driver
	 * @return
	 */
	public WebElement assert_repeatPwdError(WebDriver driver) {
		element = driver.findElements(By.cssSelector(".repeatPwdError")).get(0);
		return element;
	}

	/**
	 * 密码格式错误，小于6位数
	 * 
	 * @param driver
	 * @return
	 */
	public WebElement assert_confirmPwd(WebDriver driver) {
		element = driver.findElement(By
				.cssSelector(".col-sm-4.font-18.confirmPwd"));
		return element;
	}

	/**
	 * 密码修改成功
	 * 
	 * @param driver
	 * @return
	 */
	public WebElement assert_success(WebDriver driver) {
		element = driver.findElement(By.cssSelector(".text"));
		return element;
	}

}
