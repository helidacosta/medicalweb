package monitora.medicalbox.web.po;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import monitora.medicalbox.web.support.Utils;

public class MedicalRecordsPageObject {
	
	@FindBy (xpath = "//div[@class='pepCreateBtn']//button")
	WebElement btnCreatePEP;
	
	@FindBy(name = "freeText_field")
	WebElement freeText;
	
	@FindBy(xpath = "//div[@class='panel-footer footerButtons']//button[contains(text(),'Concluir')]")
	WebElement btnConcluir;
	
	@FindBy(xpath = "//div[@class='modal-footer']//button[contains(text(),'SIM')]")
	WebElement btnSim;
	
	
	
	public MedicalRecordsPageObject(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	public Boolean getBtnCreatePEP() {
		try {
			Boolean ReturnMesg = btnCreatePEP.isDisplayed();
			return ReturnMesg;
		}catch(NoSuchElementException ex){
			return false;
		}
}
	public void clickBtnCreatePEP() {
		btnCreatePEP.click();
		Utils.waitForSplashInvisibility();
	}
	
	//Free Text
	public void fillFreeText (String freetext) {
		freeText.sendKeys(freetext);
	}
		
	public void clickBtnConcluir() {
		btnConcluir.click();
		try {Thread.sleep(2000);}catch(Exception e) {e.printStackTrace();}
	}
	
	public void clickBtnSim() {
		btnSim.click();
		Utils.waitForSplashInvisibility();
	}

}
