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

public class NewPacientPageObject {
	
	@FindBy(xpath = "//div[@class='panel-expand-btn-form']//a")
	WebElement bntExpandirData;
	
	//General Data
	//Menu Dados pessoais
	@FindBy(xpath = "//div[@id='1-panel-patient-form-icons']//h3[contains(text(),'Dados gerais')]")
	WebElement menuDadosPessoais;
	
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
	//Menu Contacts
	@FindBy(xpath = "//div[@id='2-panel-patient-form-icons']//h3[contains(text(),'Contatos')]")
	WebElement menuContacts;
	
	@FindBy(xpath = "//div[contains(@ng-if,'Dados gerais')]//input[@name='homePhone']")
	WebElement txtTelephone;
	
	@FindBy(xpath = "//div[contains(@ng-if,'Dados gerais')]//input[@name='cellPhone']")
	WebElement txtCellphone;
	
	@FindBy(xpath = "//div[contains(@ng-if,'Dados gerais')]//input[@name='person.email']")
	WebElement txtEmail;
	
	@FindBy(xpath = "//div[contains(@ng-if,'Dados gerais')]//input[@name='person.contact.telephone[0].description']")
	WebElement txtSpeakwith;
	
	//Address
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
	
	//Health Plan
	@FindBy(xpath = "//div[contains(@ng-if,'Dados gerais')]//select[@name='agreementPlanOfCard']//option[@value='14']")
	WebElement txtHealthplan;
	
	@FindBy(xpath = "//div[contains(@ng-if,'Dados gerais')]//input[@name='agreementCard[0][code]']")
	WebElement txtNumberCard;
	
	@FindBy(xpath = "//div[contains(@ng-if,'Dados gerais')]//input[@name='validity']")
	WebElement txtValCard;
	
	@FindBy(xpath = "//div[contains(@ng-if,'Dados gerais')]//input[@name='agreementCardCompanyName']")
	WebElement txtCompany;
	
	@FindBy(xpath = "//div[contains(@ng-if,'Dados gerais')]//textarea[@name='agreementPlanObservation']")
	WebElement txtObshealthplan;
	
	//Other information
	
	//Menu Outras Informações
	@FindBy(xpath = "//div[@id='8-panel-patient-form-icons']//h3[contains(text(),'Mais informações')]")
	WebElement menuOtherInfo;
	
	@FindBy(xpath = "//div[contains(@ng-if,'Dados gerais')]//input[@name='firstConsult']")
	WebElement txtFirstCons;
	
	@FindBy(xpath = "//div[contains(@ng-if,'Dados gerais')]//input[@name='person.death']")
	WebElement txtDeathdate;
	
	@FindBy(xpath = "//div[contains(@ng-if,'Dados gerais')]//input[@name='code']")
	WebElement txtCodigo;
	
	@FindBy(xpath = "//div[contains(@ng-if,'Dados gerais')]//textarea[@name='observation']")
	WebElement txtObservation;
	
	@FindBy(xpath = "//div[contains(@ng-if,'Dados gerais')]//label[@class='checkbox-inline']//span[contains(text(),'Evidenciar Paciente')]")
	WebElement chkEvidenciarPac;
	
	@FindBy(xpath = "//div[@ng-switch-when='button']//button[contains(text(),'Excluir paciente')]")
	WebElement btnExcPatient;
	
	//Botão Salvar
	@FindBy(xpath = "//div[@ng-show='showAll']//button[contains(text(),'Salvar')]")
	WebElement btnSalvePacient;
	
	//Botão Cancelar
	@FindBy(xpath = "//div[@ng-show='showAll']//a[contains(text(),'Cancelar')]")
	WebElement btnCancelPacient;
	
	//Msg Paciente Existe
	@FindBy(xpath = "//div[@class='noty_bar noty_type_error']")
	WebElement msgPatientExist;
	
	//Msg CPF inválido
	@FindBy(xpath = "//div[@class='person_cpfformError parentFormundefined formError']")
	WebElement msgCPFinvalid;
	
	//Msg campo obrigatório
	@FindBy(xpath = "//div[@class='person_nameformError parentFormformCreatePatient formError']")
	WebElement msgCampoObr;
	
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
	
