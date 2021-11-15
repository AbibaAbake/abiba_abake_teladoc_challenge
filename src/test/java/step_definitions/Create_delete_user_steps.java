package step_definitions;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import utilities.BrowserUtils;
import utilities.Driver;
import utilities.PropertiesReader;

public class Create_delete_user_steps {
	
	HomePage hp = new HomePage();
	BrowserUtils bu = new BrowserUtils();
	String userName;
	String firstName;
	String lastName;
	
	@Given("I am on the userInfo Page")
	public void i_am_on_the_user_info_page() {
	    Driver.getDriver().get(PropertiesReader.getProperty("env_URL"));
	    bu.waitUntilElementVisible(hp.addUserBtn);
	}
	
	// add user steps starts
	@When("I add new user with following details")
	public void i_add_new_user_with_following_details(DataTable dataTable) {
		
		hp.addUserBtn.click();
	    bu.waitUntilElementVisible(hp.firstNamefild);
	    
	    //converting dataTable into a list
	    List<String> list = dataTable.asList();
	    userName = list.get(2);
	    firstName = list.get(0);
	    lastName = list.get(1);
	    hp.firstNamefild.sendKeys(firstName);
	    hp.lastNameFild.sendKeys(lastName);
	    hp.userNameFild.sendKeys(list.get(2));
	    hp.password.sendKeys(list.get(3));
	    
	    String company = list.get(4);
	    if (company.equals("Company AAA")) {
			hp.customerCompanyAAACheckBox.click();
		} else {
			hp.customerCompanyBBBCheckBox.click();
		}
	    
	    bu.selectByVisibleText(hp.roleDropDown, list.get(5));
	    hp.EmailFild.sendKeys(list.get(6));
	    hp.cellPhoneFild.sendKeys(list.get(7));
	}
	
	@When("I click on Save button")
	public void i_click_on_save_button() {
		hp.saveBtn.click();
	}
	
	@Then("The added user displays on the user table")
	public void the_added_user_displays_on_the_user_table() {
		bu.waitUntilElementVisible(hp.addUserBtn);
		for (WebElement users : hp.userNameColumns) {
			if (users.getText().equals(userName)) {
				assertTrue(true);
				break;
			}
			
		}
	}
	
	// add user steps ends
	
	// delete user steps starts
	@When("I find the user with username {string} and I click on the delete button")
	public void i_find_the_user_with_username_and_i_click_on_the_delete_button(String username) {
		userName = username;
		List<WebElement> usernames = Driver.getDriver().findElements(By.xpath("//table[@columns='columnCollection']/tbody//tr/td[3]"));
		int count = 0;
		for (WebElement users : usernames) {
			count++;
		
			if (users.getText().equals(username)) {
				WebElement xBtn = Driver.getDriver().findElement(By.xpath("//table[@columns='columnCollection']/tbody//tr[" + count + "]/td[11]/button/i"));
				xBtn.click();
				break;
			}
		}
		
		
	}
	
	@Then("A confirmation dialog should appear with the text: {string}")
	public void a_confirmation_dialog_should_appear_with_the_text(String confirmationMessage) {
		bu.waitUntilElementVisible(hp.confirmationText);
		String message = hp.confirmationText.getText().trim();
		assertEquals(message, confirmationMessage);
	}
	
	@When("I click on Ok button")
	public void i_click_on_ok_button() {
	    hp.deleteOKBtn.click();
	}
	
	@Then("The user should be deleted")
	public void the_user_should_be_deleted() {
		bu.waitUntilElementVisible(hp.addUserBtn);
		for (WebElement users : hp.userNameColumns) {
			System.out.println("user: " + users.getText());
			if (users.getText().equals(userName)) {
				assertTrue(false);
			}
		}
	}
	
	// delete user steps ends

}
