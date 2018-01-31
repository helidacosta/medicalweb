package monitora.medicalbox.web.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import monitora.medicalbox.web.support.Utils;

public class LoginPageObject {
	

	@FindBy(name = "username")
	WebElement emailLogin;
	
	@FindBy(name = "password")
	WebElement passwordLogin;
	
	@FindBy(id = "submit-form")
	WebElement btnLogin;
	
	@FindBy(id = "btnOk")
	WebElement btnOk;
	
	public LoginPageObject(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void fillEmailLogin (String email) {
		emailLogin.sendKeys(email);
	}
	
	public void fillPasswordLogin (String password) {
		passwordLogin.sendKeys(password);
	}
	
	public void clickBtnLogin() {
		btnLogin.click();
		Utils.waitForSplashInvisibility();
	}
	
	public void clickBtnOk() {
		btnOk.click();
	}
}
