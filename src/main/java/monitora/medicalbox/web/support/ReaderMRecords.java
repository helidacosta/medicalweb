package monitora.medicalbox.web.support;

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
//                System.out.println("patient ["
//                + "nome= " + patient[0] + " , getname=" + test.getName() + 
//                "dataNasc= " + patient[1] + " , getbirth=" + test.getBirth() +
//                "Sexo= " + patient[2] + " , getgender=" + test.getGender() +
//                "ECivil= " + patient[3] + " , getmarital=" + test.getMarital() +
//                "cpf= " + patient[4] + " , getcpf=" + test.getCpf() +
//                "Profissao= " + patient[5] + " , getprofessional=" + test.getProfession() +
//                "Telefone= " + patient[6] + " , getphone=" + test.getPhone() +
//                "Celular= " + patient[7] + " , getcellphone=" + test.getCellphone() +
//                "Email= " + patient[8] + " , getemail=" + test.getEmail() +
//                "Falarcom= " + patient[9] + " , getspeak=" + test.getSpeak() +
//                "CEP= " + patient[10] + " , getcep=" + test.getCep() +
//                "Endereco= " + patient[11] + " , getaddress=" + test.getAddress() +
//                "Numero= " + patient[12] + " , getnumber=" + test.getNumber() +
//                "Complemento= " + patient[13] + " , getcomp=" + test.getComplement() +
//                "Bairro= " + patient[14] + " , getneighborhood=" + test.getNeighborhood() +
//                "Cidade= " + patient[15] + " , getcity=" + test.getCity() +
//                "Estado= " + patient[16] + " , getstate=" + test.getState() +
//                "Obs= " + patient[17] + " , getobs=" + test.getObs() +
//                		
//                		"]");
              //System.out.println(test.toString());
                
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
        String csvFile = "src/main/resources/planilha/Pacientes_Barizza_Prontos.csv";
        String line = "";
        String cvsSplitBy = ";";
        ReaderMRecords reader = new ReaderMRecords(csvFile, cvsSplitBy, line);
        try {
            reader.readCsv();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
