package TestScript;

import java.util.Map;

import org.testng.asserts.SoftAssert;

import genericUtilities.BaseClass;

public class AddCatgoryTest extends BaseClass {
	public void addcategorytest() {
		SoftAssert soft=new SoftAssert();
		home.clickCoursesTab();
		home.clickcategoryLink();
		soft.assertEquals(category.getPageHeader(), "category");
		
		category.clickNewButton();
		soft.assertEquals(Addcategory.getpageheader(), "AddNewCategory");
		Map< String,String>map=excel.readFormExcel("AddCategory");
		addcategory.setName(map.get("Name"));
		addcategory.clicksave();
		 
		
		
	}
	

}
