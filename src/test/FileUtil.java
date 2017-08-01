package test;

import java.io.File;
import java.io.IOException;

public class FileUtil {
	public static boolean createFile(String testFileName) {
		File file = new File(testFileName);
		if (file.exists()) {
			System.out.println("创建单个文件" + testFileName + "失败，目标文件已存在！");
			return false;
		}
		if (testFileName.endsWith(File.separator)) {
			System.out.println("创建单个文件" + testFileName + "失败，目标文件不能为空目录！");
			return false;
		}
		if (!file.getParentFile().exists()) {
			System.out.println("父文件不存在，准备创建它！");
			if (!file.getParentFile().mkdirs()) {
				System.out.println("创建目标文件所在目录失败！");
			}
		}

		// 创建目标文件
		try {
			if (file.createNewFile()) {
				System.out.println("创建单个文件" + testFileName + "成功！");
				return true;
			} else {
				System.out.println("创建单个文件" + testFileName + "失败！");
				return false;
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.out
					.println("创建单个文件" + testFileName + "失败！" + e.getMessage());
			return false;
		}
	}
	
	public static boolean creatDir(String pathname){
		File dir = new File(pathname);
		if(dir.exists()){
			System.out.println("创建目录" + pathname + "失败,目标目录已存在");
			return false;
		}
		
		if(dir.mkdirs()){
			System.out.println("创建目录" + pathname + "成功！");
			return true;
		}else{
			System.out.println("创建目录" + pathname + "失败！");
			return false;
		}
		
	}
}
