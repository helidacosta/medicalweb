package monitora.medicalbox.web.po.mainscreen;

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
	
	@FindBy(xpath = "//div[@class='user-image text-center']//button[@class='btn btn-danger']")
	WebElement btnRemovePatients;
	
	@FindBy(xpath = "//ul[@id='sidebarMenu']//li[@data-menuitem-name='Pacientes']//a[@href='/pacientes']")
	WebElement btnPacients;
	
	@FindBy(className = "name-patient-menu-select")
	WebElement txtPacients;
	
	@FindBy(xpath = "//a[@href='/prontuario']")
	WebElement btnMedicalRecords;
	
	
	public MainScreenPageObject(WebDriver driver) {
		PageFactory.initElements(driver, this);
		new WebDriverWait(driver, 5).until(ExpectedConditions.presenceOfElementLocated(By.className("name-patient-menu-select")));
	}
	
	public void clickBtnMedicalRecords() {
		btnMedicalRecords.click();
		Utils.waitForSplashInvisibility();
	}
	
	public String gettxtPacients() {
		return txtPacients.getText();
	}
	
	public void clickBtnPacients() {
		btnPacients.click();
		Utils.waitForSplashInvisibility();
	}
	
	public void clickBtnRemovePacients() {
		btnRemovePatients.click();
		Utils.waitForSplashInvisibility();
	}
	
}
