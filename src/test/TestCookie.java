package test;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.vchangyi.hr.tool.QiyeLogin;

public class TestCookie extends QiyeLogin {

	public WebDriver driver;

	public String url = "http://www.sogou.com";

	@BeforeClass
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		//driver = new SafariDriver();
		driver.get(url);

	}

	@Test
	public void test_01() throws Exception {
		Set<Cookie> cookies = driver.manage().getCookies();
		Cookie newCookie = new Cookie("cookieName", "cookieValue");
		System.out.println(String
				.format("Domain-> name-> value-> expiry-> path"));

		for (Cookie cookie : cookies) {
			System.out.println(String.format("%s-> %s-> %s-> %s-> %s",
					cookie.getDomain(), cookie.getName(), cookie.getValue(),
					cookie.getExpiry(), cookie.getPath()));

			// 删除cookie有3中方法
			// 第一种，通过Cookie的name属性
			driver.manage().deleteCookieNamed("CookieName");
			// 第二种，通过Cookie对象
			driver.manage().deleteCookie(newCookie);
			// 第三种，全部删除
			driver.manage().deleteAllCookies();

			try {
				Thread.sleep(3000);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	@AfterClass
	public void tearDown() throws Exception {
		driver.quit();
	}
}
