package monitora.medicalbox.web.support.patient;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringEscapeUtils;

public class ReaderPatient{

    private String path;
    private String split;
    private String line;

    public ReaderPatient(String path, String split, String line){
        this.path = path;
        this.split = split;
        this.line = line;
    }

    public List<Patient> readCsv() throws Exception{
        List<Patient> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            while ((line = br.readLine()) != null) {
                // use comma as separator
                String[] patient = line.split(split);
                Patient test = new Patient(
                		patient[0], 
                		patient[1], 
                		patient[2], 
                		patient[3], 
                		patient[4],
                		patient[5],
                		patient[6],
                		patient[7],
                		patient[8],
                		patient[9],
                		patient[10],
                		patient[11],
                		patient[12],
                		patient[13],
                		patient[14],
                		patient[15],
                		patient[16],
                		patient[17],
                		patient[18],
                		patient[19],
                		patient[20],
                		patient[21],
                		patient[22],
                		patient[23],
                		patient[24],
                		patient[25],
                		patient[26],
                		patient[27]);
                
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
        String csvFile = "src/main/resources/planilha/Pacientes_Barizza_Prontos.csv";
        String line = "";
        String cvsSplitBy = ",";
        ReaderPatient reader = new ReaderPatient(csvFile, cvsSplitBy, line);
        try {
            reader.readCsv();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
