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

public class NewPacientPageObject {
	
	@FindBy(xpath = "//div[@class='panel-expand-btn-form']//a")
	WebElement bntExpandirData;
	
	//General Data
	@FindBy(xpath = "//div[contains(@ng-if,'Dados gerais')]//input[@name='person.name']")
	WebElement txtNamePacient;
	
	@FindBy(xpath = "//div[contains(@ng-if,'Dados gerais')]//input[@name='person.birth']")
	WebElement txtBirthPacient;
	
	@FindBy(xpath = "//div[contains(@ng-if,'Dados gerais')]//select[@name='person.gender']//option[@value='35']")
	WebElement slcGenderMasc;
	
	@FindBy(xpath = "//div[contains(@ng-if,'Dados gerais')]//select[@name='person.gender']//option[@value='36']")
	WebElement slcGenderFem;
	
	@FindBy(xpath = "//div[contains(@ng-if,'Dados gerais')]//select[@name='person.maritalStatus']//option[@value='8']")
	WebElement slcMaritalCas;
	
	@FindBy(xpath = "//div[contains(@ng-if,'Dados gerais')]//select[@name='person.maritalStatus']//option[@value='7']")
	WebElement slcMaritalSol;
	
	@FindBy(xpath = "//div[contains(@ng-if,'Dados gerais')]//select[@name='person.maritalStatus']//option[@value='11']")
	WebElement slcMaritalComp;
	
	@FindBy(xpath = "//div[contains(@ng-if,'Dados gerais')]//select[@name='person.maritalStatus']//option[@value='9']")
	WebElement slcMaritalDiv;
	
	@FindBy(xpath = "//div[contains(@ng-if,'Dados gerais')]//select[@name='person.maritalStatus']//option[@value='10']")
	WebElement slcMaritalViu;
	
	@FindBy(xpath = "//div[contains(@ng-if,'Dados gerais')]//input[@name='person.rg']")
	WebElement txtRgPacient;
	
	@FindBy(xpath = "//div[contains(@ng-if,'Dados gerais')]//input[@name='person.cpf']")
	WebElement txtCpfPacient;
	
	@FindBy(xpath = "//div[contains(@ng-if,'Dados gerais')]//input[@name='profession']")
	WebElement txtProfessionPacient;
	
	@FindBy(xpath = "//div[contains(@ng-if,'Dados gerais')]//input[@name='indication']")
	WebElement txtIndicationPacient;
	
	//Contacts
	@FindBy(xpath = "//div[contains(@ng-if,'Dados gerais')]//input[@name='homePhone']")
	WebElement txtTelephone;
	
	@FindBy(xpath = "//div[contains(@ng-if,'Dados gerais')]//input[@name='cellPhone']")
	WebElement txtCellphone;
	
	@FindBy(xpath = "//div[contains(@ng-if,'Dados gerais')]//input[@name='person.email']")
	WebElement txtEmail;
	
	@FindBy(xpath = "//div[contains(@ng-if,'Dados gerais')]//input[@name='person.contact.telephone[0].description']")
	WebElement txtSpeakwith;
	
	//Adress
	@FindBy(xpath = "//div[contains(@ng-if,'Dados gerais')]//input[@name='person.contact.cep']")
	WebElement txtCEP;
	
	@FindBy(xpath = "//div[contains(@ng-if,'Dados gerais')]//input[@name='person.contact.country']")
	WebElement txtCountry;
	
	@FindBy(xpath = "//div[contains(@ng-if,'Dados gerais')]//input[@name='person.contact.state']")
	WebElement txtState;
	
	@FindBy(xpath = "//div[contains(@ng-if,'Dados gerais')]//input[@name='person.contact.city']")
	WebElement txtCity;
	
	@FindBy(xpath = "//div[contains(@ng-if,'Dados gerais')]//input[@name='person.contact.neighborhood']")
	WebElement txtNeighborhood;
	
	@FindBy(xpath = "//div[contains(@ng-if,'Dados gerais')]//input[@name='person.contact.address']")
	WebElement txtAddress;
	
