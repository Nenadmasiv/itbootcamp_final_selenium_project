package tests;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminCitiesTests extends BasicTest {
	
	@Test (priority = 10)
	public void visitsTheAdminCitiesPageAndListCities() {
		
		navPage.getLoginButton().click();
		loginPage.getEmailInput().sendKeys(" admin@admin.com");
		loginPage.getPasswordInput().sendKeys("12345");
		loginPage.getLoginButton().click();
		
		navPage.getAdminButton().click();
		navPage.getCitiesButton().click();
		
		Assert.assertTrue(driver.getCurrentUrl().contains("/admin/cities"),
				"ERROR! URL should contain '/admin/cities' route!");
	}
	
	@Test (priority = 20)
	public void checksInputTypesForCrediteEditNewCity() {
		
		navPage.getAdminButton().click();
		navPage.getCitiesButton().click();
		citiesPage.getNewItemButton().click();
		citiesPage.waitForEditPopUp();
		
		Assert.assertEquals(citiesPage.getNewItemInput().getAttribute("type"),
				("text"), "ERROR! Dialog input should be type text!");
	}
	
	@Test (priority = 30)
	public void createNewCity() {
		
		navPage.getAdminButton().click();
		navPage.getCitiesButton().click();
		citiesPage.getNewItemButton().click();
		citiesPage.waitForEditPopUp();
		citiesPage.getNewItemInput().sendKeys("Nenad Ilic's city");
		citiesPage.getSaveButtonInEditPopUp().click();
		
		messagePopUpPage.waitForSuccessPopUpToBeVisible();
        Assert.assertTrue(messagePopUpPage.getMessageFromSuccessPopUp()
        		.getText().contains("Saved successfully"),
        		"ERROR! Pop up message should contain 'Saved successfully'!");
		
	}
	
	@Test (priority = 40)
	public void editCity() {
		
		navPage.getAdminButton().click();
		navPage.getCitiesButton().click();
		citiesPage.getSearchInput().sendKeys("Nenad Ilic's city");
		
		citiesPage.waitForNumOfRowsToBe(1);
		citiesPage.getEditFromRowButton(1).click();
		
        citiesPage.getNewItemInput().sendKeys(Keys.CONTROL + "a");
        citiesPage.getNewItemInput().sendKeys("Nenad Ilic's city Edited" );
        citiesPage.getSaveButtonInEditPopUp().click();
        
        Assert.assertTrue(messagePopUpPage.getMessageFromSuccessPopUp()
        		.getText().contains("Saved successfully"),
        		"ERROR! Pop up message should contain 'Saved successfully'!");
		
	}
	
	@Test (priority = 50)
	public void searchCity() {
		
		navPage.getAdminButton().click();		
		navPage.getCitiesButton().click();		
		citiesPage.getSearchInput().sendKeys("Nenad Ilic's city Edited" );		
		
		citiesPage.waitForNumOfRowsToBe(1);
		Assert.assertEquals(citiesPage.getFromRowCell(1, 1)
				.getText(), "Nenad Ilic's city Edited",
				"ERROR! The name of the city is not correct!");
	}
	
	@Test (priority = 60)
	public void deleteCity() {
		
		navPage.getAdminButton().click();
		navPage.getCitiesButton().click();
		citiesPage.getSearchInput().sendKeys("Nenad Ilic's city Edited" );
		
		citiesPage.waitForNumOfRowsToBe(1);
		Assert.assertEquals(citiesPage.getFromRowCell(1, 1)
				.getText(), "Nenad Ilic's city Edited",
				"ERROR! The name of the city is not correct!");
		
		citiesPage.getDeleteFromRowButton(1).click();
        citiesPage.waitForDeletePopUp();
        citiesPage.getDeleteButtonInDeletePopUp().click();
        
        messagePopUpPage.waitForSuccessPopUpToBeVisible();
        Assert.assertTrue(messagePopUpPage.getMessageFromSuccessPopUp()
        		.getText().contains("Deleted successfully"),
        		"ERROR! Pop up message shoud countain 'Deleted successfully'!");
	}
	
	
	
}
