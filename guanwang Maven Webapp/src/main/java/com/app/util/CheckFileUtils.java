package com.app.util;

/**
 * 这是一个检查文件是否合法的类
 * @author 李洋
 *
 */
public class CheckFileUtils {

	private static final String excelSuffixs[]={".xls",".xlsx"};
	private static final String picture[]={".jpg",".jpeg",".png",".bmp",".tif",".psd",".svg",
		".PNG",".JPG",".JPEG",".BMP",".TIF",".PSD",".SVG"};
	//private static final String type;
	/**
	 * 检查上传文件是否是excel文件
	 * @param fileSuffixName
	 * @return
	 */
	public static boolean checkExcel(String fileSuffixName){
		
		//1.遍历符合标准的后缀
		for (String excelSuffix : excelSuffixs) {
			//2.判断是否是符合标准的excel文件
			if(excelSuffix.equals(fileSuffixName)){
				return true;
			}
		}
		//3.上传的文件不合法
		return false;
	}
	/**
	 * 检查上传文件是否是picture文件
	 * @param fileSuffixName
	 * @return
	 */
	public static boolean checkPicture(String fileSuffixName) {
		//1.遍历符合标准的后缀
		for (String excelSuffix : picture) {
			//2.判断是否是符合标准的picture文件
			if(excelSuffix.equals(fileSuffixName)){
				return true;
			}
		}
		//3.上传的文件不合法
		return false;
	}
}
