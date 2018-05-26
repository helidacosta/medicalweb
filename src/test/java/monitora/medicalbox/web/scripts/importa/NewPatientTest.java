package monitora.medicalbox.web.scripts.importa;

import java.net.MalformedURLException;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import monitora.medicalbox.web.po.MedicalRecordsPageObject;
import monitora.medicalbox.web.po.mainscreen.MainScreenPageObject;
import monitora.medicalbox.web.po.patient.NewPacientPageObject;
import monitora.medicalbox.web.po.patient.PatientPageObject;
import monitora.medicalbox.web.support.Utils;
import monitora.medicalbox.web.support.patient.Patient;
import monitora.medicalbox.web.support.patient.ReaderPatient;
import monitora.medicalbox.web.support.patient.importa.PatientImporta;
import monitora.medicalbox.web.support.patient.importa.ReaderPatientImporta;

public class NewPatientTest {
	
	private WebDriver driver;
    private String csvFile = "src/main/resources/planilha/pacientespronto.csv";
    private String line = "";
    private String cvsSplitBy = ";";

    
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
		MedicalRecordsPageObject medrecords = new MedicalRecordsPageObject(driver);
		
	    ReaderPatientImporta reader = new ReaderPatientImporta(csvFile, cvsSplitBy, line);
		int count = 0;
		try {
			List<PatientImporta> pacientes = reader.readCsv();
			for(PatientImporta patient:pacientes) {
				if(count >= 5) {
					driver.manage().deleteAllCookies();
					Utils.login(driver);
				   	count = 0;
				}
				mainscreen.clickBtnPacients();
				patients.clickBtnNewPatient();
				newpacient.clickExpandirData();
				
				//General Data
				newpacient.fillNamePacient(patient.getName());
				Utils.waitForSplashInvisibility();
				newpacient.fillBirthPacient(patient.getBirth());
				newpacient.SelectGender(patient.getGender());
				newpacient.SelectMaritalS(patient.getMarital());;
				//newpacient.fillCpfPacient(patient.getCpf());
				//newpacient.fillProfessionPacient(patient.getProfession());
				
				//Contact
				newpacient.filltxtTelephone(patient.getPhone());
				newpacient.filltxtCellphone(patient.getCellphone());
				//newpacient.filltxtTEmail(patient.getEmail());
								
				//Adress
				newpacient.fillAddress(patient.getCep(), "Brasil", patient.getState(), patient.getCity(), patient.getNeighborhood(), patient.getAddress(), patient.getNumber(), patient.getComplement());
				
				//More Information
				newpacient.filltxtObs(patient.getObs());
				newpacient.filltxtCodigo(patient.getCodigo());
				newpacient.setEvidenciaPac();
				
				newpacient.clickBtnSalvePacient(patient.getName());
				
				if(patient.getMrecords() != "NULL") {
				mainscreen.clickBtnMedicalRecords();
				
				if(medrecords.getBtnCreatePEP()){
					medrecords.clickBtnCreatePEP();				}
	    
				medrecords.fillFreeText(patient.getMrecords());
				medrecords.clickBtnConcluir();
				medrecords.clickBtnSim();
				
				Utils.waitForSuccessMessage();	
				System.out.println("Prontuário Cadastrado com sucesso: " + patient.getName());
				}
				count++;
				
				
				mainscreen.clickBtnRemovePacients();
			}			
	   } catch (Exception e) {e.printStackTrace();}
	}
	
}
