package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewUsrPage {
	//Declaration
		@FindBy (xpath = "//b[text()='Ass New User']")
		private WebElement pageHeader;
		
		@FindBy (xpath = "//input@id = 'email' and @required]")
		private WebElement emailTF;
		
		@FindBy(xpath="//input[@id='firstname' and @required]")
		private WebElement lastnameTF;
		
		@FindBy (xpath = "//textarea[@id='address']")
		private WebElement addressTextArea;
		
		@FindBy(xpath = "//input[@id='contact']")
		private WebElement contactInfoTF;
		 
		@FindBy (xpath = "(//input [@id='photo'])[2]")
		private WebElement photoUploadButton;
		
		@FindBy (xpath = "(//button[text()=' save' and @name='add']")
		private WebElement saveButton;

		private WebElement passwordTF;

		private WebElement firstnameTF;
		private WebElement addresssTextArea;

		private WebElement contactInfoTf;

		private WebElement photoUploadButtonTF;
		
		//Initialization
			public AddNewUsrPage(WebDriver driver) {
				PageFactory.initElements(driver, this);
			}
			//Utilization
			public String getPageHeader() {
				return pageHeader.getText();
			}
			public void setEmail (String email) {
				emailTF.sendKeys(email);
			}
			public void setPassword(String password)
			{
				passwordTF.sendKeys(password);
			}
			public void setfirstname(String firstname)
			{
				firstnameTF.sendKeys(firstname);
			}
			public void setlastname(String lastname)
			{
				lastnameTF.sendKeys(lastname);
			}
			public void setaddress(String address)
			{
				addresssTextArea.sendKeys(address);
			}
			public void setContactInfo(String contact) {
				contactInfoTf.sendKeys(contact);
			}
			public void uploadPhoto(String photopath) {
				photoUploadButtonTF.sendKeys(photopath);
			}
			public void clicksave() {
				saveButton.click();
			}


}
