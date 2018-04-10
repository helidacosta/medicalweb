package monitora.medicalbox.web.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import monitora.medicalbox.web.support.Utils;

public class PacientPageObject 
{
	
	@FindBy(xpath = "//div[@class='dataTables_filter']//button")
	WebElement btnNewPacient;
	
	//ConcluidoMsg
	@FindBy(xpath = "//div[@class='noty_bar noty_type_success']")
	WebElement txtSuccess;
	
	public PacientPageObject(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void clickBtnNewPacient() {
		btnNewPacient.click();
		Utils.waitForSplashInvisibility();
	}

	public String gettxtmessageSuccess() {
		return txtSuccess.getText();
	}
}
