package com.TestScenarios;

import org.testng.annotations.Test;

import com.Objectrepository.Locaters;
import com.Utilities.CommonFunctions;
import com.Utilities.StaticVaraibles;

import jxl.Sheet;
import jxl.Workbook;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;

public class AvionTest extends StaticVaraibles {
	// WebDriver driver;

	// create reference of CommonFunctions class to re-use of functions
	CommonFunctions cfn = new CommonFunctions();
	Locaters obj = new Locaters();

	@Test // 2
	public void login() throws IOException, Exception {
		// get the data from property file

		String path = "./testData/avion.properties";
		File f = new File(path);
		FileInputStream fi = new FileInputStream(f);

		Properties p = new Properties();
		p.load(fi);
		driver.get(p.getProperty("AURL"));
		//cfn.sendKeysByanyLocater(obj.Auser_Name, p.getProperty("username"));
		driver.findElement(obj.Auser_Name).clear();
		cfn.sendKeysByanyLocater(obj.Auser_Name, p.getProperty("userName"));
		driver.findElement(obj.Apwd).clear();
		cfn.sendKeysByanyLocater(obj.Apwd, p.getProperty("Pwd"));
		cfn.clickByanyLocater(obj.ASubmit);
		

		File f1 = new File("./testData/testdata1.xls");
		FileInputStream fi1 = new FileInputStream(f1);

		Workbook w = Workbook.getWorkbook(fi1);
		Sheet s = w.getSheet(0);

		for (int i = 1; i < s.getRows(); i++) {
			
			//driver.findElement(obj.Auser_Name).clear();
			//cfn.sendKeysByanyLocater(obj.Auser_Name, s.getCell(0, i).getContents());
			//driver.findElement(obj.Apwd).clear();
			//cfn.sendKeysByanyLocater(obj.Apwd, s.getCell(1, i).getContents());
			//cfn.clickByanyLocater(obj.ASubmit);
			//Thread.sleep(5000);
			cfn.clickByanyLocater(obj.APOS);
			cfn.clickByanyLocater(obj.AGO);
			driver.findElement(obj.APON).clear();
			cfn.sendKeysByanyLocater(obj.APON, s.getCell(0, i).getContents());
			//driver.findElement(By.xpath("@adf")).sendKeys(s.getCell(lo);
			cfn.clickByanyLocater(obj.AGO1);
			
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			
			// WebElement a  = driver.findElement(By.id("OASH__566"));
			//System.out.println(a);
			
			for(int j = 1; j <s.getColumns();j++) {
				
			String xpath = "//*[@class= 'x1o']/tbody/tr[";
			String xpath1 = "]/td[1]";	
			String excelvalue = s.getCell(1,i).getContents();
			String xpath2 = xpath+excelvalue+xpath1;
			
			System.out.println(" Excel Value :"+excelvalue);
			
			driver.findElement(By.xpath(xpath2)).click();//*[@class= 'x1o']/tbody/tr[2]/td[1]
			
			
			/*String datatablevalue  = driver.findElement(By.xpath("//*[@class= 'x1o']/tbody[1]/tr[2]/td[3]")).getText();
			System.out.println("value: "+datatablevalue);
			
			if (excelvalue.equals(datatablevalue) ) {
			
			
			}
			System.out.println("Missmatch");*/
			//*[@id="ItemsTable"]/table[2]/tbody/tr[2]/td[1]
			
			
			Thread.sleep(5000);
			driver.findElement(By.xpath("(//button[@title = 'Next'])[2]")).click();
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			
			driver.findElement(By.xpath("//*[@id = 'InvoiceNum']")).sendKeys(s.getCell(2,i).getContents());
			driver.findElement(By.xpath("//*[@id = 'InvDesc']")).sendKeys(s.getCell(3,i).getContents());
			driver.findElement(By.xpath("//*[@id = 'N3:QUANTITY:0']")).sendKeys(s.getCell(4,i).getContents());
			//Thread.sleep(2000);
			//driver.findElement(By.id("CancelButton")).click();
			//driver.findElement(By.("(//*[@class = 'x7n'])[3]")).click();
			//By.xpath("(//*[@class = 'x7n'])[4]");
			
			//*[@id="PgBtnBarRN_uixr"]/tbody/tr/td[8]/butto
			//html/body/form/span[2]/div/div[3]/div[2]/table/tbody/tr[1]/td[2]/table/tbody/tr/td[8]/button

			}
			
		//driver.findElement(By.linkText(linkText))
			
			//cfn.loopAllframesAndReturnCountofElement(By.xpath(xpathExpression));
		
		//cfn.loopAllframesAndReturnCountofElement(By.xpath("//*[@name= 'emailUserName']"));
		
		    //driver.findElement(By.xpath("//*[@name= 'emailUserName'")).click();
			
			//no.of columns
			/*List cols = driver.findElements(By.xpath("//*[@id= 'OASH__26078']"));
			System.out.println("No.of cols: "+cols);
			
			List rows= driver.findElements(By.xpath("//*[@id= 'ItemsTable']/table[2]/tbody/tr[2]/td[2]"));
			System.out.println("No.of rows:" +rows);*/
			
			//driver.findElement(By.xpath("//*[@id= 'PoShipmentsTableRN']/table[2]/tbody/tr[2]/td[1]/input")).click();
			//driver.findElement(By.xpath("//*[@id= 'PageActionBarRN_uixr']/tbody/tr/td[6]/button")).click();
			//driver.findElement(By.xpath("//*[@id= 'InvoiceNum']")).
			
			
//*[@id="ItemsTable"]/table[2]/tbody/tr[2]/td[2]
			
			//Thread.sleep(5000);
		/*	// validate whether given credentials are valid or not?
			if (driver.findElements(By.xpath("//a[text()='Create New Account']")).size() > 0 
					|| driver.findElements(By.xpath("//a[text()='Sign Up']")).size() > 0 ) {
				System.out.println("Given credentials are InValid");
				//Recall your home page
				driver.get(p.getProperty("URL"));
			} else {
				System.out.println("Given credentials are Valid");
			}*/

		} // for loop end

	}

	@AfterMethod // 3
	public void afterMethod(ITestResult res) throws Exception {
		// cfn.takescreenhot("fbLogin");
		cfn.takescreenshotPassorFail(res);

	}

	@Parameters("browser")
	@BeforeClass // 1
	public void beforeClass(@Optional("chrome") String browser) {
		cfn.browserLaunch(browser);

	}

	@AfterClass // 4
	public void afterClass() {
		//driver.quit();
	}

}