	public String getNamePacient() {
		String name = txtNamePacient.getText();
		return name;
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
		txtCpfPacient.clear();
		if (cpflength.equals(11))txtCpfPacient.sendKeys(cpf);
	}
	
	public void clearCpfPacient() {
		txtCpfPacient.clear();
	}
	
	public void fillProfessionPacient(String profession) {
		txtProfessionPacient.sendKeys(profession);
	}
	
	public void fillIndicationPacient(String indication) {
		txtIndicationPacient.sendKeys(indication);
	}
	
	public void clickmenuDataPessoais() {
		menuDadosPessoais.click();
	}
	
	//Contact
	
	public void clickmenuContacts() {
		menuContacts.click();
	}
	
	public void filltxtTelephone(String phone) {
		txtTelephone.sendKeys(phone);
	}
	
	public void filltxtCellphone(String cellphone) {
		txtCellphone.clear();
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
	
	//Health plan
	public void filltxtHealthplan(String healthplan) {
		txtHealthplan.sendKeys(healthplan);
	}
		
	public void filltxtNumberCard(String numbercard) {
		txtNumberCard.sendKeys(numbercard);
	}
	
	public void filltxtValCard(String valcard) {
		txtValCard.sendKeys(valcard);
	}
	
	public void filltxtCompany(String company) {
		txtCompany.sendKeys(company);
	}
	
	public void filltxtCodigo(String codigo) {
		txtCodigo.clear();
		txtCodigo.sendKeys(codigo);
	}
	
	//MoreInformation
	
	public void clickmenuOthersInfo() {
		menuOtherInfo.click();
	}
	
	public void filltxtFirstCons(String firstCons) {
		txtFirstCons.sendKeys(firstCons);
	}
	
	public void filltxtDeathdate(String deathdate) {
		txtDeathdate.sendKeys(deathdate);
	}
	
	public void filltxtObshealthplan(String obshealthplan) {
		txtObshealthplan.sendKeys(obshealthplan);
	}
	
	public void filltxtObs(String obs) {
		txtObservation.sendKeys(obs);
	}
	
	public void setEvidenciaPac() {
		chkEvidenciarPac.click();
	}
	
	public void clickBtnExcluirPaciente() {
		btnExcPatient.click();
	}
	
	//Salve Button
	public void clickBtnSalvePacient(String name) {
		btnSalvePacient.click();
		Utils.waitForSplashInvisibility();
		
		if(PatientPageObject.getmessageSuccess()){
    		System.out.println("Paciente cadastrado com sucesso: " + name);
			}else { //step31
				errorMsgPat(name);
			}
	}
	
	public void clickBtnCancelPacient() {
		btnCancelPacient.click();
		Utils.waitForSplashInvisibility();
	}
	
	public Boolean getmessagepacientexistent() {
		try {
			Boolean ReturnMesg = msgPatientExist.isDisplayed();
			return ReturnMesg;
		}catch(NoSuchElementException ex){
			return false;
		}
	}
	
	public Boolean getmsgCPFinvalid() {
		try {
			Boolean ReturnMesg = msgCPFinvalid.isDisplayed();
			return ReturnMesg;
		}catch(NoSuchElementException ex){
		return false;
	    }
    }
	
	public Boolean getmsgCampoObg() {
		try {
			Boolean ReturnMesg = msgCampoObr.isDisplayed();
			return ReturnMesg;
		}catch(NoSuchElementException ex){
		return false;
	    }
    }
	
	public void errorMsgPat(String name){
		
		if(getmsgCampoObg()){
  			try {Thread.sleep(2000);}catch(Exception e) {e.printStackTrace();}
  			System.out.println("Campo Obrigatório é requerido: " + name);	
  			}
		
		if(getmessagepacientexistent()){
		    clickBtnCancelPacient();
		    System.out.println("Paciente já cadastrado: " + name);
	    }
	
		if(getmsgCPFinvalid()){
			clearCpfPacient();
			try {Thread.sleep(2000);}catch(Exception e) {e.printStackTrace();}
				clickBtnSalvePacient(name);
				System.out.println("CPF do Paciente é inválido: " + name);
		}
	}
}
	
