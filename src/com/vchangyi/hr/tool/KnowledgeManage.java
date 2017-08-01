package com.vchangyi.hr.tool;

import org.openqa.selenium.WebDriver;

import com.vchangyi.hr.page.KnowledgeManagePage;

public class KnowledgeManage {

	KnowledgeManagePage knowledgeManage = new KnowledgeManagePage();

	/**
	 * 培训
	 * @param driver
	 * @throws Exception
	 */
	public void cultivate(WebDriver driver) throws Exception {
		// driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		knowledgeManage.subdropActive(driver).click();
	}
}
