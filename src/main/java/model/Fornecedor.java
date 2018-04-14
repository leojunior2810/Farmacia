package model;

public class Fornecedor extends Fabricante {


	private int idFORNE;
	
	
	public int getIdFORNE() {
		return idFORNE;
	}


	public void setIdFORNE(int idFORNE) {
		this.idFORNE = idFORNE;
	}


	public Fornecedor() {

	}


	public Fornecedor(String nome, String cnpj, int tel, String endereco, int numero, String cidade,
			String complemento, String bairro, int cep, String uf, String email, String obs, String site) {
	
	}

	public String toString() {
		String saida = idFORNE + "-" + getNome() + "-" + getCnpj();
		
		return saida;
	}
	
	
	
}
