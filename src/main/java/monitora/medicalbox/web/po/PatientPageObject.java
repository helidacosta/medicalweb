package monitora.medicalbox.web.po;

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
	
	@FindBy(xpath = "//table[@id='DataTables_Table_0']//td")
	WebElement Patient;
	
	@FindBy(xpath = "//div[@class='dataTables_filter']//button")
	WebElement btnNewPatient;
	
	//ConcluidoMsg
	@FindBy(xpath = "//div[@class='noty_bar noty_type_success']")
	WebElement MsgSuccess;
	
	public PatientPageObject(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public  void fillSearchPatient(String patient) {
		searchPatient.sendKeys(patient);
		try {Thread.sleep(3000);}catch(Exception e) {e.printStackTrace();}
	}
	
	public void clickBtnNewPatient() {
		btnNewPatient.click();
		Utils.waitForSplashInvisibility();
	}
	
	public void clickPatient() {
		Patient.click();
		Utils.waitForSplashInvisibility();
	}


	public Boolean getmessageSuccess() {
		try {
			Boolean ReturnMesg = MsgSuccess.isDisplayed();
			return ReturnMesg;
		}catch(NoSuchElementException ex){
			return false;
		}
		
		
		    
	}
}