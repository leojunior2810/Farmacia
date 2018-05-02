package bean;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.ListDataModel;

import dao.FuncionarioDAO;
import model.Funcionario;


@ManagedBean(name = "MBFuncionario")
@SessionScoped
public class FuncionarioBean extends BasicBean {

	private Funcionario funcionario;
	private ListDataModel<Funcionario> itens;


	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public ListDataModel<Funcionario> getItens() {
		return itens;
	}

	public void setItens(ListDataModel<Funcionario> itens) {
		this.itens = itens;
	}

	@PostConstruct
	public void pesquisa() {
		try {
			FuncionarioDAO dao = new FuncionarioDAO();
			ArrayList<Funcionario> lista = dao.listar();
			itens = new ListDataModel<Funcionario>(lista);
		}catch(SQLException ex) {
			ex.printStackTrace();
		}	
	}

	public void prepararNovo() {
		funcionario = new Funcionario();
	}
	
	public void prepararExcluir() {
		funcionario = itens.getRowData();
	}

	public void prepararAlterar() {
		funcionario = itens.getRowData();
	}
	

	public void novo() {
		try {
			FuncionarioDAO dao = new FuncionarioDAO();
			dao.incluir(funcionario);

			ArrayList<Funcionario> lista = dao.listar();
			itens = new ListDataModel<Funcionario>(lista);
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
	}


	public void excluir() {
		try {
			FuncionarioDAO dao = new FuncionarioDAO();
			dao.deletar(funcionario);

			ArrayList<Funcionario> lista = dao.listar();
			itens = new ListDataModel<Funcionario>(lista);

		}catch(SQLException ex) {
			ex.printStackTrace();
		}
	}


	public void alterar() {
		try {
			FuncionarioDAO dao = new FuncionarioDAO();
			dao.editar(funcionario);

			ArrayList<Funcionario> lista = dao.listar();
			itens = new ListDataModel<Funcionario>(lista);
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
	}

}
