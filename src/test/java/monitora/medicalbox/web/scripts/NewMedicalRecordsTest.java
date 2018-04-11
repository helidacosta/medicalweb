package monitora.medicalbox.web.scripts;

import java.net.MalformedURLException;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import monitora.medicalbox.web.po.MainScreenPageObject;
import monitora.medicalbox.web.po.MedicalRecordsPageObject;
import monitora.medicalbox.web.po.PatientPageObject;
import monitora.medicalbox.web.support.ReaderMRecords;
import monitora.medicalbox.web.support.MedicalRecords;
import monitora.medicalbox.web.support.Utils;

public class NewMedicalRecordsTest {
	
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
	public void testMedicalRecords() {
	    MainScreenPageObject mainscreen = new MainScreenPageObject(driver);
		PatientPageObject patients = new PatientPageObject(driver);
		MedicalRecordsPageObject mrecords = new MedicalRecordsPageObject(driver);
	    
		ReaderMRecords reader = new ReaderMRecords(csvFile, cvsSplitBy, line);
		int count = 0;
		try {
			List<MedicalRecords> MRecords = reader.readCsv();
			for(MedicalRecords medicalrecords:MRecords) {
					
				mainscreen.clickBtnMedicalRecords();
				patients.fillSearchPatient(medicalrecords.getName());
				patients.clickPatient();
	    
				if(mrecords.getBtnCreatePEP()){
					mrecords.clickBtnCreatePEP();
				}
	    
				mrecords.fillFreeText(medicalrecords.getFreetext());
				mrecords.clickBtnConcluir();
				mrecords.clickBtnSim();
				
				mainscreen.clickBtnRemovePacients();
	    
			}
		} catch (Exception e) {e.printStackTrace();}
   	}

}
