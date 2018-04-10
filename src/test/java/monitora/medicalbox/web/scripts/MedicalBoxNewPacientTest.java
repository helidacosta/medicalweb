package monitora.medicalbox.web.scripts;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
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
		//wait = new WebDriverWait(driver,5);
		driver.get("https://qa.medicalbox.com.br/");
		driver.manage().window().maximize();
		
		LoginPageObject login = new LoginPageObject(driver);
		login.fillEmailLogin("adm_1@ah.com");
		login.fillPasswordLogin("1234");
		login.clickBtnLogin();
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void testPacients() {
		
	    MainScreenPageObject mainscreen = new MainScreenPageObject(driver);
		mainscreen.clickBtnPacients();

		PacientPageObject pacients = new PacientPageObject(driver);
		NewPacientPageObject newpacient = new NewPacientPageObject(driver);
		
		Reader reader = new Reader(csvFile, cvsSplitBy, line);
		try {
			List<Patient> pacientes = reader.readCsv();
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
				System.out.println("Free memory: " + Runtime.getRuntime().freeMemory());
				Runtime.getRuntime().gc();
				System.out.println("Free memory after garbage collecion: " + Runtime.getRuntime().freeMemory());
				
				
				}	
			
		          
        } catch (Exception e) {
            e.printStackTrace();
        }
		
	}
	
	private void clearAllBrowserData() {
		driver.manage().deleteAllCookies();
		((WebStorage) driver).getSessionStorage().clear();
		((WebStorage) driver).getLocalStorage().clear();
//		WebDriver.execute_script('window.localStorage.clear();')
	}
	
}