	@FindBy(xpath = "//div[contains(@ng-if,'Dados gerais')]//input[@name='person.contact.number']")
	WebElement txtNumber;
	
	@FindBy(xpath = "//div[contains(@ng-if,'Dados gerais')]//input[@name='person.contact.complement']")
	WebElement txtComplement;
	
	//Observation
	@FindBy(xpath = "//div[contains(@ng-if,'Dados gerais')]//textarea[@name='observation']")
	WebElement txtObservation;
	
	//Botão Salvar
	@FindBy(xpath = "//div[@ng-show='showAll']//button[contains(text(),'Salvar')]")
	WebElement btnSalvePacient;
	
	//ConcluidoMsg
	@FindBy(xpath = "//div[@class='noty_bar noty_type_error']")
	WebElement txtErrorCPF;
	
	public NewPacientPageObject(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void clickExpandirData() {
		bntExpandirData.click();
		//Utils.waitForSplashInvisibility();
	}
	
	//General Data
	public void fillNamePacient(String name) {
		txtNamePacient.sendKeys(name);
	}
	
	public  void fillBirthPacient(String birth) {
		txtBirthPacient.sendKeys(birth);
	}
	
	public void SelectGender(String gender) {
		if (gender.equals("M"))slcGenderMasc.click();
		else if (gender.equals("F"))slcGenderFem.click();
	}
	
	public void SelectMaritalS(String marital) {
		if (marital.equals("Casado"))slcMaritalCas.click();
		if (marital.equals("Solteiro"))slcMaritalSol.click();
		if (marital.equals("Companheiro"))slcMaritalComp.click();
		if (marital.equals("Divorciado"))slcMaritalDiv.click();
		if (marital.equals("Viúvo"))slcMaritalViu.click();
	}
	

	public void fillRgPacient(String rg) {
		txtRgPacient.sendKeys(rg);
	}
	
	public void fillCpfPacient(String cpf) {
		Integer cpflength = cpf.length();
		if (cpflength.equals(11))txtCpfPacient.sendKeys(cpf);
	}
	
	public void fillProfessionPacient(String profession) {
		txtProfessionPacient.sendKeys(profession);
	}
	
	public void fillIndicationPacient(String indication) {
		txtIndicationPacient.sendKeys(indication);
	}
	
	//Contact
	public void filltxtTelephone(String phone) {
		txtTelephone.sendKeys(phone);
	}
	
	public void filltxtCellphone(String cellphone) {
		txtCellphone.sendKeys(cellphone);
	}
	
	public void filltxtTEmail(String email) {
		txtEmail.sendKeys(email);
	}
	
	public void filltxtSpeakwith(String speak) {
		txtSpeakwith.sendKeys(speak);
	}
	
	//Address
	public void fillAddress(String cep, String country, String state, String city, String neighborhood, String address, String number, String complement) {
	Integer ceplength = cep.length();
	
		if (cep.equals("")){
			txtCountry.sendKeys(country);
			txtState.sendKeys(state);
			txtCity.sendKeys(city);
			txtNeighborhood.sendKeys(neighborhood);
			txtAddress.sendKeys(address);
		}else
		if(ceplength.equals(8) && cep != ""){
				txtCEP.sendKeys(cep);
				//Utils.waitForSplashInvisibility();
				try {Thread.sleep(2000);}catch(Exception e) {e.printStackTrace();}
		}
		
		txtNumber.sendKeys(number);
		txtComplement.sendKeys(complement);
	}
		
	public void filltxtNumber(String number) {
		//txtNumber.sendKeys(number);
	}
		
	public void filltxtComplement(String complement) {
		//txtComplement.sendKeys(complement);
	}
	
	//MoreInformation
	public void filltxtObs(String obs) {
		txtObservation.sendKeys(obs);
	}
	
	//Salve Button
	public void clickBtnSalvePacient() {
		btnSalvePacient.click();
		Utils.waitForSplashInvisibility();
	}
	
	public String gettxtmessageSuccess() {
		return txtErrorCPF.getText();
	}
	
}
