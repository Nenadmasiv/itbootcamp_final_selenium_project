package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthRoutesTests extends BasicTest {
	
	@Test(priority = 10)
    public void forbidsVisitsToHomeUrlIfNotAuthenticated() {
		
        driver.navigate().to(baseUrl + "/home");
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"),
        		"ERROR! URL shoould contain '/login'!");
    }
	
    @Test(priority = 20)
    public void forbidsVisitsToProfileUrlIfNotAuthenticated() {
    	
        driver.navigate().to(baseUrl + "/profile");
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"),
        		"ERROR! URL shoould contain '/login'!");
    }
    
    @Test(priority = 30)
    public void forbidsVisitsToAdminCitiesUrlIfNotAuthenticated() {
    	
        driver.navigate().to(baseUrl + "/admin/cities");
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"),
        		"ERROR! URL shoould contain '/login'!");
    }
    
    @Test(priority = 40)
    public void forbidsVisitsToAdminUsersUrlIfNotAuthenticated() {
    	
        driver.navigate().to(baseUrl + "/admin/users");
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"),
        		"ERROR! URL shoould contain '/login'!");
    }
	
}