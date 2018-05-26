package monitora.medicalbox.web.support.patient.importa;

public class PatientImporta{

	private String name;
    private String birth;
    private String gender;
    private String cpf;
    private String marital;
    private String profession;
    
    private String phone;
    private String cellphone;
    private String email;
    
    private String cep;
    private String address;
    private String number;
    private String complement;
    private String neighborhood;
    private String city;
    private String state;

    private String codigo;
    private String obs;   
    private String mrecords;

   public PatientImporta(String name, String birth, String gender, String cpf, String marital, String profession, 
	          String phone, String cellphone, String email, 
	   		  String cep, String address, String number, String complement, String neighborhood, String city, String state, 
	   		  String codigo, String obs, String mrecords){
	   
        this.name = name;
        this.birth = birth;
        this.gender = gender;
        this.cpf = cpf;
        this.marital = marital;
        this.profession = profession;
        this.phone = phone;
        this.cellphone = cellphone;
        this.email = email;
        this.cep = cep;
        this.address = address;
        this.number = number;
        this.complement = complement;
        this.neighborhood = neighborhood;
        this.city = city;
        this.state = state;
        this.codigo = codigo;
        this.obs = obs;	    
        this.mrecords = mrecords;
    }


public String getName() {
	return name;
}


public void setName(String name) {
	this.name = name;
}


public String getBirth() {
	return birth;
}


public void setBirth(String birth) {
	this.birth = birth;
}


public String getGender() {
	return gender;
}


public void setGender(String gender) {
	this.gender = gender;
}


public String getCpf() {
	return cpf;
}


public void setCpf(String cpf) {
	this.cpf = cpf;
}


public String getMarital() {
	return marital;
}


public void setMarital(String marital) {
	this.marital = marital;
}


public String getProfession() {
	return profession;
}


public void setProfession(String profession) {
	this.profession = profession;
}


public String getPhone() {
	return phone;
}


public void setPhone(String phone) {
	this.phone = phone;
}


public String getCellphone() {
	return cellphone;
}


public void setCellphone(String cellphone) {
	this.cellphone = cellphone;
}


public String getEmail() {
	return email;
}


public void setEmail(String email) {
	this.email = email;
}


public String getCep() {
	return cep;
}


public void setCep(String cep) {
	this.cep = cep;
}


public String getAddress() {
	return address;
}


public void setAddress(String address) {
	this.address = address;
}


public String getState() {
	return state;
}


public void setState(String state) {
	this.state = state;
}


public String getCity() {
	return city;
}


public void setCity(String city) {
	this.city = city;
}


public String getNeighborhood() {
	return neighborhood;
}


public void setNeighborhood(String neighborhood) {
	this.neighborhood = neighborhood;
}


public String getNumber() {
	return number;
}


public void setNumber(String number) {
	this.number = number;
}


public String getComplement() {
	return complement;
}


public void setComplement(String complement) {
	this.complement = complement;
}


public String getCodigo() {
	return codigo;
}


public void setCodigo(String codigo) {
	this.codigo = codigo;
}


public String getObs() {
	return obs;
}


public void setObs(String obs) {
	this.obs = obs;
}


public String getMrecords() {
	return mrecords;
}


public void setMrecords(String mrecords) {
	this.mrecords = mrecords;
}

public String toString() {
	return "patient ["
            + "nome= " + this.getName() +
            "dataNasc= " + this.getBirth() +
            "sexo= " + this.getGender() +
            "cpf= " +  this.getCpf() +
            "ecivil= " + this.getMarital() +
            "profissao= " + this.getProfession() +
             "telefone= " +  this.getPhone() +
            "celular= " +  this.getCellphone() +
            "email= " +  this.getEmail() +
            "CEP= " +  this.getCep() +
            "endereco= " +  this.getAddress() +
            "numero= " +  this.getNumber() +
            "complemento= " +  this.getComplement() +
            "bairro= " +  this.getNeighborhood() +
            "cidade= " +  this.getCity() +
            "estado= " +  this.getState() +
            "código= " + this.getCodigo() +
            "obs= " +  this.getObs() +
            "prontuario= " +  this.getMrecords() +
            "]";
}

   
}
