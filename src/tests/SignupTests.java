package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SignupTests extends BasicTest {
	
	@Test (priority = 10)
	public void visitsTheSignupPage() {
		
		navPage.getSignUpButton().click();
		
		Assert.assertTrue(driver.getCurrentUrl().contains("/signup"),
				"ERROR! URL should contains '/signup' route!");
	}
	
	@Test (priority = 20)
	public void checksInputTypes() {
		
		navPage.getSignUpButton().click();
		
		Assert.assertEquals(loginPage.getEmailInput()
				.getAttribute("type"), "email",
				"ERROR! Email attribute should be email!");
		Assert.assertEquals(loginPage.getPasswordInput()
				.getAttribute("type"), "password",
				"ERROR! Password attribute should be password!");
	}
	
	@Test (priority = 30)
	public void displaysErrorsWhenUserAlreadyExists() {
		
		navPage.getSignUpButton().click();
		
		Assert.assertTrue(driver.getCurrentUrl().contains("/signup"),
				"ERROR! URL should contains '/signup' route!");
		
		signupPage.getNameInput().sendKeys("Another User");
		signupPage.getEmailInput().sendKeys("admin@admin.com");
		signupPage.getPasswordInput().sendKeys("12345");
		signupPage.getConfirmPasswordInput().sendKeys("12345");
		signupPage.getSignMeUpButton().click();
		
		messagePopUpPage.waitForPopUpToBeWisible();
		
		Assert.assertTrue(messagePopUpPage.getElementWithTextMessage()
				.getText().contains("E-mail already exists"),
				"ERROR! Pop up message should countains 'Wrong password'!");
		Assert.assertTrue(driver.getCurrentUrl().contains("/signup"),
				"ERROR! URL should contains '/signup' route!");
		
	}
	
	@Test (priority = 40)
	public void Signup() {
		
		navPage.getSignUpButton().click();
		signupPage.getNameInput().sendKeys("Nenad Ilic");
		signupPage.getEmailInput().sendKeys("nenad.ilic@itbootcamp.rs");
		signupPage.getPasswordInput().sendKeys("12345");
		signupPage.getConfirmPasswordInput().sendKeys("12345");
		signupPage.getSignMeUpButton().click();
		
		messagePopUpPage.waitForVerifyYourAccountDialogueToBeWisible();
		
		Assert.assertTrue(messagePopUpPage.getElementWithVerifyAccountMessage()
				.getText().contains("IMPORTANT: Verify your account"),
				"ERROR! Pop up message should countains 'IMPORTANT: Verify your account'!");
		
		messagePopUpPage.getPopUpCloseBtn().click();
		
	}
	
	
}
