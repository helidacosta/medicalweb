package monitora.medicalbox.web.scripts;

import static org.junit.Assert.assertEquals;


import java.net.MalformedURLException;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import monitora.medicalbox.web.support.Patient;
import monitora.medicalbox.web.support.Reader;
import monitora.medicalbox.web.support.Utils;
import monitora.medicalbox.web.po.LoginPageObject;
import monitora.medicalbox.web.po.MainScreenPageObject;
import monitora.medicalbox.web.po.NewPacientPageObject;
import monitora.medicalbox.web.po.PacientPageObject;

public class MedicalBoxNewPacientTest {
	
	private WebDriver driver;
	private Wait wait;
    private String csvFile = "src/main/resources/planilha/Contato pacientes_less.csv";
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
		
		//wait = new WebDriverWait(driver,5);
		

		driver.get("https://uat.medicalbox.com.br/");
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
				
		//try {Thread.sleep(2000);}catch(Exception e) {e.printStackTrace();}
	    MainScreenPageObject mainscreen = new MainScreenPageObject(driver);
		mainscreen.clickBtnPacients();
		

		PacientPageObject pacients = new PacientPageObject(driver);
		NewPacientPageObject newpacient = new NewPacientPageObject(driver);

		
		Reader reader = new Reader(csvFile, cvsSplitBy, line);
		
		try {
			List<Patient> pacientes = reader.readCsv();
			System.out.println(pacientes.size());
			for(Patient patient:pacientes) {
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
				newpacient.fillAddress(patient.getCep(), "Brasil", patient.getState(), patient.getCity(), patient.getNeighborhood(), patient.getAddress());
				new WebDriverWait(driver, 2);
				newpacient.filltxtNumber(patient.getNumber());
				newpacient.filltxtComplement(patient.getComplement());
				
				//More Information
				newpacient.filltxObs(patient.getObs());
						
				newpacient.clickBtnSalvePacient();
				//assertEquals("Concluído!", pacients.gettxtmessageSuccess());
				Utils.waitForSuccessMessage();
				System.out.println("Paciente cadastrado com sucesso: " + patient.getName());
			}
            
        } catch (Exception e) {
            e.printStackTrace();
        }
		

	}
}
