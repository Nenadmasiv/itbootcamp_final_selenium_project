package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MessagePopUpPage {

	private WebDriver driver;

	public MessagePopUpPage(WebDriver driver) {
		this.driver = driver;
	}

	public void waitForPopUpToBeWisible() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(
						"//div[contains(@class, 'v-dialog__content')]")));
	}

	public WebElement getElementWithTextMessage() {
		return driver.findElement(By.className(
				"v-snack__wrapper")).findElement(By.tagName("li"));
	}

	public void waitForVerifyYourAccountDialogueToBeWisible() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//div[contains(@class, 'dlgVerifyAccount')]")));
	}

	public WebElement getElementWithVerifyAccountMessage() {
		return this.driver.findElement(By.xpath(
				"//div[contains(@class, 'dlgVerifyAccount')]"));
	}

	public WebElement getPopUpCloseBtn() {
		return this.driver.findElement(By.xpath(
				"//button[contains(@class, 'btnClose')]"));
	}

	public void waitForSuccessPopUpToBeVisible() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[contains(@class, 'succes')]")));
	}

//	public WebElement getWarningPopUpElement() {
//		return this.driver.findElement(By.xpath(
//				"//div[contains(@class, 'success')]"));
//	}

	public WebElement getMessageFromSuccessPopUp() {
		return this.driver.findElement(By.xpath(
				"//div[contains(@class, 'success')]"));
	}

}
