package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	// Declaration
		@FindBy(xpath = "//a[text()=' Home']")
		private WebElement pageHeader;

		@FindBy(xpath = "//span[text()='Users']")
		private WebElement userTab;

		@FindBy(xpath = "//span[text()='Courses']")
		private WebElement coursesTab;

		@FindBy(xpath = "//a[text()=' Course List']")
		private WebElement coursesListLink;

		@FindBy(xpath = "//a[text()=' Category']")
		private WebElement categoryLink;

		// initialization
		public HomePage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}

		// Utilization
		public String getPageHeader() {
			return pageHeader.getText();
		}

		public void clickUsersTab() {
			userTab.click();
		}

		public void clickCoursesTab() {
			coursesTab.click();
		}

		public void clickCourseListLink() {
			categoryLink.click();
		}

			
		

           			
		}

			
		

			
		
			
		


}
