package monitora.medicalbox.web.scripts.importa;

import java.net.MalformedURLException;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import monitora.medicalbox.web.po.MedicalRecordsPageObject;
import monitora.medicalbox.web.po.mainscreen.MainScreenPageObject;
import monitora.medicalbox.web.po.patient.PatientPageObject;
import monitora.medicalbox.web.support.Utils;
import monitora.medicalbox.web.support.mrecords.MedicalRecords;
import monitora.medicalbox.web.support.mrecords.ReaderMRecords;

public class NewMedicalRecordsTest {
	
	private WebDriver driver;
    private String csvFile = "src/main/resources/planilha/ProntuarioTest.csv";
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
	public void testMedicalRecords() {
	    MainScreenPageObject mainscreen = new MainScreenPageObject(driver);
		PatientPageObject patients = new PatientPageObject(driver);
		MedicalRecordsPageObject medRecords = new MedicalRecordsPageObject(driver);
	    
		ReaderMRecords reader = new ReaderMRecords(csvFile, cvsSplitBy, line);
		try {
			
			List<MedicalRecords> MRecords = reader.readCsv();
			
			for(MedicalRecords mrecords:MRecords) {
					
				mainscreen.clickBtnMedicalRecords();
				patients.fillSearchPatient(mrecords.getName());
				patients.clickPatient();
	    
				if(medRecords.getBtnCreatePEP()){
					medRecords.clickBtnCreatePEP();
				}
	    
				medRecords.fillFreeText(mrecords.getFreetext());
				medRecords.clickBtnConcluir();
				medRecords.clickBtnSim();
				
				mainscreen.clickBtnRemovePacients();
	    
			}
		} catch (Exception e) {e.printStackTrace();}
   	}

}
