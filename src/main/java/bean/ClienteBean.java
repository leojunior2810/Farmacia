package bean;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.ListDataModel;

import dao.ClienteDAO;
import model.Cliente;




@ManagedBean(name = "MBCliente")
@SessionScoped
public class ClienteBean extends BasicBean {
	private Cliente cliente;
	private ListDataModel<Cliente> itens;
	private Date dataCadastro = new Date();


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public ListDataModel<Cliente> getItens() {
		return itens;
	}


	public void setItens(ListDataModel<Cliente> itens) {
		this.itens = itens;
	}

	@PostConstruct
	public void pesquisa() {
		try {
			ClienteDAO dao = new ClienteDAO();
			ArrayList<Cliente> lista = dao.listar();
			itens = new ListDataModel<Cliente>(lista);
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
	}



	public void prepararNovo() {
		cliente = new Cliente();
	}
	
	public void prepararExcluir() {
		cliente = itens.getRowData();
	}
	
	public void prepararAlterar() {
		cliente = itens.getRowData();
	}
	

	public void novo() {
		try {
			ClienteDAO dao = new ClienteDAO();
			cliente.setDtaCadastro(new java.sql.Date(dataCadastro.getTime()));
			dao.incluir(cliente);

			ArrayList<Cliente> lista = dao.listar();
			itens = new ListDataModel<Cliente>(lista);
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
	}




	public void excluir() {
		try {

			ClienteDAO dao = new ClienteDAO();
			dao.deletar(cliente);

			ArrayList<Cliente> lista = dao.listar();
			itens = new ListDataModel<Cliente>(lista);

		}catch(SQLException ex) {
			ex.printStackTrace();
		}
	}

	public void alterar() {
		try {
			ClienteDAO dao = new ClienteDAO();
			dao.editar(cliente);

			ArrayList<Cliente> lista = dao.listar();
			itens = new ListDataModel<Cliente>(lista);
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
	}


	public Date getDataCadastro() {
		return dataCadastro;
	}


	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

}
