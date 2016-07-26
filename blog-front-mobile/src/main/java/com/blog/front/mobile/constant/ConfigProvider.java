package com.blog.front.mobile.constant;

/**
 * 常量配置类
 */
public class ConfigProvider {

	public static String STATIC_URL = "";
	
	public static String RESOURCE_URL = "";
	
	
	private ConfigProvider(){
		
	}
	
	public void init(){
		
	}

	public void setSTATIC_URL(String staticURL) {
		STATIC_URL = staticURL;
	}

	public void setRESOURCE_URL(String resource_URL) {
		RESOURCE_URL = resource_URL;
	}

}
