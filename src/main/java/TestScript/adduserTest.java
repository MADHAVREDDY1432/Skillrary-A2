package TestScript;

import java.util.Map;

import org.testng.asserts.SoftAssert;

public class adduserTest {
	SoftAssert soft=new SoftAssert();
	
	home.clickUserTab();
	
	users.clickNewButton();
	soft.assertEquals(adduser.getpageHeader(), "Add New user");

	
	Map<   String,String> map=excel.readFromExcel("add user");
	  
	adduser.setEmail(map.get("Email"))            
	adduser.setPassword(map.get("password"));
	adduser.setFirstname(map.get("Firstname"));
	adduser.setLastname(map.get("Lastname"));
	adduser.setAddress(map.get("Address"));
	adduser.setContectInfo(map.get("contect info"));
	adduser.uploadphoto(map.get("photo"));
 
	addUser.clicksave();
	soft.assertEquals(users.getsuccessMessage(), "success  ");
	soft.assertAll();
	

	
}




	
	


