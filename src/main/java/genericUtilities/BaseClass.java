package genericUtilities;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import genericUtilities.Webdriverutility.WebDriverUtility;
import pomPages.AddCatagoryPage;
import pomPages.AddNewCoursePage;
import pomPages.AddNewUsrPage;
import pomPages.CategoryPage;
import pomPages.CourseListPage;
import pomPages.HomePage;
import pomPages.LoginPage;
import pomPages.UserPage;

public class BaseClass<newCategory, newUser, CategoryListPage, AddNewCatagoryPage, excel>{

	protected WebDriver driver;
	protected propertiesUtility property;
	protected JavaUtility jutil;
	protected WebDriverUtility web;
	protected ExcelUtility excel;

	protected LoginPage login;
	protected HomePage home;
	protected UserPage user;
	protected CourseListPage course;
	protected CategoryPage category;
	protected AddNewUsrPage newUser;
	protected AddNewCoursePage newCourse;
	protected AddCatagoryPage newCategory;
	
	protected static WebDriver sdriver;
	protected static JavaUtility sjutil;
		

	// @BeforeSuite--->As there are no configuration settings or Database
	// connections this annotations are not used
	// @BeforeTest---->As there are no parallel executions this annotations are not
	// used
	@BeforeClass
	public void classSetup() {
		web = new WebDriverUtility();
		jutil = new JavaUtility();
		property = new propertiesUtility();
		excel = new ExcelUtility();

		property.propertiesInit(IConstantpath.PROPRTIES_FILE_PATH);

		driver = web.launchBrowserAndMaximize(property.readFromproperties("browser"));
		web.waitTillElementFound(Long.parseLong(property.readFromproperties("timeouts")));
		sdriver=driver;
        sjutil=jutil;
	}

	@BeforeMethod
	public <category> void methodSetup() {
		login = new LoginPage(driver);
		home = new HomePage(driver);
		user = new UserPage(driver);
		course = new CourseListPage(driver);
		category = new CategoryPage(driver);
		newUser = new AddNewUsrPage(driver);
		newCourse = new AddNewCoursePage(driver);
		newCategory = new  AddCatagoryPage(driver);

		excel.excelInit(IConstantpath.EXCEL_PATH, "sheet1");

		web.navigateToApp(property.readFromproperties("url"));
		Assert.assertEquals(login.getPageHeader(),"Login");

		login.loginToApp(property.readFromproperties("username"), property.readFromproperties("password"));
		Assert.assertEquals(home.getPageHeader(),"Home");
		
        
	}

	@AfterMethod
	public void methodTearDown() {
		excel.closeExcel();
		home.signoutOfApp();
	}

	@AfterClass
	public void classTearDown() {
		web.quitAllWindows();
	}
	// @AfterTest
	// @AfterSuite

}