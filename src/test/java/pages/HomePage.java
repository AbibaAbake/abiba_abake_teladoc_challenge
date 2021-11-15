package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Driver;

public class HomePage {
	
	public HomePage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	@FindBy(xpath = "//button[@class='btn btn-link pull-right']")
	public WebElement addUserBtn;
	
	@FindBy(xpath ="//div/h3[@class='ng-binding']")
	public WebElement addUserText;

	@FindBy(xpath = "//input[@name='FirstName']")
	public WebElement firstNamefild;

	@FindBy(xpath = "//input[@name='LastName']")
	public WebElement lastNameFild;

	@FindBy(xpath = "//input[@name='UserName']")
	public WebElement userNameFild;

	@FindBy(xpath = "//input[@name='Password']")
	public WebElement password;

	@FindBy(xpath = "//label[@class='radio ng-scope ng-binding'][1]")
	public WebElement customerCompanyAAACheckBox;

	@FindBy(xpath = "//label[@class='radio ng-scope ng-binding'][2]")
	public WebElement customerCompanyBBBCheckBox;

	@FindBy(xpath = "//select[@name='RoleId']")
	public WebElement roleDropDown;

	@FindBy(xpath = "//input[@name='Email']")
	public WebElement EmailFild;

	@FindBy(xpath = "//input[@name='Mobilephone']")
	public WebElement cellPhoneFild;

	@FindBy(xpath = "//button[@class='btn btn-success']")
	public WebElement saveBtn;
	
	@FindBy(xpath="//table[@columns='columnCollection']/tbody/tr/td[3]")
	public List<WebElement> userNameColumns;
	
	@FindBy(xpath="//button/i[@class='icon icon-remove'][1]")
	public WebElement removeUserIcon;

	@FindBy(xpath = "//p[text()='Do you really want to delete the user?']")
	public WebElement confirmationText;

	@FindBy(xpath = "//button[text()='OK']")
	public WebElement deleteOKBtn;

}
