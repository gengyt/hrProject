package test;

import org.apache.log4j.Logger;

public class Log {
	// 初始化一个Logger对象
	private static Logger log = Logger.getLogger(Log.class.getName());

	// 定义一个静态方法，可以打印自定义的某个测试用例开始执行的日志信息
	public static void startTestCase(String sTestCaseName) {
		log.info("-----------------------------");
		log.info("******         " + sTestCaseName + "         ******");
	}

	// 定义一个静态方法，可以打印自定义的某个测试用例结束执行的日志信息
	public static void endTestCase(String sTestCaseName) {
		log.info("****** " + "执行用例结束" + "******");
		log.info("-----------------------------");
	}

	// 定义一个静态info方法，打印自定义的info级别日志信息
	public static void info(String message) {
		log.info(message);
	}

	// 定义一个静态info方法，打印自定义的warn级别日志信息
	public static void warn(String message) {
		log.warn(message);
	}

	// 定义一个静态info方法，打印自定义的error级别日志信息
	public static void error(String message) {
		log.error(message);
	}

	// 定义一个静态info方法，打印自定义的fatal级别日志信息
	public static void fatal(String message) {
		log.fatal(message);
	}

	// 定义一个静态info方法，打印自定义的debug级别日志信息
	public static void debug(String message) {
		log.debug(message);
	}
}
