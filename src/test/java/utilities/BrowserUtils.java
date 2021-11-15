package utilities;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserUtils {
	
	WebDriverWait letswait;
	Select letsSelect;

	public void waitUntilAlertIsPresent() {
		letswait = new WebDriverWait(Driver.getDriver(), 10);
		letswait.until(ExpectedConditions.alertIsPresent());
	}

	public void waitUntilElementVisible(WebElement element) {
		letswait = new WebDriverWait(Driver.getDriver(), 10);
		letswait.until(ExpectedConditions.visibilityOf(element));
	}

	public void selectByVisibleText(WebElement element, String optionToSelect) {
		letsSelect = new Select(element);
		letsSelect.selectByVisibleText(optionToSelect);
	}

	public boolean isElementPresent(WebElement element) {
		try {
			element.isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
		return true;
	}

}
