package com.TestScenarios;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Objectrepository.Locaters;
import com.Utilities.CommonFunctions;
import com.Utilities.StaticVaraibles;

public class usingMethods extends StaticVaraibles{
	

	CommonFunctions cfn = new CommonFunctions();
	Locaters Obj = new Locaters();
	
	@Test
	public void login() throws IOException {
		// get the data from property file

		String path = "./testData/TD.properties";
		File f = new File(path);
		FileInputStream fi = new FileInputStream(f);

		Properties p = new Properties();
		p.load(fi);
		driver.get(p.getProperty("URL"));
		cfn.sendKeysByanyLocater(Obj.Email_EditBox, p.getProperty("Email"));
	}
	
	@BeforeClass
	
	
	public void chromeBrowserLaunch() throws Exception {
		
		cfn.browserLaunch("chrome");
		//driver.get("www.fb.com");
		
		//cfn.takescreenshot("deepaksample");
		System.out.println("successfully launched Chrome Browser");
	}
	
	@BeforeMethod
	public void beforemethod() throws Exception {
		
		cfn.takescreenshot("dd");
	}
	
	
	@AfterClass
	
	public void afterclass() {
	
	
	driver.close();
	
	}
	
	
	}

	
