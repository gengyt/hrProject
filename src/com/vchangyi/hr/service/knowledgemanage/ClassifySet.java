package com.vchangyi.hr.service.knowledgemanage;

/**
 * 对“培训/ 分类设置”页面进行操作.
 */
import static org.testng.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.vchangyi.hr.page.ClassifyAddPage;
import com.vchangyi.hr.page.ClassifyEditPage;
import com.vchangyi.hr.page.ClassifySetPage;
import com.vchangyi.hr.page.PeiXunPage;
import com.vchangyi.hr.tool.KnowledgeManage;
import com.vchangyi.hr.tool.MyApp;
import com.vchangyi.hr.tool.QiyeLogin;

public class ClassifySet extends QiyeLogin {

	public WebDriver driver;

	// 我的应用
	MyApp myapp = new MyApp();
	// 培训
	KnowledgeManage km = new KnowledgeManage();

	PeiXunPage peixun = new PeiXunPage();

	ClassifySetPage classifySetPage = new ClassifySetPage();
	
	ClassifyEditPage classifyEditPage = new ClassifyEditPage();
	
	ClassifyAddPage classifyAddPage = new ClassifyAddPage();
	
	StringBuffer verificationErrors = new StringBuffer();

	public String url = "http://thr.vchangyi.com/admincp/#/login";

	public String mobile = "13585672975";

	public String password = "123456";

	@BeforeClass
	public void setUp() throws Exception {

		driver = login(url, mobile, password);
		// 我的应用
		// myapp.application(driver);
		Thread.sleep(1000);
		// 培训
		km.cultivate(driver);
	}

	/**
	 * 关闭浏览器。
	 * 
	 * @throws Exception
	 */
	@AfterClass
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	/**
	 * 我的应用-培训.<br>
	 * 分类设置,操作=添加
	 * 
	 * 
	 * @throws Exception
	 */
	@Test
	public void test_addContent() throws Exception {
		// 点击“分类设置”
		peixun.mdSettingsClick(driver).click();

		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		// 添加操作
		classifySetPage.addBox(driver).click();
		driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);
		// 标题
		classifyAddPage.addTitle(driver).sendKeys("子培训");
		// 排序号
		classifyAddPage.author(driver).sendKeys("1");

		classifyAddPage.releaseBtn(driver).click();

		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

		String classifyTitle = classifySetPage.classifyTitle(driver).getText();
		Assert.assertTrue(classifyTitle.contains("添加分类"));

	}

	/**
	 * 我的应用-培训.<br>
	 * 分类设置,操作=编辑
	 * 
	 * @throws Exception
	 */
	@Test
	public void test_editContent() throws Exception {
		// 点击“分类设置”
		peixun.mdSettingsClick(driver).click();
		driver.manage().timeouts().pageLoadTimeout(1, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		// 编辑操作
		classifySetPage.editBox(driver).click();

		// 标题
		classifyEditPage.addTitle(driver).clear();
		classifyEditPage.addTitle(driver).sendKeys("全公司制度培训_改");
		// 排序号
		classifyEditPage.author(driver).clear();
		classifyEditPage.author(driver).sendKeys("2");

		// 发布
		classifyEditPage.releaseBtn(driver).click();

		String classifyTitle = classifySetPage.classifyTitle(driver).getText();
		Assert.assertTrue(classifyTitle.contains("添加分类"));

	}

	/**
	 * 我的应用-培训.<br>
	 * 分类设置,操作=删除
	 * 
	 * @throws Exception
	 */
	@Test
	public void test_delContent() throws Exception {
		driver.manage().timeouts().pageLoadTimeout(1, TimeUnit.SECONDS);
		// 点击“分类设置”
		peixun.mdSettingsClick(driver).click();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

		// 已有分类的个数
		int haveCount = classifySetPage.classifyList(driver).size();
		System.out.println("haveCount ：" + haveCount);
		if (haveCount > 1) {
			// 删除操作
			classifySetPage.delBox(driver).get(haveCount - 1).click();
			driver.switchTo();
			classifySetPage.popConfirm(driver).click();

			String delSuccess = classifySetPage.assert_del(driver).getText();
			Assert.assertTrue(true, delSuccess.concat("删除成功"));
			driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
			int nowCount = classifySetPage.classifyList(driver).size();
			Assert.assertEquals(haveCount - 1, nowCount);
		}

	}
}
