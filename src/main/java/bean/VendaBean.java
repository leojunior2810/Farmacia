package bean;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.ListDataModel;

import dao.VendaDAO;
import model.Venda;

@ManagedBean(name = "MBVenda")
@ViewScoped
public class VendaBean extends BasicBean {

	private Venda venda;
	private ListDataModel<Venda> itens;


	public Venda getVenda() {
		return venda;
	}


	public void setVenda(Venda venda) {
		this.venda = venda;
	}


	public ListDataModel<Venda> getItens() {
		return itens;
	}


	public void setItens(ListDataModel<Venda> itens) {
		this.itens = itens;
	}

	@PostConstruct
	public void pesquisa() {
		try {
			VendaDAO dao = new VendaDAO();
			ArrayList<Venda> lista = dao.listar();
			itens = new ListDataModel<Venda>(lista);
		}catch(SQLException ex) {
			ex.printStackTrace();
		}	
	}


	public void novo() {
		try {
			venda = new Venda();
			VendaDAO dao = new VendaDAO();
			dao.incluir(venda);

			ArrayList<Venda> lista = dao.listar();
			itens = new ListDataModel<Venda>(lista);
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
	}


	public void excluir() {
		try {
			venda = itens.getRowData();

			VendaDAO dao = new VendaDAO();
			dao.deletar(venda);

			ArrayList<Venda> lista = dao.listar();
			itens = new ListDataModel<Venda>(lista);

		}catch(SQLException ex) {
			ex.printStackTrace();
		}

	}


	public void alterar() {
		try {
			venda = itens.getRowData();
			VendaDAO dao = new VendaDAO();
			dao.editar(venda);

			ArrayList<Venda> lista = dao.listar();
			itens = new ListDataModel<Venda>(lista);
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
	}

}