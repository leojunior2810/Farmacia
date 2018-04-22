package bean;

import java.sql.SQLException;
import java.util.ArrayList;

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




	public void novo() {
		try {
			cliente = new Cliente();
			ClienteDAO dao = new ClienteDAO();
			dao.incluir(cliente);

			ArrayList<Cliente> lista = dao.listar();
			itens = new ListDataModel<Cliente>(lista);
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
	}




	public void excluir() {
		try {
			cliente = itens.getRowData();

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
			cliente = itens.getRowData();
			ClienteDAO dao = new ClienteDAO();
			dao.editar(cliente);

			ArrayList<Cliente> lista = dao.listar();
			itens = new ListDataModel<Cliente>(lista);
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
	}



}
