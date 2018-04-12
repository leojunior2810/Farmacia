package model;

import java.sql.Date;

public class Produto {

	private int idPROD;
	private String nome;
	private Date dataProd;
	private String descricao;
	private int qtde;
	private double valorUni;
	private double valorFinal;
	private String obs;
	private String origem;
	private String bula;


	public int getIdPROD() {
		return idPROD;
	}
	public void setIdPROD(int idPROD) {
		this.idPROD = idPROD;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getDataProd() {
		return dataProd;
	}
	public void setDataProd(Date dataProd) {
		this.dataProd = dataProd;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getQtde() {
		return qtde;
	}
	public void setQtde(int qtde) {
		this.qtde = qtde;
	}
	public double getValorUni() {
		return valorUni;
	}
	public void setValorUni(double valorUni) {
		this.valorUni = valorUni;
	}
	public double getValorFinal() {
		return valorFinal;
	}
	public void setValorFinal(double valorFinal) {
		this.valorFinal = valorFinal;
	}
	public String getObs() {
		return obs;
	}
	public void setObs(String obs) {
		this.obs = obs;
	}
	public String getOrigem() {
		return origem;
	}
	public void setOrigem(String origem) {
		this.origem = origem;
	}
	public String getBula() {
		return bula;
	}
	public void setBula(String bula) {
		this.bula = bula;
	}


	public String toString() {
		String saida = idPROD + "-" + nome + "-" + dataProd + "-" + descricao + "-" + qtde + "-" + valorUni + "-" +
				valorFinal + "-" + obs + "-" + origem + "-" + bula;
		return saida;
	}






}
