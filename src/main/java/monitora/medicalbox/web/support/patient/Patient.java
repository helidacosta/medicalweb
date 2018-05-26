package monitora.medicalbox.web.support.patient;

public class Patient {
	
	private String name;
    private String birth;
    private String gender;
    private String rg;//change data type to boolean or enum
    private String cpf;
    private String marital;
    private String profession;
    private String indication;

    
    private String phone;
    private String cellphone;
    private String email;
    private String speak;
    
    private String cep;
    private String address;
    private String state;
    private String city;
    private String neighborhood;
    private String number;
    private String complement;
  
    
    private String shealth;
    private String numbershealth;
    private String valcard;
    private String company;
    private String obsshealth;
    
    private String firstcon;
    private String deathdate;
    private String codigo;
    private String obs;    


   public Patient(String name, String birth, String gender, String rg, String cpf, String marital, String profession, String indication,
		   		  String phone, String cellphone, String email, String speak, 
		   		  String cep, String address, String number, String complement, String neighborhood, String city, String state, 
		   		  String shealth, String numbershealth, String valcard, String company, String obsshealth, 
		   		  String firstcon,  String deathdate, String codigo, String obs){
        this.name = name;
        this.birth = birth;
        this.gender = gender;
        this.rg = rg;
        this.cpf = cpf;
        this.marital = marital;
        this.profession = profession;
        this.indication = indication;
        this.phone = phone;
        this.cellphone = cellphone;
        this.email = email;
        this.speak = speak;
        this.cep = cep;
        this.address = address;
        this.number = number;
        this.complement = complement;
        this.neighborhood = neighborhood;
        this.city = city;
        this.state = state;
        this.shealth = shealth;
        this.numbershealth = numbershealth;
        this.valcard = valcard;
        this.company = company;
        this.obsshealth = obsshealth;
        this.firstcon = firstcon;
        this.deathdate = deathdate;
        this.codigo = codigo;
        this.obs = obs;	        
    }
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
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

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getMarital() {
		return marital;
	}

	public void setMarital(String marital) {
		this.marital = marital;
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

	public String getSpeak() {
		return speak;
	}

	public void setSpeak(String speak) {
		this.speak = speak;
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

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}	
	
	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getIndication() {
		return indication;
	}

	public void setIndication(String indication) {
		this.indication = indication;
	}

	public String getShealth() {
		return shealth;
	}

	public void setShealth(String shealth) {
		this.shealth = shealth;
	}

	public String getNumbershealth() {
		return numbershealth;
	}

	public void setNumbershealth(String numbershealth) {
		this.numbershealth = numbershealth;
	}

	public String getValcard() {
		return valcard;
	}

	public void setValcard(String valcard) {
		this.valcard = valcard;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getObsshealth() {
		return obsshealth;
	}

	public void setObsshealth(String obsshealth) {
		this.obsshealth = obsshealth;
	}

	public String getFirstcon() {
		return firstcon;
	}

	public void setFirstcon(String firstcon) {
		this.firstcon = firstcon;
	}

	public String getDeathdate() {
		return deathdate;
	}

	public void setDeathdate(String deathdate) {
		this.deathdate = deathdate;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String toString() {
		return "patient ["
                + "nome= " + this.getName() +
                "dataNasc= " + this.getBirth() +
                "sexo= " + this.getGender() +
                "rg= " + this.getRg() +
                "cpf= " +  this.getCpf() +
                "ecivil= " + this.getMarital() +
                "profissao= " + this.getProfession() +
                "indicação= " + this.getIndication() +
                "telefone= " +  this.getPhone() +
                "celular= " +  this.getCellphone() +
                "email= " +  this.getEmail() +
                "falarcom= " +  this.getSpeak() +
                "CEP= " +  this.getCep() +
                "endereco= " +  this.getAddress() +
                "numero= " +  this.getNumber() +
                "complemento= " +  this.getComplement() +
                "bairro= " +  this.getNeighborhood() +
                "cidade= " +  this.getCity() +
                "estado= " +  this.getState() +
                "covênio= " + this.getShealth() +
                "número cartão= " + this.getNumbershealth() +
                "validade cartão= " + this.getValcard() +
                "empresa= " + this.getCompany() +
                "obs convênio= " + this.getObsshealth() +
                "primeira consulta= " + this.getFirstcon() +
                "falecimento= " + this.getDeathdate() +
                "código= " + this.getCodigo() +
                "obs= " +  this.getObs() +"]";
	}
}
