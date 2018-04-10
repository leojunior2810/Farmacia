package model;

import java.sql.Date;

public class Funcionario extends Cliente {
	
	
	public Funcionario() {
		
	}

	public Funcionario(String nome, String cpf, String rg, int tel, int cel, String endereco, int numCasa,
			String complemento, String bairro, String cidade, int cep, String uf, String sexo, String email,
			Date dtaCadastro) {
	//	super(nome, cpf, rg, tel, cel, endereco, numCasa, complemento, bairro, cidade, cep, uf, sexo, email, dtaCadastro);
	}
	
	private int idFUNC;
	private String usuario;
	private String senha;
	
	
	
	public int getIdFUNC() {
		return idFUNC;
	}

	public void setIdFUNC(int idFUNC) {
		this.idFUNC = idFUNC;
	}

	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

	
	





}
