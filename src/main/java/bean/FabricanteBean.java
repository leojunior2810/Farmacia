package bean;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.model.ListDataModel;

import dao.FabricanteDAO;
import model.Fabricante;

@ManagedBean(name = "MBFabricante")
@SessionScoped
public class FabricanteBean extends BasicBean {
	private Fabricante fabricante;
	private ListDataModel<Fabricante> itens;

	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

	public ListDataModel<Fabricante> getItens() {
		return itens;
	}

	public void setItens(ListDataModel<Fabricante> itens) {
		this.itens = itens;
	}

	@PostConstruct
	public void pesquisa() {
		try {
			FabricanteDAO dao = new FabricanteDAO();
			ArrayList<Fabricante> lista = dao.listar();
			itens = new ListDataModel<Fabricante>(lista);
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	
	public void prepararNovo() {
		fabricante = new Fabricante();
	}
	
	public void novo() {
		try {
			FabricanteDAO dao = new FabricanteDAO();
			dao.incluir(fabricante);

			ArrayList<Fabricante> lista = dao.listar();
			itens = new ListDataModel<Fabricante>(lista);
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
	}

	public void excluir() {
		try {
			fabricante = itens.getRowData();

			FabricanteDAO dao = new FabricanteDAO();
			dao.deletar(fabricante);

			ArrayList<Fabricante> lista = dao.listar();
			itens = new ListDataModel<Fabricante>(lista);

		}catch(SQLException ex) {
			ex.printStackTrace();
		}
	}

	public void alterar() {
		try {
			fabricante = itens.getRowData();
			FabricanteDAO dao = new FabricanteDAO();
			dao.editar(fabricante);

			ArrayList<Fabricante> lista = dao.listar();
			itens = new ListDataModel<Fabricante>(lista);
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
	}

}
