package model;

import java.sql.Date;

public class Pagamento {

	String nomeCliente;
	int valorTotal;
	Date dtVenda;
	
	
	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	public int getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(int valorTotal) {
		this.valorTotal = valorTotal;
	}
	public Date getDtVenda() {
		return dtVenda;
	}
	public void setDtVenda(Date dtVenda) {
		this.dtVenda = dtVenda;
	}
	
	
	
	
}
