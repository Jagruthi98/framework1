package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtility;

public class CourseListPage {
	// Declaration
	@FindBy(xpath = "//h1[normalize-space(text())='Course List']")
	public WebElement pageHeader;

	@FindBy(xpath = "//a[text()=' New']")
	public WebElement newButton;

	// %s to replace string data and %d for replacing numeric values
	private String deletePath = "//td[text()='%s']/ancestor::tr/descendant::button[text()=' Delete']";

	@FindBy(name = "delete")
	public WebElement deleteButton;

	@FindBy(xpath = "//h4[text()=' Success!']")
	private WebElement successMessage;

	// Initialization
	public CourseListPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Utilization
	public String getPageHeader() {
		return pageHeader.getText();

	}

	public void clickNewButton() {
		newButton.click();
	}

	public void deleteCourse(WebDriverUtility web, String courseName) {
		web.convertPathToWebElement(deletePath, courseName).click();
		deleteButton.click();
	}

	public String getSuccessMessage() {
		return successMessage.getText();
	}

}
