package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NavPage {
	
	private WebDriver driver;
	
	public NavPage(WebDriver driver){
		this.driver = driver;
	}
	
	public WebElement getHomeLink() {
		return driver.findElement(By.xpath("//div[@class = 'v-toolbar__items']/a[1]"));
	}
	
	public WebElement getAboutLink() {
		return driver.findElement(By.xpath("//div[@class = 'v-toolbar__items']/a[2]"));
	}
	
	public WebElement getMyProfileLink() {
		return driver.findElement(By.xpath("//div[@class = 'v-toolbar__items']/a[3]"));
	}
	
	public WebElement getAdminButton() {
		return driver.findElement(By.className("btnAdmin"));
	}
	
	public WebElement getCitiesButton() {
		return driver.findElement(By.xpath("//*[text()='Cities']"));
	}
	
	public WebElement getUsersButton() {
		return driver.findElement(By.xpath("//*[text()='Users']"));
	}
	
	public WebElement getLoginButton() {
		return driver.findElement(By.className("btnLogin"));
	}
	
	public WebElement getLogoutButton() {
		return driver.findElement(By.className("btnLogout"));
	}
	
	public WebElement getLanguageButton() {
		return driver.findElement(By.className("btnLocaleActivation"));
	}
	
	public WebElement getENButton() {
		return driver.findElement(By.id("list-item-73"));
	}
	
	public WebElement getESButton() {
		return driver.findElement(By.id("list-item-75"));
	}
	
	public WebElement getFRButton() {
		return driver.findElement(By.id("list-item-77"));
	}
	
	public WebElement getCRButton() {
		return driver.findElement(By.id("list-item-79"));
	}
	
	public WebElement getSignUpButton() {
		return driver.findElement(By.xpath("//div[@class = 'v-toolbar__items']/a[4]"));
	}
	
	
	
}
