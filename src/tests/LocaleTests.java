package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LocaleTests extends BasicTest {
	
    @Test(priority = 10)
    public void setLocaleToES() {
    	
        navPage.getLanguageButton().click();
        navPage.getESButton().click();
        
        Assert.assertTrue(driver.findElement(
        		By.tagName("h1")).getText().contains("Página de aterrizaje"),
                "ERROR! Header should contain 'Página de aterrizaje'");
    }
    
    @Test(priority = 20)
    public void setLocaleToEN() {
    	
        navPage.getLanguageButton().click();
        navPage.getENButton().click();
        
        Assert.assertTrue(driver.findElement(
        		By.tagName("h1")).getText().contains("Landing"),
                "ERROR! Header should contain 'Landing'");
    }
    
    @Test(priority = 30)
    public void setLocaleToCN() {
    	
        navPage.getLanguageButton().click();
        navPage.getCRButton().click();
        
        Assert.assertTrue(driver.findElement(
        		By.tagName("h1")).getText().contains("首页"),
        		"ERROR! Header should contain '首页'");
    }
    
    @Test(priority = 40)
    public void setLocaleToFR() {
    	
        navPage.getLanguageButton().click();
        navPage.getFRButton().click();
        
        Assert.assertTrue(driver.findElement(By.tagName("h1"))
        		.getText().contains("Page d'atterrissage"),
                "ERROR! Header should contain 'Page d'atterrissage'");
    }
		
}