package monitora.medicalbox.web.support.mrecords;

public class MedicalRecords {

	private String name;
    private String freetext;
    
    public MedicalRecords(String name, String freetext){
         this.name = name;
         this.freetext = freetext;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFreetext() {
		return freetext;
	}

	public void setFreetext(String freetext) {
		this.freetext = freetext;
	}    
	
	public String toString() {
		return "paciente ["
	            + "nome= " + this.getName() +
	            " prontuario= " + this.freetext +
	            "]";
	}
}
