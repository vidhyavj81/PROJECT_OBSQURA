package sequentialTestCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import commonUtility.PropertyFileRead;
import excelUtility.ExcelRead;
import pomClasses.POMBrand;
import pomClasses.POMCategories;
import pomClasses.POMLogin;
import pomClasses.POMUnit;
import webdriverUtility.Driver;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class BrandPageSeq {
	POMLogin objPOMLogin;
	POMUnit objPOMUnit;
	POMCategories objPOMCategories;
	POMBrand objPOMBrand;
	
	static String url="https://qalegend.com/billing/public/login";
	static String browser="chrome";

	public static WebDriver driver;
	
	
	@Test(priority=1,enabled=true,dataProvider="testdata")
	public void brandAdd(String namebrand,String descbrand)throws InterruptedException{
		LoginPageSeq objloginSeq=new LoginPageSeq();
		objPOMLogin=new POMLogin(objloginSeq.driver);
		objPOMUnit=new POMUnit(driver);
		objPOMCategories=new POMCategories(objloginSeq.driver);
		objPOMBrand=new POMBrand(objloginSeq.driver);
		objPOMBrand.branddetails();
		//objPOMBrand.addbranddetails("celto","kitchen");
		String objNameBrand=namebrand;
		String objDescBrand=descbrand;
		objPOMBrand.addbranddetails(namebrand,descbrand);	
	    String expectedmessage="Brand added successfully";
		String actualmessage=objPOMBrand.brandmessage;
		Assert.assertTrue(expectedmessage.contains(actualmessage));
	}
		@Test(priority=2,enabled=true)
		public void brandSearch()throws InterruptedException{
		
		boolean value2=objPOMBrand.searchBrandDetails(PropertyFileRead.readConfigFile("searchdetailsbrand"));
		Assert.assertEquals(value2, true);
		}
		 @AfterTest
		 public void afterTest() {
			 driver.close();
		 }
	
  @DataProvider(name="testdata")
  public Object[][]TestDataFeed(){
	  //Create object array with 2 rows and 2 column-first parameter is row and second is column
	  Object[][] twitterdata=new Object[1][2];
	  //Enter data to row 0 column 0
	  twitterdata[0][0]="celto";
	  //Enter data to row 0 column 1
	  twitterdata[0][1]="kitchen";
return twitterdata;
	  }

  }
