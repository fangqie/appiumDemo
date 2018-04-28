package com.daisy.se;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Main_AppTest {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		// TODO Auto-generated method stub
		
				String deviceName = "emulator-5554";
				String platformVersion = "7.0";
				
				String AppiumServerIP = "http://127.0.0.0:4723/wd/hub";
				String apkName1 = "FaceDemo.apk";
				String appActivity1 = "com.iflytek.facedemo.MainActivity";
								
				AndroidDriver driver;
				
				File apk = new File(System.getProperty("user.dir")+File.separator+"apps"+File.separator+apkName1);
				
				DesiredCapabilities capabilities = new DesiredCapabilities();
				capabilities.setCapability("deviceName", deviceName);
				capabilities.setCapability("platformVersion", platformVersion);
				capabilities.setCapability("app", apk.getAbsolutePath());
				capabilities.setCapability(MobileCapabilityType.APP, apk.getAbsolutePath());
				capabilities.setCapability("appActivity", appActivity1);
				capabilities.setCapability("noSign", true);
				capabilities.setCapability("noReset", true);
				//每次启动时覆盖session，否则第二次后运行会报错不能新建session
				capabilities.setCapability("sessionOverride", true);
				driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);		
				
				Thread.sleep(3000);
				System.out.println("App启动等待时间");
				Thread.sleep(4000);
				
				driver.findElementById("com.iflytek.facedemo:id/btn_online_demo").click();
				System.out.println("按钮点击成功！");
				
				Thread.sleep(4000);
				driver.findElementById("com.iflytek.facedemo:id/online_authid").sendKeys("111");	
				System.out.println("元素输入成功！");
				
				Thread.sleep(2000);
				//driver.close();
				driver.quit();

		

	}

}
