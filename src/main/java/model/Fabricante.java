package model;

public class Fabricante {

	private int idFABRI;
	private String nome;
	private String cnpj;
	private int tel;
	private String endereco;
	private int numero;
	private String cidade;
	private String complemento;
	private String bairro;
	private int cep;
	private String uf;
	private String email;
	private String obs;
	private String site;


	
	public Fabricante() {
		
	}
	
	
	
	public Fabricante(String nome, String cnpj, int tel, String endereco, int numero, String cidade,
			String complemento, String bairro, int cep, String uf, String email, String obs, String site) {
		this.nome = nome;
		this.cnpj = cnpj;
		this.tel = tel;
		this.endereco = endereco;
		this.numero = numero;
		this.cidade = cidade;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cep = cep;
		this.uf = uf;
		this.email = email;
		this.obs = obs;
		this.site = site;
	}






	public int getIdFABRI() {
		return idFABRI;
	}


	public void setIdFABRI(int idFABRI) {
		this.idFABRI = idFABRI;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public int getTel() {
		return tel;
	}
	public void setTel(int tel) {
		this.tel = tel;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getObs() {
		return obs;
	}
	public void setObs(String obs) {
		this.obs = obs;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}


	@Override
	public String toString() {
		String saida = idFABRI + "-" + nome + "-" + cnpj + "-" + tel + "-" + endereco + "-" + "-" + numero + "-" +
		cidade + "-" + complemento + "-" + bairro + "-" + cep + "-" + uf + "-" + email + "-" + obs + "-" + site;		
		return saida;

	}


	

}
