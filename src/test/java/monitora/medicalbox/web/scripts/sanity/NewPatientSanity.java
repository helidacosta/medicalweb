package monitora.medicalbox.web.scripts.sanity;

import java.net.MalformedURLException;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import monitora.medicalbox.web.po.mainscreen.MainScreenPageObject;
import monitora.medicalbox.web.po.patient.NewPacientPageObject;
import monitora.medicalbox.web.po.patient.PatientPageObject;
import monitora.medicalbox.web.support.Utils;
import monitora.medicalbox.web.support.patient.Patient;
import monitora.medicalbox.web.support.patient.ReaderPatient;

public class NewPatientSanity {
	
	private WebDriver driver;
    private String csvFile = "src/main/resources/planilha/Pacientes_Barizza_Prontos.csv";
    private String line = "";
    private String cvsSplitBy = ",";

    
    @Before
	public void setUp() throws MalformedURLException {
    	try {
			driver = Utils.initDriver();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        Utils.login(driver);
	}
	
	@After
	public void tearDown() {
		//driver.quit();
	}
	
	@Test
	public void testPacients() {
				
	    MainScreenPageObject mainscreen = new MainScreenPageObject(driver);
		PatientPageObject patients = new PatientPageObject(driver);
		NewPacientPageObject newpacient = new NewPacientPageObject(driver);
		
		//step2
		mainscreen.clickBtnPacients();
		
		ReaderPatient reader = new ReaderPatient(csvFile, cvsSplitBy, line);
		int count = 0;
		try {
			List<Patient> pacientes = reader.readCsv();
			for(Patient patient:pacientes) {
			
			    //step3
			    patients.clickBtnNewPatient();
			    
			    //step4
			  		newpacient.clickBtnSalvePacient(patient.getName());
			  		
			    
			    //step5
				newpacient.clickExpandirData();
									
				//General Data
				//step6
				newpacient.fillNamePacient(patient.getName());
				Utils.waitForSplashInvisibility();
				
				//step7
				newpacient.fillBirthPacient(patient.getBirth());
				
				//step8
				
				//step9
				newpacient.SelectGender(patient.getGender());
				
				//step10
				newpacient.fillRgPacient(patient.getRg());
				
				//step11
				newpacient.fillCpfPacient(patient.getCpf());
				
				//step12
				newpacient.SelectMaritalS(patient.getMarital());
				
				//step13	
				newpacient.fillProfessionPacient(patient.getProfession());
				
				//step14
				newpacient.fillIndicationPacient(patient.getIndication());
						
				//Contact
				//step15
				newpacient.filltxtTelephone(patient.getPhone());
				newpacient.filltxtCellphone(patient.getCellphone());
				
				//step16
				newpacient.filltxtSpeakwith(patient.getSpeak());
				
				//step17
				newpacient.filltxtTEmail(patient.getEmail());
				
				
				//Adress
				//step18 19 and 20
				newpacient.fillAddress(patient.getCep(), 
										"Brasil", 
										patient.getState(), 
										patient.getCity(), 
										patient.getNeighborhood(), 
										patient.getAddress(), 
										patient.getNumber(), 
										patient.getComplement());
				//Health plan
				//step21
				newpacient.filltxtHealthplan(patient.getShealth());
				
				//step22
				newpacient.filltxtNumberCard(patient.getNumbershealth());
				
				//step23
				newpacient.filltxtValCard(patient.getValcard());
				
				//step24
				newpacient.filltxtCompany(patient.getCompany());
				
				//step25
				newpacient.filltxtObshealthplan(patient.getObsshealth());
				
				//More Information
				//step26
				newpacient.filltxtFirstCons(patient.getFirstcon());
				
				//step27
				newpacient.filltxtDeathdate(patient.getDeathdate());
				
				//step28
				newpacient.filltxtCodigo(patient.getCodigo());
				
				//step29
				newpacient.filltxtObs(patient.getObs());
				
				
				newpacient.clickBtnSalvePacient(newpacient.getNamePacient());
     			Utils.waitForSuccessMessage();					
		   }
		} catch (Exception e) {e.printStackTrace();}
		//step33
		patients.fillSearchPatient("30298635810");
		//step34
		patients.clickPatient();
		//step35
		patients.clickFicPatient();
		
		newpacient.clickmenuDataPessoais();
		newpacient.fillCpfPacient("30298635810");
		newpacient.clickmenuContacts();
		newpacient.filltxtCellphone("16996558552");
		newpacient.clickmenuOthersInfo();
		newpacient.filltxtCodigo("250");
		
		newpacient.clickBtnSalvePacient(newpacient.getNamePacient());
		Utils.waitForSuccessMessage();
		
		patients.fillSearchPatient("30298635810");
		//step34
		patients.clickPatient();
		//step35
		patients.clickFicPatient();
		newpacient.clickmenuOthersInfo();
		newpacient.clickBtnExcluirPaciente();
		
		patients.fillSearchPatient("30298635810");
		
	}
}
