package monitora.medicalbox.web.support;

public class Patient {
	
	private String name;
    private String birth;
    private String gender; //change data type to boolean or enum
    private String cpf;
    private String profession;
    private String marital;
    
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
    private String obs;
    


   public Patient(String name, String birth, String gender, String marital, String cpf, String profession, 
		   String phone, String cellphone, String email, String speak, String cep, String address, String number, String complement, String neighborhood,
		   String city, String state, String obs){
        this.name = name;
        this.birth = birth;
        this.gender = gender;
        this.marital = marital;
        this.cpf = cpf;
        this.profession = profession;
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
	

	public String toString() {
		return "patient ["
                + "name= " + this.getName() +
                "dataNasc= " + this.getBirth() +
                "Sexo= " + this.getGender() +
                "ECivil= " + this.getMarital() +
                "cpf= " +  this.getCpf() +
                "Profissao= " + this.getProfession() +
                "Telefone= " +  this.getPhone() +
                "Celular= " +  this.getCellphone() +
                "Email= " +  this.getEmail() +
                "Falarcom= " +  this.getSpeak() +
                "CEP= " +  this.getCep() +
                "Endereco= " +  this.getAddress() +
                "Numero= " +  this.getNumber() +
                "Complemento= " +  this.getComplement() +
                "Bairro= " +  this.getNeighborhood() +
                "Cidade= " +  this.getCity() +
                "Estado= " +  this.getState() +
                "Obs= " +  this.getObs() +"]";
	}
}
