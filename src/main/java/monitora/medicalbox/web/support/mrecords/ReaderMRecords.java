package monitora.medicalbox.web.support.mrecords;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ReaderMRecords{
    private String path;
    private String split;
    private String line;

    public ReaderMRecords(String path, String split, String line){
        this.path = path;
        this.split = split;
        this.line = line;
    }


    public List<MedicalRecords> readCsv() throws Exception{
        List<MedicalRecords> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            while ((line = br.readLine()) != null) {
                // use comma as separator
                String[] mrecords = line.split(split);
                MedicalRecords test = new MedicalRecords(
                		mrecords[0], 
                		mrecords[1]);
                
                list.add(test);
//                System.out.println("Prontuario ["
//                					+ "nome= " + mrecords[0] + " , getname=" + test.getName() + 
//                					"Texto= " + mrecords[1] + " , getfreetext=" + test.getFreetext() + "]");
             System.out.println(test.toString());
                
               //System.out.println("patient ["+"Numero= " + patient[12] + " , getnumber=" + test.getNumber() + "]" );
               //System.out.println("CPF: " + test.getCpf().length() );
               // System.out.print(StringEscapeUtils.escapeJava(test.getObs()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public static void main(String[] args) {
        String csvFile = "src/main/resources/planilha/PacientesTest.csv";
        String line = "";
        String cvsSplitBy = ",";
        ReaderMRecords reader = new ReaderMRecords(csvFile, cvsSplitBy, line);
        try {
            reader.readCsv();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
