package model;

import java.sql.Date;

public class Cliente {

	private int idCLIENTE;
	private String nome;
	private Date dta_nasc;
	private String cpf;
	private String rg;
	private int tel;
	private int cel;
	private String endereco;
	private int numCasa;
	private String complemento;
	private String bairro;
	private String cidade;
	private int cep;
	private String uf;
	private String sexo;
	private String email;
	private Date dtaCadastro;
	
	
	public Cliente(String nome, String cpf, String rg, int tel, int cel, String endereco, int numCasa,String complemento,String bairro,String cidade,int cep,String uf,String sexo,String email,Date dtaCadastro) {
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.tel = tel;
		this.cel = cel;
		this.endereco = endereco;
		this.numCasa = numCasa;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.cep = cep;
		this.uf = uf;
		this.sexo = sexo;
		this.email = email;
		this.dtaCadastro = dtaCadastro;
		
	}

	

	public int getIdCLIENTE() {
		return idCLIENTE;
	}


	public void setIdCLIENTE(int idCLIENTE) {
		this.idCLIENTE = idCLIENTE;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public Date getDta_nasc() {
		return dta_nasc;
	}


	public void setDta_nasc(Date dta_nasc) {
		this.dta_nasc = dta_nasc;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public String getRg() {
		return rg;
	}


	public void setRg(String rg) {
		this.rg = rg;
	}


	public int getTel() {
		return tel;
	}


	public void setTel(int tel) {
		this.tel = tel;
	}


	public int getCel() {
		return cel;
	}


	public void setCel(int cel) {
		this.cel = cel;
	}


	public String getEndereco() {
		return endereco;
	}


	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}


	public int getNumCasa() {
		return numCasa;
	}


	public void setNumCasa(int numCasa) {
		this.numCasa = numCasa;
	}


	public String getComplemento() {
		return complemento;
	}


	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}


	public String getBairro() {
		return bairro;
	}


	public void setBairro(String bairro) {
		this.bairro = bairro;
	}


	public String getCidade() {
		return cidade;
	}


	public void setCidade(String cidade) {
		this.cidade = cidade;
	}


	public int getCep() {
		return cep;
	}


	public void setCep(int cep) {
		this.cep = cep;
	}


	public String getUf() {
		return uf;
	}


	public void setUf(String uf) {
		this.uf = uf;
	}


	public String getSexo() {
		return sexo;
	}


	public void setSexo(String sexo) {
		this.sexo = sexo;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Date getDtaCadastro() {
		return dtaCadastro;
	}


	public void setDtaCadastro(Date dtaCadastro) {
		this.dtaCadastro = dtaCadastro;
	}
	
	
	
	
	
	
	
	
	
}
