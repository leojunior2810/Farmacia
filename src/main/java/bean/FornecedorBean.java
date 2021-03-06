package bean;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.ListDataModel;


import dao.FornecedorDAO;
import model.Fornecedor;

@ManagedBean(name = "MBFornecedor")
@SessionScoped
public class FornecedorBean extends BasicBean {

	private Fornecedor fornecedor;
	private ListDataModel<Fornecedor> itens;


	public Fornecedor getFornecedor() {
		return fornecedor;
	}


	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}


	public ListDataModel<Fornecedor> getItens() {
		return itens;
	}


	public void setItens(ListDataModel<Fornecedor> itens) {
		this.itens = itens;
	}

	@PostConstruct
	public void pesquisa() {
		try {
			FornecedorDAO dao = new FornecedorDAO();
			ArrayList<Fornecedor> lista = dao.listar();
			itens = new ListDataModel<Fornecedor>(lista);
		}catch(SQLException ex) {
			ex.printStackTrace();
		}	
	}

	public void prepararNovo() {
		fornecedor = new Fornecedor();
	}
	
	public void prepararExcluir() {
		fornecedor = itens.getRowData();
	}

	public void prepararAlterar() {
		fornecedor = itens.getRowData();
	}
	
	
	public void novo() {
		try {
			FornecedorDAO dao = new FornecedorDAO();
			dao.incluir(fornecedor);

			ArrayList<Fornecedor> lista = dao.listar();
			itens = new ListDataModel<Fornecedor>(lista);
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
	}


	public void excluir() {
		try {
			FornecedorDAO dao = new FornecedorDAO();
			dao.deletar(fornecedor);

			ArrayList<Fornecedor> lista = dao.listar();
			itens = new ListDataModel<Fornecedor>(lista);

		}catch(SQLException ex) {
			ex.printStackTrace();
		}
	}


	public void alterar() {
		try {
			FornecedorDAO dao = new FornecedorDAO();
			dao.editar(fornecedor);

			ArrayList<Fornecedor> lista = dao.listar();
			itens = new ListDataModel<Fornecedor>(lista);
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
	}



}
