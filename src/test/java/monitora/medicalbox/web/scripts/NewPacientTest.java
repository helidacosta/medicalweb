package monitora.medicalbox.web.scripts;

import java.net.MalformedURLException;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import monitora.medicalbox.web.support.Patient;
import monitora.medicalbox.web.support.ReaderPatient;
import monitora.medicalbox.web.support.Utils;
import monitora.medicalbox.web.po.MainScreenPageObject;
import monitora.medicalbox.web.po.NewPacientPageObject;
import monitora.medicalbox.web.po.PatientPageObject;

public class NewPacientTest {
	
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
		
	    mainscreen.clickBtnPacients();
				
		ReaderPatient reader = new ReaderPatient(csvFile, cvsSplitBy, line);
		int count = 0;
		try {
			List<Patient> pacientes = reader.readCsv();
			for(Patient patient:pacientes) {
				if(count >= 10) {
					driver.manage().deleteAllCookies();
					Utils.login(driver);
					
					mainscreen.clickBtnPacients();
					
					count = 0;
				}
				patients.clickBtnNewPatient();
				newpacient.clickExpandirData();
				
				//General Data
				newpacient.fillNamePacient(patient.getName());
				Utils.waitForSplashInvisibility();
				newpacient.fillBirthPacient(patient.getBirth());
				newpacient.SelectGender(patient.getGender());
				newpacient.SelectMaritalS(patient.getMarital());;
				//newpacient.fillRgPacient();
				newpacient.fillCpfPacient(patient.getCpf());
				newpacient.fillProfessionPacient(patient.getProfession());
				//newpacient.fillIndicationPacient();
				
				//Contact
				newpacient.filltxtTelephone(patient.getPhone());
				newpacient.filltxtCellphone(patient.getCellphone());
				newpacient.filltxtTEmail(patient.getEmail());
				newpacient.filltxtSpeakwith(patient.getSpeak());
				
				//Adress
				newpacient.fillAddress(patient.getCep(), "Brasil", patient.getState(), patient.getCity(), patient.getNeighborhood(), patient.getAddress(), patient.getNumber(), patient.getComplement());
				//newpacient.filltxtNumber(patient.getNumber());
				//newpacient.filltxtComplement(patient.getComplement());
				
				//More Information
				newpacient.filltxtObs(patient.getObs());
						
				newpacient.clickBtnSalvePacient();
				
//				if(("Concluído!".equals(pacients.gettxtmessageSuccess().toString()))){
				if(patients.getmessageSuccess()){
					System.out.println("Paciente cadastrado com sucesso: " + patient.getName());
				}else { 
					//if(("ERRO 1097 - O CPF inserido já existe e está em uso.".equals(newpacient.gettxtmessagepacientexistent().toString()))){
					if(newpacient.getmessagepacientexistent()){
						newpacient.clickBtnCancelPacient();
						System.out.println("Paciente já cadastrado: " + patient.getName());	
					}
					
					//if(("CPF inválido".equals(newpacient.gettxtmsgCPFinvalid().toString()))){
					if(newpacient.getmsgCPFinvalid()){
						newpacient.clearCpfPacient();
						try {Thread.sleep(2000);}catch(Exception e) {e.printStackTrace();}
						newpacient.clickBtnSalvePacient();
						System.out.println("CPF do Paciente é inválido: " + patient.getName());	
						}
				}
				
				
				Utils.waitForSuccessMessage();					
				count++;
			}			
	   } catch (Exception e) {e.printStackTrace();}
	}
	
}
