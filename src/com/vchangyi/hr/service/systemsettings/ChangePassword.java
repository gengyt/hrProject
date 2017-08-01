package com.vchangyi.hr.service.systemsettings;

import static org.testng.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.vchangyi.hr.page.ChangePasswordPage;
import com.vchangyi.hr.tool.QiyeLogin;
import com.vchangyi.hr.tool.SystemSettings;

public class ChangePassword extends QiyeLogin {

	public WebDriver driver;

	// 系统设置
	SystemSettings ss = new SystemSettings();
	
	ChangePasswordPage changePasswordPage = new ChangePasswordPage();

	StringBuffer verificationErrors = new StringBuffer();

	public String url = "http://dhr-a.vchangyi.com/admincp/#/login";

	public String mobile = "13585672975";

	public String password = "123456";

	@BeforeMethod
	public void setUp() throws Exception {

		driver = login(url, mobile, password);
		ss.systemSettings(driver);
	}

	/**
	 * 关闭浏览器。
	 * 
	 * @throws Exception
	 */
	@AfterMethod
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	/**
	 * 系统设置-修改密码.<br>
	 * 全部为空时，判断是否正常
	 * 
	 * @throws Exception
	 */
	@Test //如果此依赖方法失败，它将被跳过，而不是标记为失败
	public void test_ChangePassword1() throws Exception {
		// 登录
//		 driver = login(url, mobile, password);
//		 ss.systemSettings(driver);
		// 修改密码
		changePasswordPage.click(driver).click();

		// 点击“修改”button
		changePasswordPage.change_btn(driver).click();
		driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);
		String passwordEmpty = changePasswordPage.assert_passwordEmpty(driver)
				.getText();
		// 全部为空时，判断是否正常
		Assert.assertTrue(passwordEmpty.contains("请输入登录密码"));
	}

	/**
	 * 系统设置-修改密码.<br>
	 * 仅设置“登录密码”的值
	 * 
	 * @throws Exception
	 */
	@Test
	public void test_ChangePassword2() throws Exception {
		// 登录
		// driver = login(url, mobile, password);

		// 修改密码
		changePasswordPage.click(driver).click();
		driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);
		// 设置“登录密码”的值
		changePasswordPage.password(driver).sendKeys("123456");

		// 点击“修改”button
		changePasswordPage.change_btn(driver).click();
		driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);

		String rePasswordEmpty = changePasswordPage.assert_rePasswordEmpty(
				driver).getText();
		// 全部为空时，判断是否正常
		Assert.assertTrue(rePasswordEmpty.contains("请再次输入密码"));
	}

	/**
	 * 系统设置-修改密码.<br>
	 * 仅设置”再次输入密码“的值
	 * 
	 * @throws Exception
	 */
	@Test
	public void test_ChangePassword3() throws Exception {
		// 登录
		// driver = login(url, mobile, password);
		// ss.systemSettings(driver);

		changePasswordPage.click(driver).click();
		driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);
		// 清除输入的值
		changePasswordPage.repassword(driver).sendKeys("123456");

		// 点击“修改”button
		changePasswordPage.change_btn(driver).click();
		driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);
		String passwordEmpty2 = changePasswordPage.assert_passwordEmpty(driver)
				.getText();
		// 全部为空时，判断是否正常
		Assert.assertTrue(passwordEmpty2.contains("请输入登录密码"));
	}

	/**
	 * 系统设置-修改密码.<br>
	 * 两次密码不一致
	 * 
	 * @throws Exception
	 */
	@Test
	public void test_ChangePassword4() throws Exception {
		// 登录
		// driver = login(url, mobile, password);
		// ss.systemSettings(driver);

		changePasswordPage.click(driver).click();
		driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);
		changePasswordPage.password(driver).sendKeys("111111");
		changePasswordPage.repassword(driver).sendKeys("111112");
		changePasswordPage.change_btn(driver).click();
		
		driver.manage().timeouts().setScriptTimeout(3, TimeUnit.SECONDS);
		
		String repeatPwdError = changePasswordPage
				.assert_repeatPwdError(driver).getText();
		// 两次输入的密码不一致
		Assert.assertTrue(repeatPwdError.contains("两次输入的密码不一致"));
	}

	/**
	 * 系统设置-修改密码.<br>
	 * 密码格式错误，小于6位数
	 * 
	 * @throws Exception
	 */
	@Test
	public void test_ChangePassword5() throws Exception {
		// 登录
		// driver = login(url, mobile, password);
		// ss.systemSettings(driver);

		changePasswordPage.click(driver).click();
		driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);
		changePasswordPage.password(driver).sendKeys("12345");
		changePasswordPage.repassword(driver).sendKeys("12345");
		changePasswordPage.change_btn(driver).click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		String repeatPwdError = changePasswordPage.assert_confirmPwd(driver)
				.getText();
		// 密码格式错误
		Assert.assertTrue(repeatPwdError.contains("密码格式错误"));
	}

	/**
	 * 系统设置-修改密码.<br>
	 * 密码格式错误，大于20位数
	 * 
	 * @throws Exception
	 */
	@Test
	public void test_ChangePassword6() throws Exception {
		// 登录
		// driver = login(url, mobile, password);
		// ss.systemSettings(driver);

		changePasswordPage.click(driver).click();
		driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);
		changePasswordPage.password(driver).sendKeys("123456789012345678901");
		changePasswordPage.repassword(driver).sendKeys("123456789012345678901");
		changePasswordPage.change_btn(driver).click();
		driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);
		String repeatPwdError = changePasswordPage.assert_confirmPwd(driver)
				.getText();
		// 密码格式错误
		Assert.assertTrue(repeatPwdError.contains("密码格式错误"));
	}

	/**
	 * 系统设置-修改密码.<br>
	 * 密码格式错误，含有特殊字符
	 * 
	 * @throws Exception
	 */
	@Test
	public void test_ChangePassword7() throws Exception {
		// 登录
		// driver = login(url, mobile, password);
		// ss.systemSettings(driver);

		changePasswordPage.click(driver).click();
		driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);
		changePasswordPage.password(driver).sendKeys("1234:;");
		changePasswordPage.repassword(driver).sendKeys("1234:;");
		changePasswordPage.change_btn(driver).click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		String repeatPwdError = changePasswordPage.assert_confirmPwd(driver)
				.getText();

		// 密码格式错误
		Assert.assertTrue(repeatPwdError.contains("密码格式错误"));
	}

	/**
	 * 系统设置-修改密码.<br>
	 * 密码格式错误成功
	 * 
	 * @throws Exception
	 */
	@Test
	public void test_ChangePassword_Success() throws Exception {
		// 登录
		// driver = login(url, mobile, password);
		// ss.systemSettings(driver);

		changePasswordPage.click(driver).click();
		driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);
		changePasswordPage.password(driver).sendKeys("~!@#$%^&*()-_=+|{}[]");
		changePasswordPage.repassword(driver).sendKeys("~!@#$%^&*()-_=+|{}[]");
		changePasswordPage.change_btn(driver).click();
		
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		String repeatPwdError = changePasswordPage.assert_success(driver)
				.getText();
		// 修改密码成功
		Assert.assertTrue(repeatPwdError.contains("修改密码成功"));

		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		changePasswordPage.password(driver).sendKeys(",.?123");
		changePasswordPage.repassword(driver).sendKeys(",.?123");
		changePasswordPage.change_btn(driver).click();
		
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		String repeatPwdError2 = changePasswordPage.assert_success(driver)
				.getText();
		// 修改密码成功
		Assert.assertTrue(repeatPwdError2.contains("修改密码成功"));

		driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);
		changePasswordPage.password(driver).sendKeys("123456");
		changePasswordPage.repassword(driver).sendKeys("123456");
		changePasswordPage.change_btn(driver).click();
		
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		String repeatPwdError3 = changePasswordPage.assert_success(driver)
				.getText();
		// 修改密码成功
		Assert.assertTrue(repeatPwdError3.contains("修改密码成功"));
	}

}
