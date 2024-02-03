package TestScript;

import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericUtilities.BaseClass;
import genericUtilities.IConstantpath;
// this class verify if user is able to add courses
public class AddCourseTest extends BaseClass  {



	@Test
	public AddCourseTest()  {
		SoftAssert soft=new SoftAssert();
		
		home.clickCoursesTab();
		home.clickCourseListLink();
		courseList.clickNewButton();
		
		soft.assertEquals(addcourse.getpageHeader(), "Add New course");
		
		
		Map< String ,String>map=excel.readFormExcel("add course");
			addcourse.setName(map.get("name"));
		addcourse.selectCategory(web,map.get("Category"));
		addcourse.setprice(map.get("price"));
		addcourse.setDiscription(map.get("discription"),web);
		addcourse.clickSave();
		soft.assertEquals(addcourse.getsuccessMessage(), "success");

		System.out.println(courseList.getsuccessMessage());
		courseList.deletecourse(web,map.get("name"));
		System.out.println(courseList.getsuccessMessage());
		soft.assertEquals(addcourse.getsuccessMessage(), "success");
		
		if(courseList.getsuceesMessage().equals("success"))
			excel.updateTestStatus("Add course","pass",IConstantpath.EXCEL_PATH);
		else
			excel.updateTestStatus("Add course","fail",IConstantpath.EXCEL_PATH);
		soft.assertAll();

			

		
		
		
	}

}
