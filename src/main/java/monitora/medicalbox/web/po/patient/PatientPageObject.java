package monitora.medicalbox.web.po.patient;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import monitora.medicalbox.web.support.Utils;

public class PatientPageObject 
{
	@FindBy(xpath = "//div[@class='input-group']//input")
	WebElement searchPatient;
	
	@FindBy(xpath = "//table[@class='table table-hover table-dynamic dataTable_pacientes no-footer dataTable']//td")
	WebElement Patient;
	
	@FindBy(xpath = "//div[@class='dataTables_filter']//button")
	WebElement btnNewPatient;
	
	
	@FindBy(xpath = "//div[@class='summaryButtons']//div[@class='col-md-3 receiveBackgroundThemeColorOnHover gaSend']//p[contains(text(),'Ficha do paciente')]")
	WebElement btnFicPatient;
	
	//ConcluidoMsg
	@FindBy(xpath = "//div[@class='noty_bar noty_type_success']")
	static WebElement MsgSuccess;
	
	public PatientPageObject(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public  void fillSearchPatient(String patient) {
		searchPatient.sendKeys(patient);
		Utils.waitForInformationMsg();
	}
	
	public void clickBtnNewPatient() {
		btnNewPatient.click();
		Utils.waitForSplashInvisibility();
	}
	
	public void clickPatient() {
		Patient.click();
		Utils.waitForSplashInvisibility();
	}
	
	public void clickFicPatient() {
		btnFicPatient.click();
		Utils.waitForSplashInvisibility();
	}


	public static Boolean getmessageSuccess() {
		try {
			Boolean ReturnMesg = MsgSuccess.isDisplayed();
			return ReturnMesg;
		}catch(NoSuchElementException ex){
			return false;
		}
		
		
		    
	}
}
