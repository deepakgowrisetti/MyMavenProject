package com.Objectrepository;



import org.openqa.selenium.By;

public class Locaters {

	public static final By Email_EditBox = By.id("email");
	public static final By Password_EditBox = By.id("CustomerPassword");
	public static final By Login_Button = By.id("loginbutton");
	public static final By signin_icon = By.xpath("//a[@href='/account/login']");
	public static final By Login_Button_1 = By.id("customer_login");
	public static final By Login_Button_2 = By.xpath("//*[@value = 'Sign In']");
	public static final By View_address = By.xpath("//a[contains(text(),'View Addresses')]");
	public static final By delete_address = By.xpath("(//*[contains(@class,'address-delete')])[1]");
	public static final By edit_address = By.xpath("(//*[contains(@class,'edit-toggle')])[1]");
	//*[@class ='btn' ] 
	
	//for Contact screen
	
	public static final By contact_name = By.id("ContactForm-name");
	public static final By Contact_email= By.id("ContactForm-email");
	public static final By contact_phone = By.id("ContactForm-phone");
	public static final By contact_message = By.id("ContactForm-message");
	
	//*[@id="MainContent"]/div[2]/div/div/div[2]/p[1]/text()[1]
	
	

	public static final By first_Name = By.id("firstname");
	public static final By last_Name = By.id("lastname");
	public static final By email_1 = By.id("uname");
	public static final By mobile = By.id("mobile");
	public static final By pwd = By.id("password");
	public static final By cnf_Pwd = By.id("cnf_password");
	public static final By submit = By.xpath("(//*[@type='submit'])[1]");
	
	//Frame URL
	public static final By zonal_Link = By.name("P-24Alist");
	public static final By lastUpdate = By.xpath("/html/body/table/tbody/tr[8]/td[2]/span");
	
	
	//Avion
	public static final By Auser_Name = By.id("unamebean");
	public static final By Apwd = By.id("pwdbean");
	public static final By ASubmit = By.id("SubmitButton");
	//public static final By APOS = By.id("POS_PRODUCT");
	public static final By APOS = By.xpath("(//*[@id = 'POS_ACCOUNT'])[1]");
	public static final By AGO	= By.id("CreateInvBtn");
	public static final By APON = By.id("PoNumber");
	public static final By AGO1 = By.xpath("(//*[@class = 'x7n'])[4]");
	
	//Ariba
	public static final By Ari_user = By.xpath("//input[@name= 'UserName']");	
	public static final By Ari_pwd = By.xpath("//input[@id= 'Password']");	
	public static final By Ari_Submit = By.xpath("//input[@type= 'submit']");
	public static final By Pro_Quest = By.xpath("(//button[@class= 'fd-product-menu__control'])[1]");
	//fd-product-menu__control
	
	//public static final By fd_Menu = By.xpath("//a[@class= 'fd-menu__item app-menuitem-text'])[3]");
	//(//a[@class= 'fd-menu__item app-menuitem-text'])[3]
	//fd-menu__item app-menuitem-text
	//public static final By fd_Menu = By.linkText("fd-menu__item app-menuitem-text");
	public static final By fd_Menu = By.xpath("/html/body/div[5]/table/tbody/tr[1]/td/div/div/div/div[1]/div/div/div/div/div[2]/nav/ul/li[4]/a");
	public static final By fd_inbox = By.xpath("(//*[@class = 'w-tabitem-a'])[2]");
	public static final By Menu_Ord_rel = By.id("_vilcyd");
	public static final By Search_Fil = By.xpath("//*[@id= '_y9ecwd']");
	public static final By Exact_num = By.xpath ("(//*[@id= '_h8bvdb']/div[2])");  //radio button
	//(//*[@class = 'w-rdo w-rdo-dsize'])[2]
	public static final By Ord_Txtbox = By.id("_qrdcnd");
	public static final By inbox_button = By.xpath("//button[@class= 'w-btn w-btn-primary']");
	
	public static final By OR_radiobutton = By.xpath("html/body/div[5]/div[3]/table/tbody/tr/td[1]/table/tbody/tr[4]/td/table/tbody/tr/td/div/div/div/table/tbody/tr/td/span/div/div/table/tbody/tr/td/div/div/div[2]/div/div/table/tbody/tr/td/form/table/tbody/tr[2]/td/div[1]/table/tbody/tr[2]/td/table/tbody/tr[2]/td[1]/div");
	
	//create invoice_invoice header
	
	//driver.findElement(By.id("_kipfyb")).sendKeys("Test");
	public static final By Invoice_Text = By.id("_kipfyb");
	public static final By Invoice_date = By.id("DF_8de92b");
	//driver.findElement(By.id("_dmad7d")).click();//remove button
	public static final By Invoice_email = By.xpath("//*[@id = '_vcdb9']");
	//*[@id="_vcdb9"]
	
	//AIM
	public static final By Aim_User  = By.id("asPrimary_ctl00_txtLoginId");
	public static final By Aim_Pwd  = By.id("asPrimary_ctl00_txtPassWord");
	public static final By Aim_Submit  = By.id("asPrimary_ctl00_btnSubmit");
	public static final By Aim_agree =  By.id("asPrimary_ctl00_cmdAgreeContinue");
	
	
	
	
	
	
}