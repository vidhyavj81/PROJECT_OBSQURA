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
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class UnitPageSeq {
	
	POMLogin objPOMLogin;
	POMUnit objPOMUnit;
	SoftAssert softassert=new SoftAssert();
//	static String url="https://qalegend.com/billing/public/login";
//	static String browser="chrome";
	public static WebDriver driver;
	
	
	@Test(priority=1,enabled=true,dataProvider="testdata")
	public void unitAdd(String name,String shortname) throws Exception {
		LoginPageSeq objlogin=new LoginPageSeq();
		objPOMLogin=new POMLogin(objlogin.driver);
		objPOMUnit=new POMUnit(objlogin.driver);
		
		objPOMUnit.unitDetails();
		//objPOMUnit.addunitDetails("vidya_unit", "vidhya" );
		String objName=name;
		String objShortName=shortname;
		objPOMUnit.addunitDetails(name,shortname);	
	String actualmessage=objPOMUnit.verifySuccessMessage();
	String expectedmessage="Unit added successfully";
	Assert.assertTrue(expectedmessage.contains(actualmessage));
	
	}
	@Test(priority=2,enabled=true)
	public void unitSearch() throws Exception {
	boolean value=objPOMUnit.searchunitDetails(PropertyFileRead.readConfigFile("searchdetails"));
	
	softassert.assertEquals(value, true);
	}	
	
	@Test(priority=3,enabled=true)
	public void deleteunit() throws Exception {
		objPOMUnit.deleteunitDetails();
		String actualmessage=objPOMUnit.verifyDeleteMessage();
		String expectedmessage="Unit deleted successfully";
	softassert.assertTrue(expectedmessage.contains(actualmessage));
	
	}

  @DataProvider(name="testdata")
  public Object[][]TestDataFeed(){
	  //Create object array with 2 rows and 2 column-first parameter is row and second is column
	  Object[][] twitterdata=new Object[1][2];
	  //Enter data to row 0 column 0
	  twitterdata[0][0]="vidya_unit";
	  //Enter data to row 0 column 1
	  twitterdata[0][1]="vidhya";
return twitterdata;
	  }

  }
