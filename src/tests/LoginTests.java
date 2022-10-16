package tests;


import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.MessagePopUpPage;

public class LoginTests extends BasicTest {
	
	@Test (priority = 10)
	public void visitsTheLoginPage() {
		
		navPage.getLanguageButton().click();
		navPage.getENButton().click();
		navPage.getLoginButton().click();
		
		Assert.assertTrue(driver.getCurrentUrl().contains("/login"),
				"ERROR! URL should contains '/login' route!");
		
	}
	
	@Test (priority = 20)
	public void checksInputTypes() {
		
		navPage.getLoginButton().click();
		
		Assert.assertEquals(loginPage.getEmailInput()
				.getAttribute("type"), "email",
				"ERROR! Email attribute should be email!");
		Assert.assertEquals(loginPage.getPasswordInput()
				.getAttribute("type"), "password",
				"ERROR! Password attribute should be password!");
	}
	
	@Test (priority = 30)
	public void displaysErrorsWhenUserDoesNotExist() {
		
		navPage.getLoginButton().click();
		loginPage.getEmailInput().sendKeys("non-existing-user@gmal.com");
		loginPage.getPasswordInput().sendKeys("password123");
		loginPage.getLoginButton().click();
		messagePopUpPage.waitForPopUpToBeWisible();
		
		Assert.assertTrue(messagePopUpPage.getElementWithTextMessage()
				.getText().contains("User does not exists"),
				"ERROR! Pop up message should contain 'User does not exists'!");
		Assert.assertTrue(driver.getCurrentUrl().contains("/login"),
				"ERROR! URL should contains '/login' route!");
		
		
	}
	
	@Test (priority = 40)
	public void displeyErrorsWhenPasswordIsWrong() {
		
		navPage.getLoginButton().click();
		loginPage.getEmailInput().sendKeys("admin@admin.com");
		loginPage.getPasswordInput().sendKeys("password123");
		loginPage.getLoginButton().click();
		messagePopUpPage.waitForPopUpToBeWisible();
		
		Assert.assertTrue(messagePopUpPage.getElementWithTextMessage()
				.getText().contains("Wrong password"),
				"ERROR! Pop up message should countain 'Wrong password'!");
		Assert.assertTrue(driver.getCurrentUrl().contains("/login"),
				"ERROR! Login page should contain login in URL!");
	}
	
	@Test(priority = 50)
	public void login() {
		
		navPage.getLoginButton().click();
		loginPage.getEmailInput().sendKeys("admin@admin.com");
		loginPage.getPasswordInput().sendKeys("12345");
		loginPage.getLoginButton().click();
		
		Assert.assertTrue(driver.getCurrentUrl().contains("/home"),
				"ERROR! Page should contain '/home' in URL");
	}
	
	@Test(priority = 60)
	public void logout() {	
		
		Assert.assertTrue(navPage.getLogoutButton().isDisplayed(),
				"ERROR! Logout button should be displayed");
		
		navPage.getLogoutButton().click();
	
	}
	
}