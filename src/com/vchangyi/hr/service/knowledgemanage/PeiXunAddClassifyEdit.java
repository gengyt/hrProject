package com.vchangyi.hr.service.knowledgemanage;
/**
 * 对“培训/ 分类设置/ 添加分类”页面进行操作
 */
import static org.testng.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.vchangyi.hr.page.ClassifyAddPage;
import com.vchangyi.hr.page.ClassifySetPage;
import com.vchangyi.hr.page.PeiXunPage;
import com.vchangyi.hr.tool.KnowledgeManage;
import com.vchangyi.hr.tool.MyApp;
import com.vchangyi.hr.tool.QiyeLogin;

public class PeiXunAddClassifyEdit extends QiyeLogin {

	public WebDriver driver;

	// 我的应用
	MyApp myapp = new MyApp();
	// 培训
	KnowledgeManage km = new KnowledgeManage();
	
	PeiXunPage peixun = new PeiXunPage();
	
	ClassifySetPage classifySetPage = new ClassifySetPage();
	
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
	 * 分类设置-新建一级分类 标题为空
	 * 
	 * @throws Exception
	 */
	@Test
	public void test_addClassify() throws Exception {
		// 点击“分类设置”
		peixun.mdSettingsClick(driver).click();
		driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);
		// 点击“新建一级分类”
		peixun.addOneClassify(driver).click();
		driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);

		// 排序号
		classifyAddPage.author(driver).sendKeys("1");

		classifyAddPage.releaseBtn(driver).click();
//		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
//		driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);
//		Thread.sleep(3000);
		String titleEmpty = classifyAddPage.assert_Title(driver).getText();

		// 全部为空时，判断是否正常
		Assert.assertEquals(titleEmpty, "标题不能为空");

		// 点“返回”button
		classifyAddPage.returnBtn(driver).click();

		String classifyTitle = classifySetPage.classifyTitle(driver).getText();
		Assert.assertTrue(classifyTitle.contains("添加分类"));
		;

	}

	/**
	 * 我的应用-培训.<br>
	 * 全公司培训,启用分类=是
	 * 
	 * @throws Exception
	 */
	@Test
	public void test_addAllClassify() throws Exception {
		driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);
		// 点击“分类设置”
		peixun.mdSettingsClick(driver).click();
		driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);
		// 点击“新建一级分类”
		peixun.addOneClassify(driver).click();
		driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);

		// 标题
		classifyAddPage.addTitle(driver).sendKeys("全公司制度培训");
		// 排序号
		classifyAddPage.author(driver).sendKeys("1");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		// 发布
		classifyAddPage.releaseBtn(driver).click();

		String classifyTitle = classifySetPage.classifyTitle(driver).getText();
		Assert.assertTrue(classifyTitle.contains("添加分类"));

	}

	/**
	 * 我的应用-培训.<br>
	 * 全公司培训,启用分类=否
	 * 
	 * @throws Exception
	 */
	@Test
	public void test_addAllClassifyNo() throws Exception {
		// 点击“分类设置”
		peixun.mdSettingsClick(driver).click();
		driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);
		// 点击“新建一级分类”
		peixun.addOneClassify(driver).click();
		driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);

		// 标题
		classifyAddPage.addTitle(driver).sendKeys("全公司制度培训否");
		// 排序号
		classifyAddPage.author(driver).sendKeys("1");

		// 启用分类=否
		classifyAddPage.NoOpen(driver).click();

		// 发布
		classifyAddPage.releaseBtn(driver).click();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		String classifyTitle = classifySetPage.classifyTitle(driver).getText();
		Assert.assertTrue(classifyTitle.contains("添加分类"));

	}

	/**
	 * 我的应用-培训.<br>
	 * 指定部门培训
	 * 
	 * @throws Exception
	 */
	@Test
	public void test_addDepartmentClassify() throws Exception {

		driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);
		// 点击“分类设置”
		peixun.mdSettingsClick(driver).click();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		// 已有分类的个数
		int haveCount = classifySetPage.classifyList(driver).size();

		// 点击“新建一级分类”
		peixun.addOneClassify(driver).click();
		driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);

		// 标题
		classifyAddPage.addTitle(driver).sendKeys("指定部门培训");
		// 排序号
		classifyAddPage.author(driver).sendKeys("1");

		// 内容分类
		classifyAddPage.chooseCheck(driver).click();

		driver.switchTo();

		// 部门
		classifyAddPage.dialog_tabSwitch(driver).click();

		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		// 部门-淘金子
		classifyAddPage.dialog_dpName(driver).click();

		// 确认
		classifyAddPage.dialog_btnPrimary(driver).click();

		driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);
		// 发布
		classifyAddPage.releaseBtn(driver).click();
		driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);
		// 追加分类之后的个数
		int nowCount = classifySetPage.classifyList(driver).size();
		Assert.assertEquals(haveCount + 1, nowCount);

	}
}
