package monitora.medicalbox.web.scripts;

import java.net.MalformedURLException;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import monitora.medicalbox.web.support.Patient;
import monitora.medicalbox.web.support.Reader;
import monitora.medicalbox.web.support.Utils;
import monitora.medicalbox.web.po.LoginPageObject;
import monitora.medicalbox.web.po.MainScreenPageObject;
import monitora.medicalbox.web.po.NewPacientPageObject;
import monitora.medicalbox.web.po.PacientPageObject;

public class MedicalBoxNewPacientTest {
	
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
		driver.get("https://qa.medicalbox.com.br/");
		driver.manage().window().maximize();
		
		LoginPageObject login = new LoginPageObject(driver);
		login.fillEmailLogin("helidalu.oliveira@gmail.com");
		login.fillPasswordLogin("1234");
		login.clickBtnLogin();
		
	}
	
	@After
	public void tearDown() {
		//driver.quit();
	}
	
	@Test
	public void testPacients() {
				
	    MainScreenPageObject mainscreen = new MainScreenPageObject(driver);
	    mainscreen.clickBtnPacients();
		
		PacientPageObject pacients = new PacientPageObject(driver);
		NewPacientPageObject newpacient = new NewPacientPageObject(driver);
		
		Reader reader = new Reader(csvFile, cvsSplitBy, line);
		int count = 0;
		try {
			List<Patient> pacientes = reader.readCsv();
			for(Patient patient:pacientes) {
				if(count >= 10) {
					driver.manage().deleteAllCookies();
					driver.get("https://qa.medicalbox.com.br/");
					driver.manage().window().maximize();
					
					LoginPageObject login = new LoginPageObject(driver);
					login.fillEmailLogin("helidalu.oliveira@gmail.com");
					login.fillPasswordLogin("1234");
					login.clickBtnLogin();
					
					mainscreen = new MainScreenPageObject(driver);
					mainscreen.clickBtnPacients();
					
					//PacientPageObject pacients = new PacientPageObject(driver);
					newpacient = new NewPacientPageObject(driver);
					
					count = 0;
				}
				pacients.clickBtnNewPacient();
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
				/*try {
					assertEquals("Concluído!", pacients.gettxtmessageSuccess());
					System.out.println("Paciente cadastrado com sucesso: " + patient.getName());
				}catch(AssertionError e){
					System.out.println("Paciente não cadastrado com sucesso: " + patient.getName());
					}*/
				
				Utils.waitForSuccessMessage();
				System.out.println("Paciente cadastrado com sucesso: " + patient.getName());
								
				count++;
				}	
			
		    } catch (Exception e) {
            e.printStackTrace();
        }
		
	}
	
}
