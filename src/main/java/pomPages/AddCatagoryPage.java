package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCatagoryPage {

	

		//Declaration
		@FindBy (xpath = "//b[text()='Add New Category']")
		private WebElement pageHeader;
		
		@FindBy (id="name")
		private WebElement nameTf;
		
		@FindBy (xpath = "//button[text()='save' and @name='add']")
		private WebElement savebutton;
		
		//Initialization
		public AddCatagoryPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
		
		//Utilization
		public String getPageHeader() {
			return pageHeader.getText();
		}
		public void setName(String courseName) {
			nameTf.sendKeys(courseName);
		}
		public void clickSave() {
			savebutton.click();
		}

	}


