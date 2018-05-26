package monitora.medicalbox.web.support.patient.importa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ReaderPatientImporta {
	
	 private String path;
	    private String split;
	    private String line;

	    public ReaderPatientImporta(String path, String split, String line){
	        this.path = path;
	        this.split = split;
	        this.line = line;
	    }

	    public List<PatientImporta> readCsv() throws Exception{
	        List<PatientImporta> list = new ArrayList<>();
	        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
	            while ((line = br.readLine()) != null) {
	                // use comma as separator
	                String[] patientimporta = line.split(split);
	         		PatientImporta patientimp = new PatientImporta(
	                   		patientimporta[0],
                		    patientimporta[1], 
	             		    patientimporta[2],
	                		patientimporta[3], 
	                		patientimporta[4],
	                		patientimporta[5],
	                		patientimporta[6],
	                		patientimporta[7],
	                		patientimporta[8],
	                		patientimporta[9],
	                		patientimporta[10],
	                		patientimporta[11],
	                		patientimporta[12],
	                		patientimporta[13],
	                		patientimporta[14],
	                		patientimporta[15],
	                		patientimporta[16],
	                		patientimporta[17],
	                		patientimporta[18]);
	                
	               list.add(patientimp);
                   //System.out.println(patientimp.toString());
	               
	              // System.out.println("patient ["+"Pontuario= " + patientimporta[18] + " , getpronto=" + patientimp.getMrecords() + "]" );
	
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return list;
	    }
	    public static void main(String[] args) {
	        String csvFile = "src/main/resources/planilha/pacientespronto.csv";
	        String line = "";
	        String cvsSplitBy = ";";
	        ReaderPatientImporta reader = new ReaderPatientImporta(csvFile, cvsSplitBy, line);
	        try {
	            reader.readCsv();
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

}
