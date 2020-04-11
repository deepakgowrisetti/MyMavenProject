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
import java.util.ArrayList;
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

public class AvionTest2 extends StaticVaraibles {
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
		// cfn.sendKeysByanyLocater(obj.Auser_Name, p.getProperty("username"));
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

			cfn.clickByanyLocater(obj.APOS);
			cfn.clickByanyLocater(obj.AGO);
			driver.findElement(obj.APON).clear();
			cfn.sendKeysByanyLocater(obj.APON, s.getCell(0, i).getContents());
			cfn.clickByanyLocater(obj.AGO1);
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

			// for (int j = 1; j < s.getColumns(); j++) {

			// *[@class= 'x1o']

			// get the table values
			// To locate table.
			WebElement mytable = driver.findElement(By.xpath("//*[@class='x1o']/tbody"));
			// To locate rows of table.
			List<WebElement> rows_table = mytable.findElements(By.tagName("tr"));
			WebElement col = driver.findElement(By.xpath("//*[@class='x1o']/tbody/tr/th[3]"));
			// To calculate no of rows In table.
			int rows_count = rows_table.size();// 5
			System.out.println("rowcount :" +rows_count);
			// Loop will execute till the last row of table.
			for (int row = 2; row <= rows_count; row++) {
				if (col.isDisplayed()) {
					String myrowXpath1 = "//*[@class='x1o']/tbody/tr[";
					String myrowXpath2 = "]/td[3]";
					String myXpath = myrowXpath1 + row + myrowXpath2;
					System.out.println("MyXpath is :"+myXpath);
					if (driver.findElements(By.xpath(myXpath)).size() > 0) {
						String lineNo =driver.findElement(By.xpath(myXpath)).getText();
						System.out.println("Lineno :"+lineNo);
						System.out.println("Excelvalue : "+s.getCell(1, i).getContents());
						if (lineNo.equals(s.getCell(1, i).getContents())) {
							
							String xpath = "//*[@class='x1o']/tbody/tr[";  
							String xpath1 = "]/td[1]";
							
							String xpath2 = xpath + row + xpath1;
							System.out.println("Xpath2 :" +xpath2);
							driver.findElement(By.xpath(xpath2)).click();//*[@class='x1o']/tbody/tr[2]/td[1]
						}
					}
				} else {
					System.out.println("3rd Column is not displayed in the table :");
				}
			}//for loop ends

//			String xpath = "//*[@class= 'x1o']/tbody/tr[";
//			String xpath1 = "]/td[1]";
//			String excelvalue = s.getCell(1, i).getContents();
//			String xpath2 = xpath + excelvalue + xpath1;
//
//			System.out.println(" Excel Value :" + excelvalue);
//			driver.findElement(By.xpath(xpath2)).click();// *[@class= 'x1o']/tbody/tr[2]/td[1]
//
			Thread.sleep(5000);
			driver.findElement(By.xpath("(//button[@title = 'Next'])[2]")).click();
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//*[@id = 'InvoiceNum']")).sendKeys(s.getCell(2, i).getContents());
			driver.findElement(By.xpath("//*[@id = 'InvDesc']")).sendKeys(s.getCell(3, i).getContents());
			//driver.findElement(By.xpath("//*[@id = 'N3:QUANTITY:0']")).sendKeys(s.getCell(4, i).getContents());

			cfn.clickByJSE(By.xpath("(//button[@title ='Next'])[1]"));
			// driver.findElement(By.xpath("(//button[@title ='Next'])[1]")).click();
			Thread.sleep(5000);
			cfn.clickByJSE(By.xpath("(//button[@title ='Next'])[1]"));
			cfn.clickByJSE(By.xpath("//button[@id= 'CancelButton']"));
			cfn.clickByanyLocater(By.xpath("//*[@id = 'POS_HOME']"));
			System.out.println("loop complete");

			// }

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
		// driver.quit();
	}

}
