package monitora.medicalbox.web.po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import monitora.medicalbox.web.support.Utils;

public class MainScreenPageObject {
	
	@FindBy(xpath = "//a[@href='/pacientes']")
	WebElement btnPacients;
	
	@FindBy(className = "name-patient-menu-select")
	WebElement txtPacients;
	
	@FindBy(id = "btnCalendar")
	WebElement btnCalendar;
	
	
	public MainScreenPageObject(WebDriver driver) {
		PageFactory.initElements(driver, this);
		new WebDriverWait(driver, 5).until(ExpectedConditions.presenceOfElementLocated(By.className("name-patient-menu-select")));
	}
	
	public void clickBtnCalendar() {
		btnCalendar.click();
	}
	
	public String gettxtPacients() {
		return txtPacients.getText();
	}
	
	public void clickBtnPacients() {
		btnPacients.click();
		Utils.waitForSplashInvisibility();
	}
	
}
