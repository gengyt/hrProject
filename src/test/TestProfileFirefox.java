package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.vchangyi.hr.tool.QiyeLogin;

public class TestProfileFirefox extends QiyeLogin {

	public WebDriver driver;

	public String url = "http://www.baidu.com";

	@BeforeClass
	public void setUp() throws Exception {
		ProfilesIni allProfiles = new ProfilesIni();
		FirefoxProfile profile = allProfiles.getProfile("default");
		driver = new FirefoxDriver(profile);
		driver.get(url);

	}

//	@AfterClass
	public void tearDown() throws Exception {
		driver.quit();
	}
	
	@Test
	public void test01() throws Exception {
		
	}
}
